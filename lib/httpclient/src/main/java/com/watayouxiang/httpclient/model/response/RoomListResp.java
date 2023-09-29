package com.watayouxiang.httpclient.model.response;

import java.io.Serializable;

public class RoomListResp implements Serializable {
/*        {
            "avatarautoflag": 1,
                "createtime": "2023-07-13 10:12:16",
                "msgactflag": 1,
                "applyflag": 1,
                "remark": "",
                "avatar": "\/platform\/tio-chat\/202307\/wx\/room\/avatar\/71\/7668\/1198364\/88176417\/745413897",
                "type": "",
                "uid": 102237,
                "autoflag": 2,
                "joinmode": 2,
                "intro": "",
                "name": "Public room 1",
                "friendflag": 1,
                "maximum": 1001,
                "id": "1",
                "updatetime": "2023-07-13 10:12:16",
                "notice": "",
                "status": 1
        }*/

        public  int avatarautoflag;
        public  String createtime;
        public  Integer msgactflag;
        public  Integer applyflag;
        public  String remark;
        public  String avatar;
        public  String type;
        public  Integer uid;
        public  Integer autoflag;
        public  Integer joinmode;
        public  String intro;
        public  String name;
        public  Integer friendflag;
        public  Integer maximum;
        public  String id;
        public  String updatetime;
        public  String notice;
        public  Integer status;
}
