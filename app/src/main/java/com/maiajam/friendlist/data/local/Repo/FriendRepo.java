package com.maiajam.friendlist.data.local.Repo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import com.maiajam.friendlist.data.local.entity.FriendListEntity;
import com.maiajam.friendlist.data.local.room.RoomDao;
import com.maiajam.friendlist.data.local.room.RoomManger;

import java.util.List;

public class FriendRepo {

    private static FriendRepo friendRepo ;
    private final RoomDao roomDao ;
    private LiveData<List<FriendListEntity>> friendList ;

    public FriendRepo(Application appContext) {
        RoomManger roomManger =RoomManger.getInstance(appContext);
        roomDao = roomManger.RoomDao();
        friendList = roomDao.getAllFriend();
    }

    public static FriendRepo getFriendRepoInstance(Application appContext)
    {
        if(friendRepo == null)
        {
            friendRepo = new FriendRepo(appContext);
        }
        return friendRepo;
    }

    public LiveData<List<FriendListEntity>> getAllFriends()
    {
        return friendList;
    }

    public void AddNewFriend(String s, final String name)
    {
        final FriendListEntity friendItem = new FriendListEntity();
        friendItem.setName(name);
        friendItem.setGroupName(name);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
              roomDao.AddFreind(friendItem);
            }
        });
    }

    public void deleteFreinds(final FriendListEntity friendListEntity)
    {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                roomDao.delete(friendListEntity);
            }
        });
    }


}
