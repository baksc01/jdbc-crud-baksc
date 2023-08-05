package com.ohgiraffers.CRUD.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class InsertMenu {
    public static void main (String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int rs = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("추가할 음식을 입력하세요");
        System.out.println("음식 이름은? ");
        String menuName = sc.nextLine();
        System.out.println("음식 가격은? ");
        String menuPrice = sc.nextLine();
        System.out.println("음식 카테고리는? (1.식사 2.음료 3.디저트 4.한식 5.중식) ");
        String categoryCode = sc.nextLine();
        System.out.println("주문 가능? (Y or N) ");
        String orderableStatus = sc.nextLine();



        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml/"));

            String query = prop.getProperty("insertMenu");

            System.out.println("query : " + query);


            pstmt = con.prepareStatement(query);

            pstmt.setString(1,menuName);
            pstmt.setInt(2,Integer.parseInt(menuPrice));
            pstmt.setInt(3,Integer.parseInt(categoryCode));
            pstmt.setString(4,orderableStatus);

            rs = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
            close(pstmt);
        }

        System.out.println("result : " + rs );

    }

}
