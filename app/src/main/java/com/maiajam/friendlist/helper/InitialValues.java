package com.maiajam.friendlist.helper;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.maiajam.friendlist.R;
import com.maiajam.friendlist.adapter.FriendListAdapter;
import com.maiajam.friendlist.data.local.entity.FriendListEntity;

import java.util.List;

public class InitialValues {

    public static void setGroup(Context context, Spinner spinner)
    {
        SpinnerAdapter adapter = ArrayAdapter.createFromResource(context, R.array.Item_groupNames,android.R.layout.simple_spinner_item);
        ((ArrayAdapter) adapter).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public static void setFirendList(Context baseContext, RecyclerView friendListListRec, List<FriendListEntity> friendList) {

        FriendListAdapter adapter = new FriendListAdapter(baseContext,friendList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(baseContext);
        friendListListRec.setLayoutManager(layoutManager);
        friendListListRec.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
