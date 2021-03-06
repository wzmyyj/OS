package top.wzmyyj.wzm_sdk.panel;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.List;

/**
 * Created by yyj on 2019/01/12.
 * <p>
 * Group Panel: Panel in Panel.
 *
 * @author wzmyyj email: 2209011667@qq.com
 * @see top.wzmyyj.wzm_sdk.panel.PanelManager
 */

public abstract class PanelGroup extends InitPanel {
    /**
     * @param context .
     */
    public PanelGroup(Context context) {
        super(context);
    }

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
     * @return panel's view
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
    public void onResume() {
        super.onResume();
        mPanelManager.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPanelManager.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPanelManager.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPanelManager.onStop();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPanelManager.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPanelManager.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPanelManager.onDestroy();
        mPanelManager = null;
    }
}
