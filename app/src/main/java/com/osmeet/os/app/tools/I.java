package com.osmeet.os.app.tools;

import android.content.Context;
import android.content.Intent;

import com.osmeet.os.base.contract.ip.IContext;
import com.osmeet.os.view.activity.AdActivity;
import com.osmeet.os.view.activity.CameraActivity;
import com.osmeet.os.view.activity.ChatActivity;
import com.osmeet.os.view.activity.ChatInviteActivity;
import com.osmeet.os.view.activity.FriendListActivity;
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
import com.osmeet.os.view.activity.NewFriendListActivity;
import com.osmeet.os.view.activity.PopInfoActivity;
import com.osmeet.os.view.activity.ScanActivity;
import com.osmeet.os.view.activity.SearchActivity;
import com.osmeet.os.view.activity.SettingActivity;
import com.osmeet.os.view.activity.StoreActivity;
import com.osmeet.os.view.activity.TradeActivity;
import com.osmeet.os.view.activity.TradeListActivity;
import com.osmeet.os.view.activity.UpdateInfoActivity;
import com.osmeet.os.view.activity.UserInfo2Activity;
import com.osmeet.os.view.activity.VisitCardActivity;
import com.osmeet.os.view.activity.WalletActivity;

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
//            if (getContext() != null)
//               go$XX$Activity(getContext());
//        }
//    }

    public static void goLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public interface Login extends IContext {
        default void goLogin() {
            if (getContext() != null)
                goLoginActivity(getContext());
        }
    }

    public static void goPopInfoActivity(Context context) {
        Intent intent = new Intent(context, PopInfoActivity.class);
        context.startActivity(intent);
    }

    public interface PopInfo extends IContext {
        default void goPopInfo() {
            if (getContext() != null)
                goPopInfoActivity(getContext());
        }
    }

    public static void goAdActivity(Context context) {
        Intent intent = new Intent(context, AdActivity.class);
        context.startActivity(intent);
    }

    public interface Ad extends IContext {
        default void goAd() {
            if (getContext() != null)
                goAdActivity(getContext());
        }
    }

    public static void goGuideActivity(Context context) {
        Intent intent = new Intent(context, GuideActivity.class);
        context.startActivity(intent);
    }

    public interface Guide extends IContext {
        default void goGuide() {
            if (getContext() != null)
                goGuideActivity(getContext());
        }
    }

    public static void goMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public interface Main extends IContext {
        default void goMain() {
            if (getContext() != null)
                goMainActivity(getContext());
        }
    }

    public static void goStoreActivity(Context context, String storeId, int mode) {
        Intent intent = new Intent(context, StoreActivity.class);
        intent.putExtra("storeId", storeId);
        intent.putExtra("mode", mode);
        context.startActivity(intent);
    }

    public interface Store extends IContext {
        default void goStore(String storeId, int mode) {
            if (getContext() != null)
                goStoreActivity(getContext(), storeId, mode);
        }

        default void goStore(String storeId) {
            if (getContext() != null)
                goStoreActivity(getContext(), storeId, 0);
        }
    }

    public static void goUpdateInfoActivity(Context context) {
        Intent intent = new Intent(context, UpdateInfoActivity.class);
        context.startActivity(intent);
    }

    public interface UpdateInfo extends IContext {
        default void goUpdateInfo() {
            if (getContext() != null)
                goUpdateInfoActivity(getContext());
        }
    }

    public static void goSettingActivity(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    public interface Setting extends IContext {
        default void goSetting() {
            if (getContext() != null)
                goSettingActivity(getContext());
        }
    }

    public static void goCameraActivity(Context context) {
        Intent intent = new Intent(context, CameraActivity.class);
        context.startActivity(intent);
    }

    public interface Camera extends IContext {
        default void goCamera() {
            if (getContext() != null)
                goCameraActivity(getContext());
        }
    }

    public static void goInviteListActivity(Context context) {
        Intent intent = new Intent(context, InviteListActivity.class);
        context.startActivity(intent);
    }

    public interface InviteList extends IContext {
        default void goInviteList() {
            if (getContext() != null)
                goInviteListActivity(getContext());
        }
    }

    public static void goMatchActivity(Context context, String matchId) {
        Intent intent = new Intent(context, MatchActivity.class);
        intent.putExtra("matchId", matchId);
        context.startActivity(intent);
    }

    public interface Match extends IContext {
        default void goMatch(String matchId) {
            if (getContext() != null)
                goMatchActivity(getContext(), matchId);
        }
    }

    public static void goMatchListActivity(Context context) {
        Intent intent = new Intent(context, MatchListActivity.class);
        context.startActivity(intent);
    }

    public interface MatchList extends IContext {
        default void goMatchList() {
            if (getContext() != null)
                goMatchListActivity(getContext());
        }
    }

    public static void goNewFriendListActivity(Context context) {
        Intent intent = new Intent(context, NewFriendListActivity.class);
        context.startActivity(intent);
    }

    public interface NewFriendList extends IContext {
        default void goNewFriends() {
            if (getContext() != null)
                goNewFriendListActivity(getContext());
        }
    }

    public static void goTradeActivity(Context context, String tradeId) {
        Intent intent = new Intent(context, TradeActivity.class);
        intent.putExtra("tradeId", tradeId);
        context.startActivity(intent);
    }

    public interface Trade extends IContext {
        default void goTrade(String tradeId) {
            if (getContext() != null)
                goTradeActivity(getContext(), tradeId);
        }
    }

    public static void goTradeListActivity(Context context) {
        Intent intent = new Intent(context, TradeListActivity.class);
        context.startActivity(intent);
    }

    public interface TradeList extends IContext {
        default void goTradeList() {
            if (getContext() != null)
                goTradeListActivity(getContext());
        }
    }

    public static void goInviteFriendsActivity(Context context) {
        Intent intent = new Intent(context, InviteFriendsActivity.class);
        context.startActivity(intent);
    }

    public interface InviteFriends extends IContext {
        default void goInviteFriends() {
            if (getContext() != null)
                goInviteFriendsActivity(getContext());
        }
    }

    public static void goSearchActivity(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    public interface Search extends IContext {
        default void goSearch() {
            if (getContext() != null)
                goSearchActivity(getContext());
        }
    }

    public static void goWalletActivity(Context context) {
        Intent intent = new Intent(context, WalletActivity.class);
        context.startActivity(intent);
    }

    public interface Wallet extends IContext {
        default void goWallet() {
            if (getContext() != null)
                goWalletActivity(getContext());
        }
    }

    public static void goGoodsBuyActivity(Context context, com.osmeet.os.app.bean.Goods.SimpleGoods goods) {
        Intent intent = new Intent(context, GoodsBuyActivity.class);
        intent.putExtra("goods", goods);
        context.startActivity(intent);
    }

    public interface GoodsBuy extends IContext {
        default void goGoodsBuy(com.osmeet.os.app.bean.Goods.SimpleGoods goods) {
            if (getContext() != null)
                goGoodsBuyActivity(getContext(), goods);
        }
    }

    public static void goGoodsActivity(Context context, String goodsId) {
        Intent intent = new Intent(context, GoodsActivity.class);
        intent.putExtra("goodsId", goodsId);
        context.startActivity(intent);
    }

    public interface Goods extends IContext {
        default void goGoods(String goodsId) {
            if (getContext() != null)
                goGoodsActivity(getContext(), goodsId);
        }
    }

    public static void goMatchBeginActivity(Context context) {
        Intent intent = new Intent(context, MatchBeginActivity.class);
        context.startActivity(intent);
    }

    public interface MatchBegin extends IContext {
        default void goMatchBegin() {
            if (getContext() != null)
                goMatchBeginActivity(getContext());
        }
    }

    public static void goChatActivity(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        context.startActivity(intent);
    }

    public interface Chat extends IContext {
        default void goChat() {
            if (getContext() != null)
                goChatActivity(getContext());
        }
    }

    public static void goChatInviteActivity(Context context) {
        Intent intent = new Intent(context, ChatInviteActivity.class);
        context.startActivity(intent);
    }

    public interface ChatInvite extends IContext {
        default void goChatInvite() {
            if (getContext() != null)
                goChatInviteActivity(getContext());
        }
    }

    public static void goScanActivity(Context context) {
        Intent intent = new Intent(context, ScanActivity.class);
        context.startActivity(intent);
    }

    public interface Scan extends IContext {
        default void goScan() {
            if (getContext() != null)
                goScanActivity(getContext());
        }
    }

    public static void goVisitCardActivity(Context context) {
        Intent intent = new Intent(context, VisitCardActivity.class);
        context.startActivity(intent);
    }

    public interface VisitCard extends IContext {
        default void goVisitCard() {
            if (getContext() != null)
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
            if (getContext() != null)
                goAMapApp(getContext(), uri);
        }
    }

    public static void goFriendListActivity(Context context) {
        Intent intent = new Intent(context, FriendListActivity.class);
        context.startActivity(intent);
    }

    public interface FriendList extends IContext {
        default void goFriendList() {
            if (getContext() != null)
                goFriendListActivity(getContext());
        }
    }

    public static void goUserInfo2Activity(Context context, String userId) {
        Intent intent = new Intent(context, UserInfo2Activity.class);
        context.startActivity(intent);
    }

    public interface UserInfo2 extends IContext {
        default void goUserInfo2(String userId) {
            if (getContext() != null)
                goUserInfo2Activity(getContext(), userId);
        }
    }

}
