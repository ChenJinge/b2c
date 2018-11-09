package com.bargains.entity;

public class MerchantEntity {
    private Integer id;

    private String name;

    private String shopName;

    private String account;

    private String password;

    private String runScope;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRunScope() {
        return runScope;
    }

    public void setRunScope(String runScope) {
        this.runScope = runScope;
    }
}