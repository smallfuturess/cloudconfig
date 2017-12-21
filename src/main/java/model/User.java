package model;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

/**
 * model.User :
 *
 * @author zhang.lei
 * @version 1.00
 * @since 2017/12/12 20:48
 */
public class User {
    String name;
    String password;
    String pword;

    public User(String name, String password, String pword) {
        this.name = name;
        this.password = password;
        this.pword = pword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }
}