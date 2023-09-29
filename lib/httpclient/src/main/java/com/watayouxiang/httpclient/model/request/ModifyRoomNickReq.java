package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class ModifyRoomNickReq extends BaseReq<String> {
    private String roomid;
    private String nick;

    @Override
    public String path() {
        return "/mytio/room/modifyRoomNick.tio_x";
    }

    public ModifyRoomNickReq(String groupid, String nick) {
        this.roomid = groupid;
        this.nick = nick;
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("roomid", roomid)
                .append("nick", nick)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<String>>() {
        }.getType();
    }
}
