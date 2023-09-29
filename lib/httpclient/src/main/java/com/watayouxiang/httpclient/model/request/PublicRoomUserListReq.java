package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;
import com.watayouxiang.httpclient.model.response.GroupUserListResp;
import com.watayouxiang.httpclient.model.response.RoomUserListResp;

import java.lang.reflect.Type;

/**
 * author : TaoWang
 * date : 2020/2/27
 * desc : 群人员列表
 */
public class PublicRoomUserListReq extends BaseReq<RoomUserListResp> {
    /**
     * 群id
     */
    private final String roomid;
    /**
     * 分页页数
     */
    private final String pageNumber;
    /**
     * 搜索字段
     */
    private final String searchkey;

    public PublicRoomUserListReq(String roomid, String pageNumber, String searchkey) {
        this.roomid = roomid;
        this.pageNumber = pageNumber;
        this.searchkey = searchkey;
    }

    @Override
    public String path() {
        return "/mytio/room/roomUserList.tio_x";
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("pageNumber", pageNumber)
                .append("roomid", roomid)
                .append("searchkey", searchkey)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<RoomUserListResp>>() {
        }.getType();
    }
}
