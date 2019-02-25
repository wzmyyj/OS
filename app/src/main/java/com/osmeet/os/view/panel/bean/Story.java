package com.osmeet.os.view.panel.bean;

import com.osmeet.os.app.bean.FileInfo;
import com.osmeet.os.app.bean.User;

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
}
