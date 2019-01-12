package com.osmeet.os.app.tools;

import android.content.Context;
import android.content.Intent;

import com.osmeet.os.view.activity.AdActivity;
import com.osmeet.os.view.activity.CameraActivity;
import com.osmeet.os.view.activity.ChatActivity;
import com.osmeet.os.view.activity.ChatInviteActivity;
import com.osmeet.os.view.activity.GoodsActivity;
import com.osmeet.os.view.activity.GoodsBuyActivity;
import com.osmeet.os.view.activity.GuideActivity;
import com.osmeet.os.view.activity.InviteFriendsActivity;
import com.osmeet.os.view.activity.InviteListActivity;
import com.osmeet.os.view.activity.LoginActivity;
import com.osmeet.os.view.activity.MainActivity;
import com.osmeet.os.view.activity.MatchActivity;
import com.osmeet.os.view.activity.MatchBeginActivity;
import com.osmeet.os.view.activity.MatchListActivity;
import com.osmeet.os.view.activity.NewFriendsActivity;
import com.osmeet.os.view.activity.PopInfoActivity;
import com.osmeet.os.view.activity.ScanActivity;
import com.osmeet.os.view.activity.SearchActivity;
import com.osmeet.os.view.activity.SettingActivity;
import com.osmeet.os.view.activity.StoreActivity;
import com.osmeet.os.view.activity.TradeActivity;
import com.osmeet.os.view.activity.TradeListActivity;
import com.osmeet.os.view.activity.UpdateInfoActivity;
import com.osmeet.os.view.activity.VisitCardActivity;
import com.osmeet.os.view.activity.WalletActivity;

import top.wzmyyj.wzm_sdk.inter.IContext;

/**
 * Created by yyj on 2018/10/30. email: 2209011667@qq.com
 * 两种使用方法：1，直接调用方法;2,接口接入。
 * 所有Activity都需要在这里注册跳转逻辑。
 * 需要jdk 1.8 及以上。
 * Ctrl+Shift+Alt+S。设置使用jdk 1.8。
 * 建议使用模板生成代码：File->Settings->Editor->Live Templates
 * 不要吐槽命名，常用就用最简单的方式，写代码容易啊啊啊啊。如果有意见，可以开发完成后重命名。
 */

public class I {

//    模板：
//    public static void go$XX$Activity(Context context) {
//        Intent intent = new Intent(context, $XX$Activity.class);
//        context.startActivity(intent);
//    }
//
//    public interface $XX$ extends IContext {
//        default void go$XX$() {
//            go$XX$Activity(getContext());
//        }
//    }

    public static void goLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public interface Login extends IContext {
        default void goLogin() {
            goLoginActivity(getContext());
        }
    }

    public static void goPopInfoActivity(Context context) {
        Intent intent = new Intent(context, PopInfoActivity.class);
        context.startActivity(intent);
    }

    public interface PopInfo extends IContext {
        default void goPopInfo() {
            goPopInfoActivity(getContext());
        }
    }

    public static void goAdActivity(Context context) {
        Intent intent = new Intent(context, AdActivity.class);
        context.startActivity(intent);
    }

    public interface Ad extends IContext {
        default void goAd() {
            goAdActivity(getContext());
        }
    }

    public static void goGuideActivity(Context context) {
        Intent intent = new Intent(context, GuideActivity.class);
        context.startActivity(intent);
    }

    public interface Guide extends IContext {
        default void goGuide() {
            goGuideActivity(getContext());
        }
    }

    public static void goMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public interface Main extends IContext {
        default void goMain() {
            goMainActivity(getContext());
        }
    }

    public static void goStoreActivity(Context context, String storeId) {
        Intent intent = new Intent(context, StoreActivity.class);
        intent.putExtra("storeId", storeId);
        context.startActivity(intent);
    }

    public interface Store extends IContext {
        default void goStore(String storeId) {
            goStoreActivity(getContext(), storeId);
        }
    }

    public static void goUpdateInfoActivity(Context context) {
        Intent intent = new Intent(context, UpdateInfoActivity.class);
        context.startActivity(intent);
    }

    public interface UpdateInfo extends IContext {
        default void goUpdateInfo() {
            goUpdateInfoActivity(getContext());
        }
    }

    public static void goSettingActivity(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    public interface Setting extends IContext {
        default void goSetting() {
            goSettingActivity(getContext());
        }
    }

    public static void goCameraActivity(Context context) {
        Intent intent = new Intent(context, CameraActivity.class);
        context.startActivity(intent);
    }

    public interface Camera extends IContext {
        default void goCamera() {
            goCameraActivity(getContext());
        }
    }

    public static void goInviteListActivity(Context context) {
        Intent intent = new Intent(context, InviteListActivity.class);
        context.startActivity(intent);
    }

    public interface InviteList extends IContext {
        default void goInviteList() {
            goInviteListActivity(getContext());
        }
    }

    public static void goMatchActivity(Context context) {
        Intent intent = new Intent(context, MatchActivity.class);
        context.startActivity(intent);
    }

    public interface Match extends IContext {
        default void goMatch() {
            goMatchActivity(getContext());
        }
    }

    public static void goMatchListActivity(Context context) {
        Intent intent = new Intent(context, MatchListActivity.class);
        context.startActivity(intent);
    }

    public interface MatchList extends IContext {
        default void goMatchList() {
            goMatchListActivity(getContext());
        }
    }

    public static void goNewFriendsActivity(Context context) {
        Intent intent = new Intent(context, NewFriendsActivity.class);
        context.startActivity(intent);
    }

    public interface NewFriends extends IContext {
        default void goNewFriends() {
            goNewFriendsActivity(getContext());
        }
    }

    public static void goTradeActivity(Context context) {
        Intent intent = new Intent(context, TradeActivity.class);
        context.startActivity(intent);
    }

    public interface Trade extends IContext {
        default void goTrade() {
            goTradeActivity(getContext());
        }
    }

    public static void goTradeListActivity(Context context) {
        Intent intent = new Intent(context, TradeListActivity.class);
        context.startActivity(intent);
    }

    public interface TradeList extends IContext {
        default void goTradeList() {
            goTradeListActivity(getContext());
        }
    }

    public static void goInviteFriendsActivity(Context context) {
        Intent intent = new Intent(context, InviteFriendsActivity.class);
        context.startActivity(intent);
    }

    public interface InviteFriends extends IContext {
        default void goInviteFriends() {
            goInviteFriendsActivity(getContext());
        }
    }

    public static void goSearchActivity(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    public interface Search extends IContext {
        default void goSearch() {
            goSearchActivity(getContext());
        }
    }

    public static void goWalletActivity(Context context) {
        Intent intent = new Intent(context, WalletActivity.class);
        context.startActivity(intent);
    }

    public interface Wallet extends IContext {
        default void goWallet() {
            goWalletActivity(getContext());
        }
    }

    public static void goGoodsBuyActivity(Context context) {
        Intent intent = new Intent(context, GoodsBuyActivity.class);
        context.startActivity(intent);
    }

    public interface GoodsBuy extends IContext {
        default void goGoodsBuy() {
            goGoodsBuyActivity(getContext());
        }
    }

    public static void goGoodsActivity(Context context) {
        Intent intent = new Intent(context, GoodsActivity.class);
        context.startActivity(intent);
    }

    public interface Goods extends IContext {
        default void goGoods() {
            goGoodsActivity(getContext());
        }
    }

    public static void goMatchBeginActivity(Context context) {
        Intent intent = new Intent(context, MatchBeginActivity.class);
        context.startActivity(intent);
    }

    public interface MatchBegin extends IContext {
        default void goMatchBegin() {
            goMatchBeginActivity(getContext());
        }
    }

    public static void goChatActivity(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        context.startActivity(intent);
    }

    public interface Chat extends IContext {
        default void goChat() {
            goChatActivity(getContext());
        }
    }

    public static void goChatInviteActivity(Context context) {
        Intent intent = new Intent(context, ChatInviteActivity.class);
        context.startActivity(intent);
    }

    public interface ChatInvite extends IContext {
        default void goChatInvite() {
            goChatInviteActivity(getContext());
        }
    }

    public static void goScanActivity(Context context) {
        Intent intent = new Intent(context, ScanActivity.class);
        context.startActivity(intent);
    }

    public interface Scan extends IContext {
        default void goScan() {
            goScanActivity(getContext());
        }
    }

    public static void goVisitCardActivity(Context context) {
        Intent intent = new Intent(context, VisitCardActivity.class);
        context.startActivity(intent);
    }

    public interface VisitCard extends IContext {
        default void goVisitCard() {
            goVisitCardActivity(getContext());
        }
    }

    public static void goAMapApp(Context context, String uri) {
        Intent intent = new Intent("android.intent.action.VIEW", android.net.Uri.parse(uri));
        intent.setPackage("com.autonavi.minimap");
        context.startActivity(intent);
    }

    public interface AMap extends IContext {
        default void goAMap(String uri) {
            goAMapApp(getContext(), uri);
        }
    }

}
