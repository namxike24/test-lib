package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.ForbiddenUserListResp;

import java.lang.reflect.Type;

public class ForbiddenRoomUserListReq extends BaseReq<ForbiddenUserListResp> {
    private final String pageNumber;
    private final String roomid;
    private final String searchkey;

    public ForbiddenRoomUserListReq(String pageNumber, String roomid, String searchkey) {
        this.pageNumber = pageNumber;
        this.roomid = roomid;
        this.searchkey = searchkey;
    }

    @Override
    public TioMap<String, String> params() {
        return TioMap.getParamMap()
                .append("pageNumber", pageNumber)
                .append("roomid", roomid)
                .append("searchkey", searchkey)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<ForbiddenUserListResp>>() {
        }.getType();
    }

    @Override
    public String path() {
        return "/mytio/room/admin/forbiddenUserList.tio_x";
    }
}
