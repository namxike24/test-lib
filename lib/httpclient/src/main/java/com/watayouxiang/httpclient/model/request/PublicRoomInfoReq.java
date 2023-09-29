package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.GroupInfoResp;
import com.watayouxiang.httpclient.model.response.RoomInfoResp;

import java.lang.reflect.Type;

public class PublicRoomInfoReq extends BaseReq<RoomInfoResp> {
    private final String userflag;
    private final String roomid;

    public PublicRoomInfoReq(String userflag, String roomid) {
        this.userflag = userflag;
        this.roomid = roomid;
    }

    @Override
    public String path() {
        return "/mytio/room.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("userflag", userflag)
                .append("roomid", roomid)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<RoomInfoResp>>() {
        }.getType();
    }
}
