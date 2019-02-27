package com.osmeet.os.app.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2018/12/11. email: 2209011667@qq.com
 */

public class Story {
    private User user;
    private FileInfo photo;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FileInfo getPhoto() {
        return photo;
    }

    public void setPhoto(FileInfo photo) {
        this.photo = photo;
    }


    public static List<Story> testList(int n) {
        List<Story> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Story());
        }
        return list;
    }
}
