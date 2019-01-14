package top.wzmyyj.wzm_sdk.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wzm on 2018/04/23. email: 2209011667@qq.com
 * Panel意为面板。设计初衷是希望有个类似Fragment，但比Fragment简洁，小规模的View的控制器。
 * Panel可以放在Activity,Fragment，也可以放在GroupPanel里，形成层层套嵌模型。
 * Panel拥有Fragment类似的生命周期，子层比父层先执行，同层按顺序先执行。
 * Panel与父层通讯紧密时，可以用内部类。
 * Panel只能在initPanels()（见GroupPanel，PanelActivity，PanelFragment）中创建。
 * Panel不支持动态添加和销毁。只能跟着父容器创建并跟着父容器创建销毁。可以看做静态布局的一个局部控制器。
 */


public class Panel{

    protected LayoutInflater mInflater;
    protected Context context;
    protected Activity activity;
    protected Fragment fragment;
    protected View view;
    protected String title = "";

    public Context getContext() {
        return context;
    }

    @SuppressWarnings("unchecked")
    public <A extends Activity> A getActivity() {
        return (A) activity;
    }

    @SuppressWarnings("unchecked")
    public <F extends Fragment> F getFragment() {
        return (F) fragment;
    }

    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unchecked")
    public <P extends Panel> P setTitle(String title) {
        this.title = title;
        return (P) this;
    }

    public Panel(Context context) {
        this.activity = (Activity) context;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @SuppressWarnings("unchecked")
    public <P extends Panel> P inFragment(Fragment fragment) {
        this.fragment = fragment;
        return (P) this;
    }


    public View getView() {
        return view;
    }

    public void onCreate(Bundle savedInstanceState) {

    }


    public void onResume() {

    }


    public void onStart() {

    }

    public void onRestart() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

    }

    public void onDestroyView() {
    }

    public void onDestroy() {
        mViewMap.clear();
        mPanelMap.clear();
        mViewMap = null;
        mPanelMap = null;
        fragment = null;
        activity = null;
        context = null;

    }


    public Map<String, View> mViewMap = new HashMap<>();

    // 外部调用，用于绑定外界的View。可以控制外界的view。
    public void bingView(String key, View view) {
        mViewMap.put(key, view);
    }

    public Map<String, Panel> mPanelMap = new HashMap<>();

    // 外部调用，用于绑定外界的Panel。可以控制外界的panel。
    public void bingPanel(String key, Panel panel) {
        mPanelMap.put(key, panel);
    }


}
