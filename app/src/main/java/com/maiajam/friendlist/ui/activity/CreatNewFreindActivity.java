package com.maiajam.friendlist.ui.activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.maiajam.friendlist.R;
import com.maiajam.friendlist.helper.CheckValidation;
import com.maiajam.friendlist.helper.InitialValues;
import com.maiajam.friendlist.ui.viewModel.FriendListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreatNewFreindActivity extends AppCompatActivity {

    @BindView(R.id.CreatNewFriend_labelName_TV)
    TextView CreatNewFriendLabelNameTV;
    @BindView(R.id.CreatNewFriend_FreindName_ET)
    EditText CreatNewFriendFreindNameET;
    @BindView(R.id.CreatNewFriend_labelSelectGroup_TV)
    TextView CreatNewFriendLabelSelectGroupTV;
    @BindView(R.id.CreatNewFriend_GroupName_SP)
    Spinner CreatNewFriendGroupNameSP;
    @BindView(R.id.CreatNewFriend_Add_B)
    Button CreatNewFriendAddB;
    @BindView(R.id.CreatNewFriend_Cancel_B)
    Button CreatNewFriendCancelB;
    private String friendName;
    private String groupName;
    private FriendListViewModel friendListViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_new_freind);
        ButterKnife.bind(this);
        friendListViewModel =  ViewModelProviders.of(this).get(FriendListViewModel.class);
        InitialValues.setGroup(getBaseContext(),CreatNewFriendGroupNameSP);
    }

    @OnClick({R.id.CreatNewFriend_Add_B, R.id.CreatNewFriend_Cancel_B})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.CreatNewFriend_Add_B:
                if(CheckValidation.checkNewFriendInput(getBaseContext(),
                        CreatNewFriendFreindNameET.getText().toString(),
                        CreatNewFriendGroupNameSP.getSelectedItem().toString()))
                {
                    friendListViewModel.AddNewFriend(CreatNewFriendFreindNameET.getText().toString(),CreatNewFriendGroupNameSP.getSelectedItem().toString());
                    finish();
                }
                break;
            case R.id.CreatNewFriend_Cancel_B:
                finish();
                break;
        }
    }
}
