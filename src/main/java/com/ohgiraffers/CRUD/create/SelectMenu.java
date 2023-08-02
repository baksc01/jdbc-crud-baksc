package com.ohgiraffers.CRUD.create;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class SelectMenu {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            Scanner sc = new Scanner(System.in);
            System.out.println("검색할 음식의 이름을 입력하세요.");
            System.out.println("음식 이름 : ");

            String manuName = sc.nextLine();

            String query = prop.getProperty("selectMenu");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, manuName);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String menuName = rs.getString("MENU_NAME");
                int menuPrice = rs.getInt("MENU_PRICE");
                int menuCode = rs.getInt("MENU_CODE");

                System.out.println(menuName + " 의 번호는" + menuCode + "번 이고 가격은" + menuPrice + "원 입니다.");

            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
            close(rs);
        }
    }
}
