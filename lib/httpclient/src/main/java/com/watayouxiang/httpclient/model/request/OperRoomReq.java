package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

/**
 * author : TaoWang
 * date : 2020/3/4
 * desc :
 *
 * @see String
 */
public class OperRoomReq extends BaseReq<String> {
    /**
     * 聊天会话-----------删除聊天会话/清空聊天记录--------这这两者必填
     */
    private String chatlinkid;
    /**
     * 操作的对象----------拉黑操作必填
     */
    private String touid;
    /**
     * 1: 删除聊天会话 (删除聊天记录);
     * 11: 删除聊天会话 (不删除聊天记录);
     * 2: 拉黑；
     * 3：恢复拉黑；
     * 8：清空聊天记录
     * 99: 投诉
     * ------------必填
     */
    private String oper;

    // 投诉
    public static OperRoomReq complaint(String chatlinkid) {
        OperRoomReq req = new OperRoomReq();
        req.chatlinkid = chatlinkid;
        req.oper = "99";
        return req;
    }

    // 拉黑
    public static OperRoomReq blackList(String touid, boolean addBlackList) {
        OperRoomReq req = new OperRoomReq();
        req.touid = touid;
        req.oper = addBlackList ? "2" : "3";
        return req;
    }

    // 删除聊天会话
    public static OperRoomReq deleteSession(String chatlinkid, boolean isDeleteChatRecord) {
        OperRoomReq req = new OperRoomReq();
        req.oper = isDeleteChatRecord ? "1" : "11";
        req.chatlinkid = chatlinkid;
        return req;
    }

    // 清空聊天记录
    public static OperRoomReq deleteChatRecord(String chatlinkid) {
        OperRoomReq req = new OperRoomReq();
        req.oper = "8";
        req.chatlinkid = chatlinkid;
        return req;
    }

    /**
     * 置顶聊天
     *
     * @param chatlinkid 会话id
     * @param topChat    是否置顶
     */
    public static OperRoomReq topChat(String chatlinkid, boolean topChat) {
        OperRoomReq req = new OperRoomReq();
        req.oper = topChat ? "21" : "22";
        req.chatlinkid = chatlinkid;
        return req;
    }

    @Override
    public String path() {
        return "/mytio/room/oper.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("chatlinkid", chatlinkid)
                .append("touid", touid)
                .append("oper", oper)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<String>>() {
        }.getType();
    }
}
