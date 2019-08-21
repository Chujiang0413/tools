package com.asdc.boot.valuation.tool.dao.impl;

import com.asdc.boot.valuation.tool.dao.BondInfoDao;
import org.springframework.stereotype.Repository;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import java.util.List;
//@Repository("bondInfoDao")
public class BondInfoDaoImpl implements BondInfoDao {
//
//    @PersistenceContext
//    private EntityManager em;

    //@Override
    public List<String> getTrusetee(String user_id) {
//
//        StringBuilder sql = new StringBuilder();
//        if(user_id != null && !"".equals(user_id)){
//            sql.append("select distinct trustee from bond_info where trustee is not null and trustee != '' and project_id in " +
//                    "(select project_id from project_pool where user_id="+user_id+")");
//        }else{
//            sql.append("select distinct trustee from bond_info where trustee is not null and trustee != ''");
//        }
//        Query query = em.createNativeQuery(sql.toString());
//        return (List<String>) query.getResultList();
        return null;
    }
}
