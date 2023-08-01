package com.ohgiraffers.CRUD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class MenuCreate {
    public static void main (String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;

        Scanner sc = new Scanner(System.in);
        System.out.println( "검색할 음식의 이름을 입력하세요.");
        System.out.println("음식 이름 : ");
        String name = sc.nextLine();




        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/comm/ohgiraffers/mapper/nenu-query.xml/"));

            String query = prop.getProperty("insertMenu");


            pstmt = con.prepareStatement(query);

            pstmt.setString(1,"돼지국밥");
            pstmt.setInt(2,8000);
            pstmt.setInt(3,4);
            pstmt.setString(4,"Y");


            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }

    }

}
