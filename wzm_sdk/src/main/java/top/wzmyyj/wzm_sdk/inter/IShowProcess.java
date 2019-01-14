package top.wzmyyj.wzm_sdk.inter;

/**
 * Created by yyj on 2019/01/14. email: 2209011667@qq.com
 */

public interface IShowProcess {

    int DEFAULT = -19970120;

    void showStart(int what, Object... objects);

    void showProgress(int what, int progress, Object... objects);

    void showFail(int what, Object... objects);

    void showSuccess(int what, Object... objects);

    void showFinish(int what, Object... objects);
}
