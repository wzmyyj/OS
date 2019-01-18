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

import top.wzmyyj.wzm_sdk.tools.Sure;

/**
 * Created by yyj on 2018/04/23.
 * <p>
 * Panel意为面板。设计初衷是希望有个类似Fragment，但比Fragment简洁，小规模的View的控制器。
 * Panel可以放在Activity,Fragment，也可以放在GroupPanel里，形成层层套嵌模型。
 * Panel拥有Fragment类似的生命周期，子层比父层先执行，同层按顺序先执行。
 * Panel与父层通讯紧密时，可以用内部类。
 * Panel只能在initPanels()（见GroupPanel，PanelActivity，PanelFragment）中创建。
 * Panel不支持动态添加和销毁。只能跟着父容器创建并跟着父容器创建销毁。可以看做静态布局的一个局部控制器。
 *
 * @author wzmyyj email: 2209011667@qq.com
 * @see top.wzmyyj.wzm_sdk.activity.PanelActivity
 * @see top.wzmyyj.wzm_sdk.fragment.PanelFragment
 * @see top.wzmyyj.wzm_sdk.panel.GroupPanel
 * @see top.wzmyyj.wzm_sdk.panel.PanelManager
 */


public class Panel {

    private static final int INITIALIZING = 0;     // Not yet created.
    private static final int CREATED = 1;          // Created.
    private static final int ACTIVITY_CREATED = 2; // The activity has finished its creation.
    private static final int STOPPED = 3;          // Fully created, not started.
    private static final int STARTED = 4;          // Created and started, not resumed.
    private static final int RESUMED = 5;          // Created started and resumed.

    private int mState = INITIALIZING;

    protected Context context;
    protected Activity activity;
    protected Fragment fragment;
    protected LayoutInflater mInflater;
    protected View view;
    protected String title = "";

    public Context getContext() {
        return context;
    }

    /**
     * @param <A> .
     * @return activity.
     */
    @SuppressWarnings("unchecked")
    public <A extends Activity> A getActivity() {
        return (A) activity;
    }

    /**
     * @param <F> .
     * @return fragment.
     */
    @SuppressWarnings("unchecked")
    public <F extends Fragment> F getFragment() {
        return (F) fragment;
    }

    /**
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title .
     * @param <P> .
     * @return this.
     */
    @SuppressWarnings("unchecked")
    public <P extends Panel> P setTitle(String title) {
        this.title = title;
        return (P) this;
    }

    /**
     * @param context .
     */
    public Panel(Context context) {
        this.activity = (Activity) context;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    /**
     * bind fragment.
     *
     * @param fragment .
     * @param <P> .
     * @return this.
     */
    @SuppressWarnings("unchecked")
    public <P extends Panel> P inFragment(Fragment fragment) {
        this.fragment = fragment;
        return (P) this;
    }

    /**
     * @return mState.
     */
    public int getState() {
        return mState;
    }

    /**
     * @return view.
     */
    public View getView() {
        return view;
    }

    /**
     * when activity onCreate->initSome.
     *
     * @param savedInstanceState .
     */
    public void onCreate(Bundle savedInstanceState) {
        mState = CREATED;
    }

    /**
     * when activity onStart.
     */
    public void onStart() {
        mState = STARTED;
    }

    /**
     * when activity onResume.
     */
    public void onResume() {
        mState = RESUMED;
    }

    /**
     * when activity onRestart.
     */
    public void onRestart() {
        mState = STARTED;
    }

    /**
     * when activity onPause.
     */
    public void onPause() {
        mState = STARTED;
    }

    /**
     * when activity onStop.
     */
    public void onStop() {
        mState = STOPPED;
    }

    /**
     * when fragment onActivityCreated
     *
     * @param savedInstanceState .
     */
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mState = ACTIVITY_CREATED;
    }

    /**
     * when fragment onDestroyView.
     */
    public void onDestroyView() {
        mState = STOPPED;
    }

    /**
     * when activity onDestroy.
     */
    public void onDestroy() {
        mState = INITIALIZING;
        mViewMap.clear();
        mPanelMap.clear();
        mViewMap = null;
        mPanelMap = null;
        fragment = null;
        activity = null;
        context = null;

    }


    private Map<String, View> mViewMap = new HashMap<>();

    /**
     * 外部调用，用于绑定外界的View。可以控制外界的view。
     *
     * @param key .
     * @param view .
     */
    public void bindView(String key, View view) {
        Sure.sure(mState < ACTIVITY_CREATED, "bindView need when onCreate!");
        mViewMap.put(key, view);
    }

    /**
     * @param key .
     * @param <V> .
     * @return view.
     */
    @SuppressWarnings("unchecked")
    public <V extends View> V getBindView(String key) {
        Sure.sure(mState >= ACTIVITY_CREATED, "getBindView need after onCreate!");
        return (V) mViewMap.get(key);
    }

    /**
     * @return view map.
     */
    public Map<String, View> getBindViewMap() {
        return mViewMap;
    }

    private Map<String, Panel> mPanelMap = new HashMap<>();

    /**
     * 外部调用，用于绑定外界的Panel。可以控制外界的panel。
     *
     * @param key .
     * @param panel .
     */
    public void bindPanel(String key, Panel panel) {
        Sure.sure(mState < ACTIVITY_CREATED, "bindPanel need when onCreate!");
        mPanelMap.put(key, panel);
    }

    /**
     * @param key .
     * @param <P> .
     * @return panel.
     */
    @SuppressWarnings("unchecked")
    public <P extends Panel> P getBindPanel(String key) {
        Sure.sure(mState >= ACTIVITY_CREATED, "getBindPanel need after onCreate!");
        return (P) mPanelMap.get(key);
    }

    /**
     * @return panel map.
     */
    public Map<String, Panel> getBindPanelMap() {
        return mPanelMap;
    }
}
