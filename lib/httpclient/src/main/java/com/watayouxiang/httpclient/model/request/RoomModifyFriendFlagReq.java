package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;


public class RoomModifyFriendFlagReq extends BaseReq<Object> {
    /**
     * 群内互加好友开关：1开启，2关闭
     */
    private final String friendflag;
    private final String roomId;

    public RoomModifyFriendFlagReq(String friendflag, String roomId) {
        this.friendflag = friendflag;
        this.roomId = roomId;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<Object>>() {
        }.getType();
    }

    @Override
    public String path() {
        return "/mytio/room/admin/modifyFriendFlag.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("friendflag", friendflag)
                .append("roomId", roomId)
                ;
    }
}
