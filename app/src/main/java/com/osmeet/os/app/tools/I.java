package com.osmeet.os.app.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.osmeet.os.app.bean.MatchTeam;
import com.osmeet.os.base.contract.ip.IContext;
import com.osmeet.os.view.activity.SingleMapActivity;
import com.osmeet.os.view.activity.AboutOsActivity;
import com.osmeet.os.view.activity.AccountActivity;
import com.osmeet.os.view.activity.AdActivity;
import com.osmeet.os.view.activity.BlockListActivity;
import com.osmeet.os.view.activity.CameraActivity;
import com.osmeet.os.view.activity.ChatInviteActivity;
import com.osmeet.os.view.activity.FriendListActivity;
import com.osmeet.os.view.activity.GoodsActivity;
import com.osmeet.os.view.activity.GoodsBuyActivity;
import com.osmeet.os.view.activity.GuideActivity;
import com.osmeet.os.view.activity.ImageLookActivity;
import com.osmeet.os.view.activity.InviteFriendsActivity;
import com.osmeet.os.view.activity.InviteListActivity;
import com.osmeet.os.view.activity.LoginActivity;
import com.osmeet.os.view.activity.MainActivity;
import com.osmeet.os.view.activity.MatchActivity;
import com.osmeet.os.view.activity.MatchBeginActivity;
import com.osmeet.os.view.activity.MatchListActivity;
import com.osmeet.os.view.activity.NewFriendsActivity;
import com.osmeet.os.view.activity.PopInfoActivity;
import com.osmeet.os.view.activity.ProtocolActivity;
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
import com.previewlibrary.GPreviewBuilder;
import com.previewlibrary.enitity.ThumbViewInfo;

import java.util.ArrayList;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

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

    public static void goNewFriendsActivity(Context context) {
        Intent intent = new Intent(context, NewFriendsActivity.class);
        context.startActivity(intent);
    }

    public interface NewFriends extends IContext {
        default void goNewFriends() {
            if (getContext() != null)
                goNewFriendsActivity(getContext());
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

    public static void goInviteFriendsActivity(Context context, String storeId) {
        Intent intent = new Intent(context, InviteFriendsActivity.class);
        intent.putExtra("storeId", storeId);
        context.startActivity(intent);
    }

    public interface InviteFriends extends IContext {
        default void goInviteFriends(String storeId) {
            if (getContext() != null)
                goInviteFriendsActivity(getContext(), storeId);
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

    public static void goWalletActivity(Context context, String storeId) {
        Intent intent = new Intent(context, WalletActivity.class);
        intent.putExtra("storeId", storeId);
        context.startActivity(intent);
    }

    public interface Wallet extends IContext {
        default void goWallet() {
            if (getContext() != null)
                goWalletActivity(getContext(), null);
        }

        default void goWallet(String storeId) {
            if (getContext() != null)
                goWalletActivity(getContext(), storeId);
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

    public static void goMatchBeginActivity(Context context, MatchTeam.SimpleMatchTeam simpleMatchTeam) {
        Intent intent = new Intent(context, MatchBeginActivity.class);
        intent.putExtra("mt", simpleMatchTeam);
        context.startActivity(intent);
    }

    public interface MatchBegin extends IContext {
        default void goMatchBegin(MatchTeam.SimpleMatchTeam simpleMatchTeam) {
            if (getContext() != null)
                goMatchBeginActivity(getContext(), simpleMatchTeam);
        }
    }

    public static void goChatActivity(Context context, String userId, String title) {
//        Intent intent = new Intent(context, ChatActivity.class);
//        intent.putExtra("userId", userId);
//        context.startActivity(intent);
        Conversation.ConversationType conversationType = Conversation.ConversationType.PRIVATE;
        RongIM.getInstance().startConversation(context, conversationType, userId, title);
    }

    public interface Chat extends IContext {
        default void goChat(String userId, String title) {
            if (getContext() != null)
                goChatActivity(getContext(), userId, title);
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
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }

    public interface UserInfo2 extends IContext {
        default void goUserInfo2(String userId) {
            if (getContext() != null)
                goUserInfo2Activity(getContext(), userId);
        }
    }

    public static void goImageLookActivity(Context context, ArrayList<ThumbViewInfo> thumbViewInfoList) {
        if (thumbViewInfoList == null || thumbViewInfoList.size() == 0) return;
        GPreviewBuilder.from((Activity) context)
                //是否使用自定义预览界面，当然8.0之后因为配置问题，必须要使用
                .to(ImageLookActivity.class)
                .setData(thumbViewInfoList)
                .setCurrentIndex(0)
                .setSingleFling(true)
                .setType(GPreviewBuilder.IndicatorType.Number)
                // 小圆点
                //  .setType(GPreviewBuilder.IndicatorType.Dot)
                .start();//启动
    }

    public interface ImageLook extends IContext {
        default void goImageLook(ArrayList<ThumbViewInfo> thumbViewInfoList) {
            if (getContext() != null)
                goImageLookActivity(getContext(), thumbViewInfoList);
        }
    }


    public static void goAccountActivity(Context context) {
        Intent intent = new Intent(context, AccountActivity.class);
        context.startActivity(intent);
    }

    public interface Account extends IContext {
        default void goAccount() {
            if (getContext() != null)
                goAccountActivity(getContext());
        }
    }

    public static void goBlockListActivity(Context context) {
        Intent intent = new Intent(context, BlockListActivity.class);
        context.startActivity(intent);
    }

    public interface BlockList extends IContext {
        default void goBlockList() {
            if (getContext() != null)
                goBlockListActivity(getContext());
        }
    }

    public static void goAboutOsActivity(Context context) {
        Intent intent = new Intent(context, AboutOsActivity.class);
        context.startActivity(intent);
    }

    public interface AboutOs extends IContext {
        default void goAboutOs() {
            if (getContext() != null)
                goAboutOsActivity(getContext());
        }
    }

    public static void goProtocolActivity(Context context) {
        Intent intent = new Intent(context, ProtocolActivity.class);
        context.startActivity(intent);
    }

    public interface Protocol extends IContext {
        default void goProtocol() {
            if (getContext() != null)
                goProtocolActivity(getContext());
        }
    }


    public static void goSingleMapActivity(Context context,double lat,double lon,String title) {
        Intent intent = new Intent(context, SingleMapActivity.class);
        intent.putExtra("lat",lat);
        intent.putExtra("lon",lon);
        intent.putExtra("title",title);
        context.startActivity(intent);
    }

    public interface SingleMap extends IContext {
        default void goSingleMap(double lat,double lon,String title) {
            if (getContext() != null)
                goSingleMapActivity(getContext(),lat,lon,title);
        }
    }





}
