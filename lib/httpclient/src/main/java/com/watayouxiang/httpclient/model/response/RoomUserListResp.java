package com.watayouxiang.httpclient.model.response;

import com.watayouxiang.httpclient.model.vo.GroupRoleEnum;

import java.util.List;

public class RoomUserListResp {
    public boolean firstPage;
    public boolean lastPage;
    public List<RoomMember> list;
    public int pageNumber;
    public int pageSize;
    public int totalPage;
    public int totalRow;

    public static class RoomMember {
        /**
         * "nick": "Timi",
         * "uid": 102237,
         * "roomrole": 1,
         * "forbiddenflag": 2,
         * "forbiddenduration": 0,
         * "id": "111",
         * "avatar": "\/platform\/tio-chat\/avatar.jpg",
         * "srcnick": "Timi",
         * "roomid": "59"
         */


        public String nick;
        public int uid;
        public int roomrole;
        public int forbiddenflag;
        public int forbiddenduration;
        public String id;
        public String avatar;
        public String srcnick;
        public String roomid;

        public boolean isGroupOwner() {
            return getRoomRule() == GroupRoleEnum.OWNER;
        }

        public GroupRoleEnum getRoomRule(){
            return GroupRoleEnum.codeOf(roomrole);
        }
    }
}
