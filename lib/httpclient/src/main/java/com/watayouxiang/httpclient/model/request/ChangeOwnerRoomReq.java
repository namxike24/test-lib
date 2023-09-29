package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.ChangeOwnerResp;

import java.lang.reflect.Type;

/**
 * author : TaoWang
 * date : 2020/3/2
 * desc :
 */
public class ChangeOwnerRoomReq extends BaseReq<ChangeOwnerResp> {
    private String otheruid;
    private String roomId;

    public ChangeOwnerRoomReq(String otheruid, String roomId) {
        this.otheruid = otheruid;
        this.roomId = roomId;
    }

    @Override
    public String path() {
        return "/mytio/room/admin/changeOwner.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("otheruid", otheruid)
                .append("roomId", roomId)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<ChangeOwnerResp>>() {
        }.getType();
    }
}
