package com.aaa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.aaa.entity.power;

@Component
public class powerDao extends BaseDao<power> {
	
	@SuppressWarnings("unchecked")
	//查询出所有一级菜单
	public List<power> findPowerOne(){
		Session session=factory.openSession();
		String sql="select * from power where p_mgr=0";
		Query<power> query=session.createSQLQuery(sql).addEntity(power.class);
		List<power> list=query.list();
		return list;
	}
	//查询出属于某个一级菜单的二级菜单
	@SuppressWarnings("unchecked")
	public List<power> findPowerMgrById(power entity){
		Session session=factory.openSession();
		String sql="select * from power where p_mgr="+entity.getP_id();
		Query<power> query=session.createSQLQuery(sql).addEntity(power.class);
		List<power> list=query.list();
		session.close();
		return list;
	}
}
