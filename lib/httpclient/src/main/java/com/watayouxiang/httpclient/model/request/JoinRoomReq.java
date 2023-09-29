package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class JoinRoomReq extends BaseReq<String> {
    /**
     * 用户列表，逗号分隔
     */
    private final String uids;
    private final String roomId;

    public JoinRoomReq(String uids, String roomId) {
        this.uids = uids;
        this.roomId = roomId;
    }

    @Override
    public String path() {
        return "/mytio/room/admin/joinRoom.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("uids", uids)
                .append("roomId", roomId)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<String>>() {
        }.getType();
    }
}
