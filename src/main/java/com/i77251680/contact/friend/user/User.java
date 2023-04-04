package com.i77251680.contact.friend.user;

import com.i77251680.entity.contacts.user.UserSimpleInfo;

public interface User {
    long getUserId();

    /**
     * 查看资料 (待实现)
     *
     * @return UserSimpleInfo
     */
    UserSimpleInfo getSimpleInfo();

    /**
     * 标记`time`之前为已读，默认当前时间 (待实现)
     */
    void markRead();

    void markRead(long time);

    /**
     * 撤回消息 (待实现)
     */
    void recallMsg();

    /**
     * 发送消息 (待实现)
     */
    void sendMsg();

    /**
     * 同意好友申请 (待实现)
     */
    void setFriendReq();

    /**
     * 同意入群申请 (待实现)
     */
    void setGroupReq();

    /**
     * 同意群邀请 (待实现)
     */
    void setGroupInvite();

    void getFileInfo();

    /**
     * 获取离线文件下载地址 (待实现)
     */
    void getFileUrl();
}
