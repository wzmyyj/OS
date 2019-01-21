package top.wzmyyj.wzm_sdk.panel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2018/07/04.
 * <p>
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


    private static final int NO_ADD_ONCE = 0x0;
    private static final int CAN_ADD_ONCE = 0x1;
    private static final int ALREADY_ADD_ONCE = 0x10;

    private int addOnce = NO_ADD_ONCE;

    /**
     * can Add: can add panel later.
     */
    public void canAddOnce() {
        addOnce = CAN_ADD_ONCE;
    }


    /**
     * already Add: can not add panel later.
     */
    public void alreadyAddOnce() {
        addOnce = ALREADY_ADD_ONCE;
    }


    /**
     * @return is can add.
     */
    public boolean isCanAdd() {
        return addOnce == CAN_ADD_ONCE;
    }

    /**
     * @param panels .
     */
    public void addPanels(@NonNull Panel... panels) {
        Sure.sure(addOnce == CAN_ADD_ONCE, "must add panels when PanelManager is can add!");
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
