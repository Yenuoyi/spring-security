package com.liby.springmvc.domain;

public class UserBean {
    private int id;
    private String username;
    private String password;
    private String roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(",\"username\":\"").append(username).append('\"');
        sb.append(",\"password\":\"").append(password).append('\"');
        sb.append(",\"roles\":\"").append(roles).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
