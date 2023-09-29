package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.ForbiddenFlagResp;

import java.lang.reflect.Type;

public class ForbiddenRoomFlagReq extends BaseReq<ForbiddenFlagResp> {
    private final String uid;
    private final String roomid;

    public ForbiddenRoomFlagReq(String uid, String roomid) {
        this.uid = uid;
        this.roomid = roomid;
    }

    @Override
    public TioMap<String, String> params() {
        return TioMap.getParamMap()
                .append("uid", uid)
                .append("roomid", roomid)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<ForbiddenFlagResp>>() {
        }.getType();
    }

    @Override
    public String path() {
        return "/mytio/room/admin/forbiddenFlag.tio_x";
    }
}
