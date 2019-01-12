package top.wzmyyj.wzm_sdk.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import top.wzmyyj.wzm_sdk.panel.Panel;
import top.wzmyyj.wzm_sdk.panel.PanelManager;

/**
 * Created by wzm on 2018/05/04. email: 2209011667@qq.com
 * 如果需要动态添加Panel，调用addPanels2(@NonNull Panel... panels)。
 */


public abstract class PanelFragment extends InitFragment {

    private PanelManager mPanelManager = new PanelManager();

    protected void addPanels(@NonNull Panel... panels) {
        mPanelManager.addPanels(panels);
    }

    public View getPanelView(int i) {
        return mPanelManager.getPanelView(i);
    }

    @SuppressWarnings("unchecked")
    public  <P extends Panel> P getPanel(int i) {
        return (P) mPanelManager.get(i);
    }

    public PanelManager getPanelManager() {
        return mPanelManager;
    }


    // 只能在这个方法里创建Panel。
    protected void initPanels() {

    }

    @Override
    protected void initSome(Bundle savedInstanceState) {
        super.initSome(savedInstanceState);
        initPanels();
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
