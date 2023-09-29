package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

public class RoomModifyReviewReq extends BaseReq<Object> {
    /**
     * 1 开启邀请审核；2 关闭邀请审核
     */
    private final String mode;
    private final String roomId;

    public RoomModifyReviewReq(String mode, String roomid) {
        this.mode = mode;
        this.roomId = roomid;
    }

    @Override
    public String path() {
        return "/mytio/room/admin/modifyReview.tio_x";
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
        return new TypeToken<BaseResp<Object>>() {
        }.getType();
    }
}
