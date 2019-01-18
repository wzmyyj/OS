package top.wzmyyj.wzm_sdk.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by yyj on 2018/08/20.
 *
 * SharedPreferences封装类。
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class P {

    /**
     * Default NAME
     */
    private static final String NAME = "WZM_P";

    private SharedPreferences sha;
    private SharedPreferences.Editor ed;

    /**
     * @param context .
     * @param name .
     */
    @SuppressLint("CommitPrefEdits")
    public P(Context context, String name) {
        sha = context.getSharedPreferences(name, Activity.MODE_PRIVATE);
        ed = sha.edit();
    }

    /**
     * @param context .
     */
    public P(Context context) {
        this(context, NAME);
    }

    /**
     * @param context .
     * @param name .
     * @return P
     */
    public static P create(Context context, String name) {
        return new P(context, name);
    }

    public static P create(Context context) {
        return new P(context);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sha.getBoolean(key, defValue);
    }

    /**
     * @param key .
     * @param defValue .
     * @return int
     */
    public int getInt(String key, int defValue) {
        return sha.getInt(key, defValue);
    }

    /**
     * @param key .
     * @param defValue .
     * @return long
     */
    public long getLong(String key, long defValue) {
        return sha.getLong(key, defValue);
    }

    /**
     * @param key .
     * @param defValue .
     * @return float
     */
    public float getFloat(String key, float defValue) {
        return sha.getFloat(key, defValue);
    }

    /**
     * @param key .
     * @param defValue .
     * @return string
     */
    public String getString(String key, String defValue) {
        return sha.getString(key, defValue);
    }

    /**
     * @return map all
     */
    public Map<String, ?> getAll() {
        return sha.getAll();
    }

    /**
     * @param key .
     * @param defValue .
     * @return string set
     */
    public Set<String> getStringSet(String key, Set<String> defValue) {
        return sha.getStringSet(key, defValue);
    }

    /**
     * @param key .
     * @param value .
     * @return this
     */
    public P putBoolean(String key, boolean value) {
        ed.putBoolean(key, value);
        return this;
    }

    /**
     * @param key .
     * @param value .
     * @return this
     */
    public P putInt(String key, int value) {
        ed.putInt(key, value);
        return this;
    }

    /**
     * @param key .
     * @param value .
     * @return this
     */
    public P putLong(String key, long value) {
        ed.putLong(key, value);
        return this;
    }

    /**
     * @param key .
     * @param value .
     * @return this
     */
    public P putFloat(String key, float value) {
        ed.putFloat(key, value);
        return this;
    }

    /**
     * @param key .
     * @param value .
     * @return this
     */
    public P putString(String key, String value) {
        ed.putString(key, value);
        return this;
    }

    /**
     * @param key .
     * @param value .
     * @return this
     */
    public P putStringSet(String key, Set<String> value) {
        ed.putStringSet(key, value);
        return this;
    }

    /**
     * commit editor
     */
    public void commit() {
        ed.commit();
    }


}
