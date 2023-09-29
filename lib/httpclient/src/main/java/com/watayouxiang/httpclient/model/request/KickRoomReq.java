package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class KickRoomReq extends BaseReq<String> {
    /**
     * 将哪些用户加踢出群，userid用逗号隔开
     * 34343,43434,3434,34
     */
    private String uids;
    /**
     * 群id
     */
    private String roomId;

    public KickRoomReq(String uids, String roomId) {
        this.uids = uids;
        this.roomId = roomId;
    }

    @Override
    public String path() {
        return "/mytio/room/admin/kickRoom.tio_x";
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
