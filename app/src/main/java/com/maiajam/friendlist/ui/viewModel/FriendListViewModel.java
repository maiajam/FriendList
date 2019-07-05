package com.maiajam.friendlist.ui.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.maiajam.friendlist.data.local.Repo.FriendRepo;
import com.maiajam.friendlist.data.local.entity.FriendListEntity;

import java.util.List;

public class FriendListViewModel extends AndroidViewModel {

    private FriendRepo friendRepo ;
    private LiveData<List<FriendListEntity>> friendList ;

    public FriendListViewModel(@NonNull Application application) {
        super(application);
        friendRepo = FriendRepo.getFriendRepoInstance(getApplication());
        friendList = friendRepo.getAllFriends();
    }

    public LiveData<List<FriendListEntity>> getFriendList()
    {
        return friendList ;
    }

    public void AddNewFriend(String name,String groupName)
    {
        friendRepo.AddNewFriend(name,groupName);
    }

    public void deleteFriend(FriendListEntity friendListEntity)
    {
        friendRepo.deleteFreinds(friendListEntity);
    }
}
