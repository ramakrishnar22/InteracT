package com.example.rams.interact;

import java.util.Date;

public class Messages {
    String msg;
    String user;
    String time;

    public Messages(String msg, String user, String time) {
        this.msg = msg;
        this.user = user;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
