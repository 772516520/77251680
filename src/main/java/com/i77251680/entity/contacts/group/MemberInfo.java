package com.i77251680.entity.contacts.group;

import com.i77251680.entity.enums.Gender;
import com.i77251680.entity.enums.GroupRole;

public class MemberInfo {
    public long group_id;
    public long user_id;
    public String nickname;
    public String card;
    public Gender gender;
    public int age;
    public String area;
    public long join_time;
    public long last_sent_time;
    public int level;
    public String rank;
    public GroupRole role;
    public String title;
    public long title_expire_time;
    public long shutUp_time;
    public long update_time;
}
