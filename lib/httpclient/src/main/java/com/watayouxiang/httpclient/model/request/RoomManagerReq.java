package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class RoomManagerReq extends BaseReq<Object> {
    private final String uid;
    private final String roomId;
    /**
     * 角色：2：普通成员；3：管理员
     */
    private final String roomRole;

    public RoomManagerReq(String uid, String roomId, String roomRole) {
        this.uid = uid;
        this.roomId = roomId;
        this.roomRole = roomRole;
    }

    @Override
    public TioMap<String, String> params() {
        return TioMap.getParamMap()
                .append("uid", uid)
                .append("roomId", roomId)
                .append("roomRole", roomRole)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<Object>>() {
        }.getType();
    }

    @Override
    public String path() {
        return "/mytio/room/admin/manager.tio_x";
    }
}
