package com.watayouxiang.httpclient.model.request;

import com.google.gson.reflect.TypeToken;
import com.watayouxiang.httpclient.model.BaseReq;
import com.watayouxiang.httpclient.model.BaseResp;
import com.watayouxiang.httpclient.model.TioMap;

import java.lang.reflect.Type;

/**
 * author : TaoWang
 * date : 2020/4/1
 * desc :
 * <p>
 * {@link Void}
 */
public class ModifyRoomIntroReq extends BaseReq<Void> {
    private String roomId;
    private String intro;

    @Override
    public String path() {
        return "/mytio/room/admin/modifyIntro.tio_x";
    }

    public ModifyRoomIntroReq(String roomId, String intro) {
        this.roomId = roomId;
        this.intro = intro;
    }

    @Override
    public TioMap<String, String> params() {
        return super.params()
                .append("roomId", roomId)
                .append("intro", intro)
                ;
    }

    @Override
    public Type bodyType() {
        return new TypeToken<BaseResp<Void>>() {
        }.getType();
    }
}
