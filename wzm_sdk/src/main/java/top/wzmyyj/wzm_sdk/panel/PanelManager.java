package top.wzmyyj.wzm_sdk.panel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2018/07/04.
 *
 * 多个Panel的管理类。
 *
 * @author wzmyyj email: 2209011667@qq.com
 * @see top.wzmyyj.wzm_sdk.panel.Panel
 */

public class PanelManager {
    private List<Panel> mPanelList;

    public PanelManager() {
        mPanelList = new ArrayList<>();
    }

    /**
     * @param panels .
     */
    public void addPanels(@NonNull Panel... panels) {
        for (Panel panel : panels)
            if (panel != null)
                this.mPanelList.add(panel);
    }

    /**
     * @param panel .
     */
    public void movePanel(@NonNull Panel panel) {
        mPanelList.remove(panel);
    }

    /**
     * @param i .
     */
    public void movePanel(int i) {
        mPanelList.remove(i);
    }

    /**
     * @return mPanelList.
     */
    public List<Panel> getPanelList() {
        return mPanelList;
    }

    public Panel get(int i) {
        if (mPanelList.size() <= i) return null;
        return mPanelList.get(i);
    }

    /**
     * clear.
     */
    public void clear() {
        mPanelList.clear();
    }

    /**
     * @param mPanelList .
     */
    public void setPanelList(List<Panel> mPanelList) {
        this.mPanelList = mPanelList;
    }

    /**
     * @param i .
     * @return panel's view.
     */
    public View getPanelView(int i) {
        if (mPanelList.size() <= i) return null;
        return this.mPanelList.get(i).getView();
    }

    /**
     * @return size.
     */
    public int getSize() {
        return mPanelList.size();
    }

    public void onCreate(Bundle savedInstanceState) {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onCreate(savedInstanceState);
        }
    }

    public void onResume() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onResume();
        }
    }


    public void onStart() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onStart();
        }
    }

    public void onRestart() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onRestart();
        }
    }

    public void onPause() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onPause();
        }
    }

    public void onStop() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onStop();
        }
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onActivityCreated(savedInstanceState);
        }
    }

    public void onDestroyView() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onDestroyView();
        }
    }

    public void onDestroy() {
        if (mPanelList == null || mPanelList.size() == 0)
            return;
        for (Panel p : mPanelList) {
            p.onDestroy();
        }
        mPanelList.clear();
    }

}
