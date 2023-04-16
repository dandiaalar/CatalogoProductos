package com.example.catalogodeproductos.model.management;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.catalogodeproductos.model.pojos.Criteria;

import java.util.List;
@Dao
public interface DaoCriteria {

    @Query("SELECT * FROM criteria")
    List<Criteria> getCriteriaList();

    @Insert
    void insertCriteria(Criteria criteria);
}
