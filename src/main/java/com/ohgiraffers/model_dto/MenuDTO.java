package com.ohgiraffers.model_dto;

public class MenuDTO implements java.io.Serializable {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private String orderableStatus;
    private int categoryCode;

    public MenuDTO() {
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", orderableStatus='" + orderableStatus + '\'' +
                ", categoryCode=" + categoryCode +
                '}';
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public MenuDTO(int menuCode, String menuName, int menuPrice, String orderableStatus, int categoryCode) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.orderableStatus = orderableStatus;
        this.categoryCode = categoryCode;
    }
}
