package com.i77251680.contact.friend.user;

import com.i77251680.Client;
import com.i77251680.contact.Contact;
import com.i77251680.contact.Contactable;
import com.i77251680.entity.contacts.user.UserSimpleInfo;

public abstract class AbstractUser extends Contactable implements User, Contact {
    protected AbstractUser(Client client) {
        super(client);
    }

    public abstract long getUserId();

    public abstract String getAvatarUrl();

    public abstract String getAvatarUrl(int size);

    public abstract UserSimpleInfo getSimpleInfo();

    public void markRead() {

    }

    public void markRead(long time) {

    }

    public void recallMsg() {
    }

    public void sendMsg() {
    }

    public void setFriendReq() {
    }

    public void setGroupReq() {
    }

    public void setGroupInvite() {
    }

    public void getFileInfo() {
    }

    public void getFileUrl() {
    }
}
