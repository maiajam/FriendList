package com.maiajam.friendlist.data.local.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;


import com.maiajam.friendlist.data.local.entity.FriendListEntity;

import java.util.Date;
import java.util.List;

@Dao
public abstract class RoomDao {

    // insert

    @Insert
    public abstract void AddFreind(FriendListEntity friendListEntity);

    @Query("SELECT * FROM FriendList")
    public abstract LiveData<List<FriendListEntity>> getAllFriend();

    @Delete
    public abstract void delete(FriendListEntity friendListEntity);
}
