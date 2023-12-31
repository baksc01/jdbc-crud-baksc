package com.ohgiraffers.CRUD.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class DeleteMenu {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int rs = 0;


        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 메뉴는 몇번입니까?");
        System.out.println("메뉴 번호 : ");
        String menuCode = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml/"));
            String query = prop.getProperty("deleteMenu");

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(menuCode));

            rs = pstmt.executeUpdate();



        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }
        System.out.println("result = " + rs);
    }
}
