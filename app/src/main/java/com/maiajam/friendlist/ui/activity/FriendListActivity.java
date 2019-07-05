package com.maiajam.friendlist.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.maiajam.friendlist.R;
import com.maiajam.friendlist.adapter.FriendListAdapter;
import com.maiajam.friendlist.data.local.entity.FriendListEntity;
import com.maiajam.friendlist.helper.InitialValues;
import com.maiajam.friendlist.ui.viewModel.FriendListViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FriendListActivity extends AppCompatActivity {

    @BindView(R.id.FriendList_list_Rec)
    RecyclerView FriendListListRec;
    FriendListAdapter adapter;
    FriendListViewModel friendListViewModel;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        friendListViewModel = ViewModelProviders.of(this).get(FriendListViewModel.class);
        friendListViewModel.getFriendList().observe(this, new Observer<List<FriendListEntity>>() {
            @Override
            public void onChanged(@Nullable List<FriendListEntity> friendListEntities) {
                InitialValues.setFirendList(getBaseContext(), FriendListListRec, friendListEntities);
            }
        });
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(FriendListActivity.this, CreatNewFreindActivity.class));
    }
}
