package ru.mrsnuff.powerly.model;

public class Computer {

    private String name;
    private String ip;
    private String status;

    private String user;
    private String password;

    public Computer() {}

    public Computer(String name, String ip, String status, String user, String password) {
        this.name = name;
        this.ip = ip;
        this.status = status;

        this.user = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
