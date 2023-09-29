package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.DelGroupResp;

import java.lang.reflect.Type;

public class DelRoomReq extends BaseReq<DelGroupResp> {
    private final String uid;
    private final String roomId;

    public DelRoomReq(String uid, String roomId) {
        this.uid = uid;
        this.roomId = roomId;
    }

    @Override
    public String path() {
        return "/mytio/room/admin/delRoom.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("uid", uid)
                .append("roomId", roomId)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<DelGroupResp>>() {
        }.getType();
    }
}
