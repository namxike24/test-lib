package com.watayouxiang.httpclient.model.response;

import com.watayouxiang.httpclient.model.vo.GroupRoleEnum;

public class RoomInfoResp {

    /**
     * roomuser : {
     * "viewstatus": 1,
     * "createtime": "Aug 17, 2023 4:23:18 AM",
     * "msgfreeflag": 2,
     * "nickviewflag": 1,
     * "roomrole": 2,
     * "roomnick": "S190000010043",
     * "forbiddenduration": 0,
     * "roomid": 59,
     * "uid": 102256,
     * "autoflag": 1,
     * "forbiddenflag": 2,
     * "roomavator": "\/platform\/tio-chat\/202307\/user\/avatar\/90\/7687\/1198383\/88176436\/74541389804\/9\/153623\/1682308528494223360_sm.jpg",
     * "isaddress": 1,
     * "id": 115,
     * "srcnick": "S190000010043",
     * "updatetime": "Aug 17, 2023 4:23:18 AM",
     * "status": 1
     * }
     * state : ok
     * room : {
     * "allactflag": 1,
     * "allstartflag": 1,
     * "applyflag": 1,
     * "autoflag": 2,
     * "avatar": "\/platform\/tio-chat\/202308\/wx\/room\/avatar\/71\/7668\/1198364\/88176417\/74541389785\/15\/161740\/1696089654467633152_sm.jpg",
     * "avatarautoflag": 1,
     * "createtime": "2023-08-09 07:19:15",
     * "forbiddenflag": 2,
     * "friendflag": 1,
     * "id": "59",
     * "intro": "",
     * "joinmode": 2,
     * "joinnum": 18,
     * "maximum": 1001,
     * "metaid": "59",
     * "msgactflag": 1,
     * "name": "Public room 59",
     * "notice": "",
     * "remark": "",
     * "status": 1,
     * "type": "",
     * "uid": 102237,
     * "updatetime": "2023-08-28 09:17:40"
     * }
     */

    public RoomUser roomuser;
    public String state;
    public Room room;

    public static class RoomUser {
        /**
         * "viewstatus": 1,
         * "createtime": "Aug 17, 2023 4:23:18 AM",
         * "msgfreeflag": 2,
         * "nickviewflag": 1,
         * "roomrole": 2,
         * "roomnick": "S190000010043",
         * "forbiddenduration": 0,
         * "roomid": 59,
         * "uid": 102256,
         * "autoflag": 1,
         * "forbiddenflag": 2,
         * "roomavator": "\/platform\/tio-chat\/202307\/user\/avatar\/90\/7687\/1198383\/88176436\/74541389804\/9\/153623\/1682308528494223360_sm.jpg",
         * "isaddress": 1,
         */

        public int viewstatus;
        public String createtime;

        /**
         * Message Do Not Disturb: 1 to turn on, 2 to turn off
         */
        public int msgfreeflag;
        public int nickviewflag;

        /**
         * Room member role：1：Leader；2：Member；3：Admin
         */
        public int roomrole;
        /**
         * Group nickname
         */
        public String roomnick;
        public int forbiddenduration;
        public int roomid;
        public int uid;
        public int autoflag;
        public int forbiddenflag;
        public String roomavator;
        public int isaddress;
        public int id;
        /**
         * original nickname
         */
        public String srcnick;
        public String updatetime;
        public int status;

        public GroupRoleEnum getRoomRoleEnum() {
            return GroupRoleEnum.codeOf(roomrole);
        }
    }

    public static class Room {

        /**
         * "allactflag": 1,
         * "allstartflag": 1,
         * "applyflag": 1,
         * "autoflag": 2,
         * "avatar": "\/platform\/tio-chat\/202308\/wx\/room\/avatar\/71\/7668\/1198364\/88176417\/74541389785\/15\/161740\/1696089654467633152_sm.jpg",
         * "avatarautoflag": 1,
         * "createtime": "2023-08-09 07:19:15",
         * "forbiddenflag": 2,
         * "friendflag": 1,
         * "id": "59",
         * "intro": "",
         * "joinmode": 2,
         * "joinnum": 18,
         * "maximum": 1001,
         * "metaid": "59",
         * "msgactflag": 1,
         * "name": "Public room 59",
         * "notice": "",
         * "remark": "",
         * "status": 1,
         * "type": "",
         * "uid": 102237,
         * "updatetime": "2023-08-28 09:17:40"
         */


        public int allactflag;
        public int allstartflag;
        public int applyflag;
        public int autoflag;
        public String avatar;
        public int avatarautoflag;
        public String createtime;
        public int forbiddenflag;
        public int friendflag;
        public String id;
        public String intro;
        public int joinmode;
        public int joinnum;
        public int maximum;
        public String metaid;
        public int msgactflag;
        public String name;
        public String notice;
        public String remark;
        public int status;
        public String type;
        public int uid;
        public String updatetime;

        public boolean isAllowInviteMember() {
            return applyflag == 1;
        }

        public boolean isForbiddenMemberTalk() {
            return forbiddenflag == 1;
        }
    }
}
