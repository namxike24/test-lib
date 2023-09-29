package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class ModifyRoomNoticeReq extends BaseReq<Void> {
    private String roomId;
    private String notice;

    @Override
    public String path() {
        return "/mytio/room/admin/modifyNotice.tio_x";
    }

    public ModifyRoomNoticeReq(String roomId, String notice) {
        this.roomId = roomId;
        this.notice = notice;
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("roomId", roomId)
                .append("notice", notice)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<Void>>() {
        }.getType();
    }
}
