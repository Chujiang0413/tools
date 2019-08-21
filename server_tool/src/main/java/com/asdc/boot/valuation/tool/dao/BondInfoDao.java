package com.asdc.boot.valuation.tool.dao;

import org.hibernate.validator.constraints.URL;

import java.util.List;

public interface BondInfoDao {

    /**
     *  获取发行机构/受托机构（全称）
     */
    public List<String> getTrusetee(String user_id);


}
