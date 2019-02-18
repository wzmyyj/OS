package com.osmeet.os.model.net.utils;

/**
 * Created by yyj on 2018/12/03. email: 2209011667@qq.com
 */


public class Urls {
    public static final String OS_BASE = "http://47.104.219.30:8888";
    //            public static final String OS_BASE = "http://192.168.1.107:8888";
    // 举报。
    public static final String report = "/report";

    // 关注。
    public static final String block_get = "/block";
    public static final String block_post = "/block";
    public static final String block_del = "/block";
    public static final String block_me = "/block/me";
    public static final String like_get = "/like";
    public static final String like_post = "/like";
    public static final String like_del = "/like";
    public static final String like_me = "/like/me";
    public static final String like_eachother = "/like/eachother";

    // 区域。
    public static final String region_all = "/region/all";
    public static final String region_city = "/region/city";
    public static final String region_district = "/region/district";
    public static final String region_road = "/region/road";


    // 商品。
    public static final String goods_get = "/store/goods";
    public static final String goods_post = "/store/goods";
    public static final String goods_put = "/store/goods";
    public static final String goods_buyGoods = "/store/goods/buyGoods";
    public static final String goods_byStoreId = "/store/goods/byStoreId";
    public static final String goods_getAll = "/store/goods/getAll";
    public static final String goods_getBE = "/store/goods/getBeforeEndTimeByStore";
    public static final String goods_search = "/store/goods/search";

    // 商店。
    public static final String store = "/store";
    public static final String store_findByCondition = "/store/findByCondition";
    public static final String store_getStore = "/store/getStore";
    public static final String store_list = "/store/list";
    public static final String store_listByRegion = "/store/listByRegion";

    // 分类。
    public static final String category = "/category";

    // 好友。
    public static final String friends_get = "/friends";
    public static final String friends_add = "/friends";
    public static final String friends_del = "/friends";
    public static final String friends_agree = "/friends/agree";
    public static final String friends_block_get = "/friends/block";
    public static final String friends_block_post = "/friends/block";
    public static final String friends_block_del = "/friends/block";
    public static final String friends_block_me = "/friends/block/me";
    public static final String friends_delete = "/friends/delete";
    public static final String friends_friendRS = "/friends/friendRelationship";
    public static final String friends_me = "/friends/me";
    public static final String friends_meNum = "/friends/meNum";
    public static final String friends_meRead = "/friends/meRead";
    public static final String friends_page = "/friends/page";
    public static final String friends_refuse = "/friends/refuse";

    // 字典。
    public static final String dictionary_errors = "/dictionary/errors";

    // 文件。
    public static final String file_download = "/file/download";
    public static final String file_fileSetExamine = "/file/fileSetExamine";
    public static final String file_getFileById = "/file/getFileById";
    public static final String file_ref = "/file/ref";
    public static final String file_refById = "/file/refById";
    public static final String file_refBySize = "/file/refBySize";
    public static final String file_upload = "/file/upload";
    public static final String file_uploadList = "/file/uploadList";

    // 用户。
    public static final String user = "/user";
    public static final String user_bindWechat = "/user/bindWechat";
    public static final String user_consummateInfo = "/user/consummateInfomation";
    public static final String user_consummateInfoNoPass = "/user/consummateInfomationNoPass";
    public static final String user_existsByPhone = "/user/existsByPhone";
    public static final String user_findByCondition = "/user/findByCondition";
    public static final String user_getRyToken = "/user/getRyToken";
    public static final String user_getUserList = "/user/getUserList";
    public static final String user_info = "/user/info";
    public static final String user_login = "/user/login";
    public static final String user_loginByPhone = "/user/loginByPhone";
    public static final String user_loginByThirdParty = "/user/loginByThirdParty";
    public static final String user_refreshToken = "/user/refreshToken";
    public static final String user_registerByPhone = "/user/registerByPhone";
    public static final String user_registerByPhoneAndPass = "/user/registerByPhoneAndPass";
    public static final String user_registerByWechat = "/user/registerByWechat";
    public static final String user_searchUser = "/user/searchUser";
    public static final String user_sendCode = "/user/sendCode";
    public static final String user_sendCode0000 = "/user/sendCode0000";
    public static final String user_unbindWechat = "/user/unbindWechat";
    public static final String user_update = "/user/update";
    public static final String user_updateAddress = "/user/updateAddress";
    public static final String user_updateAvatar = "/user/updateAvatar";
    public static final String user_updateDisplayImages = "/user/updateDisplayImages";
    public static final String user_updatePassword = "/user/updatePassword";
    public static final String user_updatePhone = "/user/updatePhone";
    public static final String user_validatePhoneAndCode = "/user/validatePhoneAndCode";


    // 红包。
    public static final String coupon_post = "/coupon";
    public static final String coupon_put = "/coupon";
    public static final String coupon_byStoreId = "/coupon/byStoreId";
    public static final String coupon_getRedPacket = "/coupon/getRedPacket";
    public static final String coupon_getUserAllRedPacket = "/coupon/getUserAllRedPacket";
    public static final String coupon_getUserStoreRedPacket = "/coupon/getUserStoreRedPacket";

    // 订单。
    public static final String trade_get = "/trade";
    public static final String trade_fundToAccount = "/trade/fundToAccount";
    public static final String trade_pay = "/trade/pay";
    public static final String trade_refund = "/trade/refund";
    public static final String trade_getTradePage = "/trade/getTradePage";
    public static final String trade_exchange = "/trade/exchange";


    // 余额
    public static final String balance = "/user/balance";
    public static final String balance_getRecord = "/user/balance/getRecord";
    public static final String balance_tx = "/trade/cf79cbb3efcaab10";
    public static final String balance_store = "/store/balance";
    public static final String balance_store_getRecord = "/store/balance/getRecord";
    public static final String balance_store_tx = "/store/balance/withdraw";


    // 评论。
    public static final String comment = "/comment";
    public static final String comment_getUserCreditInfo = "/comment/getUserCreditInfo";

    // 匹配单位。
    public static final String matchUnit = "/matchUnit";
    public static final String matchUnit_changeMeetTime = "/matchUnit/changeMeetTime";
    public static final String matchUnit_getMatchsInAllStore = "/matchUnit/getMatchsInAllStore";
    public static final String matchUnit_getMatchsInStore = "/matchUnit/getMatchsInStore";
    public static final String matchUnit_goToMatchInStore = "/matchUnit/goToMatchInStore";
    public static final String matchUnit_quitMatchInStore = "matchUnit/quitMatchInStore";

    // 匹配团队。
    public static final String matchTeam = "/matchTeam";
    public static final String matchTeam_going = "/matchTeam/going";
    public static final String matchTeam_acceptTime = "/matchTeam/acceptTime";
    public static final String matchTeam_changeTime = "/matchTeam/changeTime";
    public static final String matchTeam_quitTeam = "/matchTeam/quitTeam";
    public static final String matchTeam_refuseTime = "/matchTeam/refuseTime";
    public static final String matchTeam_detail = "/matchTeam/detail";
    public static final String matchTeam_finish = "/matchTeam/finish";

    // 匹配邀请。
    public static final String matchInvite = "/matchInvite";
    public static final String matchInvite_getBeInvited = "/matchInvite/getBeInvited";
    public static final String matchInvite_accept = "/matchInvite/accept";
    public static final String matchInvite_cancel = "/matchInvite/cancel";
    public static final String matchInvite_getBeInvitedByStore = "/matchInvite/getBeInvitedByStore";
    public static final String matchInvite_getInviteByStore = "/matchInvite/getInviteByStore";

    public static final String matchInvite_friends = "/matchInvite/friends";
    public static final String matchInvite_friends_accept = "/matchInvite/friends/accept";
    public static final String matchInvite_friends_cancel = "/matchInvite/friends/cancel";
    public static final String matchInvite_friends_fromMe = "/matchInvite/friends/fromMe";
    public static final String matchInvite_friends_toMe = "/matchInvite/friends/toMe";

    // 二维码
    public static final String version_concat = "/version/concat";
    public static final String version_resolve = "/version/resolve";
}
