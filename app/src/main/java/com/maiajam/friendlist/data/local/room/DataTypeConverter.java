package com.maiajam.friendlist.data.local.room;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class DataTypeConverter {
   @TypeConverter
   public static List<String> fromString(String value) {
       Type listType = new TypeToken<List<String>>() {}.getType();
       return new Gson().fromJson(value, listType);
   }

   @TypeConverter
   public static String fromArrayList(List<String> list) {
       Gson gson = new Gson();
       String json = gson.toJson(list);
       return json;
   }

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}