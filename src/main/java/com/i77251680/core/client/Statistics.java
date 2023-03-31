package com.i77251680.core.client;

import com.i77251680.utils.Time;

public class Statistics {
    public long start_time = Time.timestamp();
    public int lost_times = 0;
    public int sent_pkt_cnt = 0;
    public int recv_pkt_cnt = 0;
    public int lost_pkt_cnt = 0;
    public int sent_msg_cnt = 0;
    public int recv_msg_cnt = 0;
    public int msg_cnt_per_min = 0;
    public String remote_ip = "";
    public int remote_port = 0;

    public static Statistics get() {
        return new Statistics();
    }
}
