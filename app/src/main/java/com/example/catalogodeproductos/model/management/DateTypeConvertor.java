package com.example.catalogodeproductos.model.management;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateTypeConvertor {

    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null:new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null:date.getTime();
    }
}
