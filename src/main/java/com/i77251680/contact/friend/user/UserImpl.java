package com.i77251680.contact.friend.user;

import com.i77251680.Client;
import com.i77251680.entity.contacts.user.UserSimpleInfo;
import com.i77251680.entity.enums.Gender;

public class UserImpl extends AbstractUser implements User {
    protected long uid;

    protected UserImpl(Client client, long uid) {
        super(client);
        this.uid = uid;
    }

    public long getUserId() {
        return this.uid;
    }

    public String getAvatarUrl() {
        return "https://q1.qlogo.cn/g?b=qq&s=0&nk=" + this.uid;

    }

    public String getAvatarUrl(int size) {
        return "https://q1.qlogo.cn/g?b=qq&s=" +
                size +
                "&nk=" +
                this.uid;
    }

    public UserSimpleInfo getSimpleInfo() {
        return UserSimpleInfo.set(0, "", Gender.unknown, 0, "");
    }

}
