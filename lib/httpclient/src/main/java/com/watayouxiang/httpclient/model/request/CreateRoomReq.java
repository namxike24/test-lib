package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.CreateGroupResp;
import com.watayouxiang.httpclient.model.response.CreateRoomResp;

import java.lang.reflect.Type;

public class CreateRoomReq extends BaseReq<CreateRoomResp> {
    private final String name;
    private final String uidList;
    private String intro;

    public CreateRoomReq(String name, String uidList) {
        this.name = name;
        this.uidList = uidList;
    }

    public CreateRoomReq(String name, String uidList, String intro) {
        this.name = name;
        this.uidList = uidList;
        this.intro = intro;
    }

    @Override
    public String path() {
        return "/mytio/room/createRoom.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("name", name)
                .append("uidList", uidList)
                .append("intro", intro)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<CreateRoomResp>>() {
        }.getType();
    }
}
