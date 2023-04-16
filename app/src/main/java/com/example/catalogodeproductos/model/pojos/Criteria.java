package com.example.catalogodeproductos.model.pojos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.catalogodeproductos.model.management.DateTypeConvertor;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
public class Criteria {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    private int key;
    private String criteria;
    @TypeConverters(DateTypeConvertor.class)
    private Date date;

    public Criteria(int key, String criteria, Date date) {
        this.key = key;
        this.criteria = criteria;
        this.date = date;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
