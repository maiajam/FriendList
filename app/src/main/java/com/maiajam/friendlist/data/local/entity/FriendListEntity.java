package com.maiajam.friendlist.data.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "FriendList")

public class FriendListEntity {

    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String Name ;
    private String GroupName;

    public FriendListEntity() {
    }

    public FriendListEntity(int id, String name) {
        this.id = id;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }
}
