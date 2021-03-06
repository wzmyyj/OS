package top.wzmyyj.wzm_sdk.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.List;

import top.wzmyyj.wzm_sdk.panel.Panel;
import top.wzmyyj.wzm_sdk.panel.PanelManager;

/**
 * Created by yyj on 2018/05/04.
 * <p>
 * Panel in Activity.
 *
 * @author wzmyyj email: 2209011667@qq.com
 * @see top.wzmyyj.wzm_sdk.panel.Panel
 * @see top.wzmyyj.wzm_sdk.panel.PanelManager
 */


public abstract class PanelActivity extends InitActivity {

    private PanelManager mPanelManager = new PanelManager();

    /**
     * @param panels .
     */
    protected void addPanels(@NonNull Panel... panels) {
        if (mPanelManager.isCanAdd())
            mPanelManager.addPanels(panels);
    }

    /**
     * @param i .
     * @return panel's view.
     */
    public View getPanelView(int i) {
        return mPanelManager.getPanelView(i);
    }

    /**
     * @param i   .
     * @param <P> .
     * @return panel.
     */
    @SuppressWarnings("unchecked")
    public <P extends Panel> P getPanel(int i) {
        return (P) mPanelManager.get(i);
    }


    /**
     * @return panel list.
     */
    public List<Panel> getPanelList() {
        return mPanelManager.getPanelList();
    }

    /**
     * @return panel list size.
     */
    public int getPanelCount() {
        return mPanelManager.getSize();
    }

    /**
     * @return mPanelManager.
     */
    public PanelManager getPanelManager() {
        return mPanelManager;
    }

    /**
     * 只能在这个方法里添加Panel。
     */
    protected void initPanels() {

    }

    @Override
    protected void initSome(Bundle savedInstanceState) {
        super.initSome(savedInstanceState);
        mPanelManager.canAddOnce();
        initPanels();
        mPanelManager.alreadyAddOnce();
        mPanelManager.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPanelManager.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mPanelManager.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPanelManager.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mPanelManager.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mPanelManager.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPanelManager.onDestroy();
        mPanelManager = null;
    }

}
