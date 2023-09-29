package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.response.RoomListResp;

import java.lang.reflect.Type;
import java.util.List;

public class GetListRoomReq extends BaseReq<List<RoomListResp>> {
    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<List<RoomListResp>>>() {
        }.getType();
    }

    @Override
    public String path() {
        return "/mytio/room/listPubRoom.tio_x";
    }
}
