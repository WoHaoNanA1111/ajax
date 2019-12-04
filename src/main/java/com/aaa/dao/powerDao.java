package com.aaa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.aaa.entity.power;

@Component
public class powerDao extends BaseDao<power> {
	
	@SuppressWarnings("unchecked")
	//��ѯ������һ���˵�
	public List<power> findPowerOne(){
		Session session=factory.openSession();
		String sql="select * from power where p_mgr=0";
		Query<power> query=session.createSQLQuery(sql).addEntity(power.class);
		List<power> list=query.list();
		return list;
	}
	//��ѯ������ĳ��һ���˵��Ķ����˵�
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
