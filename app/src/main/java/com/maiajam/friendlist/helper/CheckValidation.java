package com.maiajam.friendlist.helper;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.maiajam.friendlist.R;

public class CheckValidation {

    public static boolean checkNewFriendInput(Context context, String name, String GroupName)
    {
        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(context,context.getString(R.string.Toast_EnterName),Toast.LENGTH_LONG).show();
            return false;
        }
        if(TextUtils.isEmpty(GroupName))
        {
            Toast.makeText(context,context.getString(R.string.Toast_SelectGroup),Toast.LENGTH_LONG).show();
            return false;
        }
        return true ;
    }


}
