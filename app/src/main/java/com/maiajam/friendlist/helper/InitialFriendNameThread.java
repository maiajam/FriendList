package com.maiajam.friendlist.helper;

import android.content.Context;
import android.os.AsyncTask;

import com.maiajam.friendlist.data.local.room.RoomDao;
import com.maiajam.friendlist.data.local.room.RoomManger;

public class InitialFriendNameThread extends Thread {


    Context mContext;
    public InitialFriendNameThread(Context context) {
        mContext = context ;
    }

    @Override
    public void run() {
        RoomManger roomManger = RoomManger.getInstance(mContext);
        RoomDao roomDao = roomManger.RoomDao();

    }
}
