package com.osmeet.os.model.net.utils;

import com.osmeet.os.app.java.RSAUtil;
import com.osmeet.os.app.java.base64.Base64Util;

/**
 * Created by yyj on 2019/01/17. email: 2209011667@qq.com
 */

public class RSA {
    public static final String PUBLIC_KEY =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsxGZPKO3dBQZ9gG7xleUUkUFt" +
                    "j6j/UmcId4f+Oicdud7jWZ0rlOC0fG1oN6po6v3s5Ubq1uoPogoVxWD4qezU815s" +
                    "U5RGNAQeADEPL1OJ+1DtXL1PcxuEJNWAg8LgO72PJQlkzbWArCgp0bI60Et0pK1g" +
                    "ZEQIcRRIFviGli+woQIDAQAB";

    public static String encrypt(String s) {
        if (s == null) return null;
        String r = null;
        try {
            byte[] bytes = RSAUtil.encryptByRSA(Base64Util.decode(RSA.PUBLIC_KEY), s.getBytes());
            r = Base64Util.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
