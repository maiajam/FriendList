package com.maiajam.friendlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maiajam.friendlist.R;
import com.maiajam.friendlist.data.local.entity.FriendListEntity;

import java.util.List;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.FriendHolder> {

    private List<FriendListEntity> FriendList;
    private Context context ;

    public FriendListAdapter(Context baseContext, List<FriendListEntity> friendList) {
        FriendList = friendList ;
        context = baseContext ;
    }
    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_allfriends,viewGroup,false);
        return new FriendHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder friendHolder, int i) {

        FriendListEntity friendItem = FriendList.get(i);
        String name = friendItem.getName();
        friendHolder.FriendName_txt.setText(name);
    }

    @Override
    public int getItemCount() {
        return FriendList.size();
    }

    class FriendHolder extends RecyclerView.ViewHolder {

        TextView FriendName_txt;
        public FriendHolder(@NonNull View itemView) {
            super(itemView);

            FriendName_txt = (TextView)itemView.findViewById(R.id.allFriends_item_FriendName_TV);
        }
    }
}
