package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class ModifyRoomNameReq extends BaseReq<String> {
    private String roomId;
    private String name;

    @Override
    public String path() {
        return "/mytio/room/admin/modifyName.tio_x";
    }

    public ModifyRoomNameReq(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("roomId", roomId)
                .append("name", name)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<String>>() {
        }.getType();
    }
}
