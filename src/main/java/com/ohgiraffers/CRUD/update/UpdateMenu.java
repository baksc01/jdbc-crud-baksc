package com.ohgiraffers.CRUD.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class UpdateMenu {
    public static void main(String[] args) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int rs = 0;

        Properties prop = new Properties();

        Scanner sc = new Scanner(System.in);

        System.out.println("메뉴명 입력 : ");
        String menuName = sc.nextLine();
        System.out.println("메뉴 가격 : ");
        String menuPrice = sc.nextLine();
        System.out.println("메뉴 카테고리  : ");
        String categoryCode = sc.nextLine();
        System.out.println("메뉴 주문 가능상태 (Y , N) : ");
        String orderableStatus = sc.nextLine();
        System.out.println("수정하는 음식 번호 : ");
        String menuCode = sc.nextLine();




        try {
            prop.loadFromXML(new FileInputStream("src/main/java/comm/ohgiraffers/mapper/nenu-query.xml/"));

            String query = prop.getProperty("updateMenu");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,menuName);
            pstmt.setInt(2,Integer.parseInt(menuPrice));
            pstmt.setInt(3,Integer.parseInt(categoryCode));
            pstmt.setString(4,orderableStatus);
            pstmt.setInt(5,Integer.parseInt(menuCode));


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
