package com.osmeet.os.app.utils;

import com.osmeet.os.app.bean.Code;

/**
 * Created by yyj on 2019/01/27.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class OsCodeUtil {

    public String encode(Code code) {
        if (code == null) return null;

        return "";
    }

    public Code decode(String s) {
        if (s == null) return null;
        Code code = new Code();
        if (!s.contains(Code.CODE_BEGIN)) {
            code.setType(Code.CODE_UN_KNOW);
        } else if (s.contains("userId")) {
            code.setType(Code.CODE_USER_ID);
        } else if (s.contains("storeId")) {
            code.setType(Code.CODE_STORE_ID);
        } else if (s.contains("goodsId")) {
            code.setType(Code.CODE_GOODS_ID);
        }else{
            code.setType(Code.CODE_OS_BUT_USELESS);
        }
        return code;
    }
}
