package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class LeaveRoomReq extends BaseReq<String> {
    private String uid;
    private String roomid;

    public LeaveRoomReq(String uid, String roomid) {
        this.uid = uid;
        this.roomid = roomid;
    }

    @Override
    public String path() {
        return "/mytio/room/leaveRoom.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("uid", uid)
                .append("roomid", roomid)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<String>>() {
        }.getType();
    }
}
