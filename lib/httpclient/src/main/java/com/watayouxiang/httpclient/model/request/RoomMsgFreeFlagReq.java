package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

/**
 * <pre>
 *     author : TaoWang
 *     e-mail : watayouxiang@qq.com
 *     time   : 2021/02/02
 *     desc   : 会话免打扰操作
 * </pre>
 */
public class RoomMsgFreeFlagReq extends BaseReq<Object> {

    private final String roomid;
    /**
     * freeflag:1:开启免打扰，2：不开启
     */
    private final String freeflag;

    public RoomMsgFreeFlagReq(String roomid, String freeflag) {
        this.roomid = roomid;
        this.freeflag = freeflag;
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("roomid", roomid)
                .append("freeflag", freeflag)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<Object>>() {
        }.getType();
    }

    @Override
    public String path() {
        return "/mytio/room/msgfreeflag.tio_x";
    }
}
