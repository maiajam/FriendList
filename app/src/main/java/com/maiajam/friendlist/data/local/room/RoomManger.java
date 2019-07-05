package com.maiajam.friendlist.data.local.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.maiajam.friendlist.data.local.entity.FriendListEntity;

@Database(entities = FriendListEntity.class,version = 1,exportSchema = false)
@TypeConverters({DataTypeConverter.class})
public abstract class RoomManger extends RoomDatabase {

    private static Context context ;
    private static RoomManger roomManger ;
    public abstract RoomDao RoomDao();

    public static final RoomManger.Callback roomMangerCallBack = new RoomManger.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {

        }
    };

    public static RoomManger getInstance(Context context)
    {
        if(roomManger == null)
        {
            roomManger = Room.databaseBuilder(context.getApplicationContext(), RoomManger.class,
                    "callJots_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomMangerCallBack)
                    .build();
        }
        return roomManger ;
    }
}
