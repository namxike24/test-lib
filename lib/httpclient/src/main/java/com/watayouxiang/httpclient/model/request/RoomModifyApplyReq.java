package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class RoomModifyApplyReq extends BaseReq<String> {
    /**
     * 1 开启；2 关闭
     */
    private String mode;
    private String roomId;

    public RoomModifyApplyReq(boolean mode, String roomId) {
        this.mode = mode ? "1" : "2";
        this.roomId = roomId;
    }

    @Override
    public String path() {
        return "/mytio/room/admin/modifyApply.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("mode", mode)
                .append("roomId", roomId)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<String>>() {
        }.getType();
    }
}
