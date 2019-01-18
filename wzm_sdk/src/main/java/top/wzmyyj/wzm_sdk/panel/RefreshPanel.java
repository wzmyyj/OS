package top.wzmyyj.wzm_sdk.panel;

import android.content.Context;

/**
 * Created by wzm on 2018/05/05.
 *
 * Refresh Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */


public abstract class RefreshPanel extends GroupPanel {

    private static final int DEFAULT_DELAYED_R = 1500;
    private static final int DEFAULT_DELAYED_L = 1000;

    private int delayed_r = DEFAULT_DELAYED_R;
    private int delayed_l = DEFAULT_DELAYED_L;

    /**
     * @param delayed_r .
     */
    public void setDelayed_r(int delayed_r) {
        this.delayed_r = delayed_r;
    }

    /**
     * @param delayed_l .
     */
    public void setDelayed_l(int delayed_l) {
        this.delayed_l = delayed_l;
    }

    /**
     * @return delayed_r.
     */
    public int getDelayed_r() {
        return delayed_r;
    }

    /**
     * @return delayed_l.
     */
    public int getDelayed_l() {
        return delayed_l;
    }

    /**
     * @param context .
     */
    public RefreshPanel(Context context) {
        super(context);
    }


    /**
     * refresh.
     */
    protected abstract void refresh();

    /**
     * loadMore.
     */
    protected abstract void loadMore();

    /**
     * update.
     */
    protected abstract void update();

    /**
     * updateWithView.
     */
    public abstract void updateWithView();

}
