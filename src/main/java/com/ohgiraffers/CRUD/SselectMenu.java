package com.ohgiraffers.CRUD;

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

public class SselectMenu {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println( "검색할 음식의 이름을 입력하세요.");
        System.out.println( "음식 이름 : ");
        String myName = sc.nextLine();

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("selectMenu");
            System.out.println();

            pstmt = con.prepareStatement(query);




        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }



    }
}
