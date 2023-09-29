package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.ActChatResp;

import java.lang.reflect.Type;

/**
 * author : TaoWang
 * date : 2020-02-21
 * desc :
 */
public class ActPublicChatReq extends BaseReq<ActChatResp> {
    private String touid;
    private String roomId;

    private ActPublicChatReq(String touid, String roomId) {
        this.touid = touid;
        this.roomId = roomId;
    }

    public static ActPublicChatReq getRoom(String roomId) {
        return new ActPublicChatReq(null, roomId);
    }

    @Override
    public String path() {
        return "/mytio/room/actChat.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("touid", touid)
                .append("roomId", roomId)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<ActChatResp>>() {
        }.getType();
    }
}
