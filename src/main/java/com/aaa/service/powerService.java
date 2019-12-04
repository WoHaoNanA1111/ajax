package com.aaa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.BaseDao;
import com.aaa.dao.powerDao;
import com.aaa.entity.power;

@Service
public class powerService extends BaseService<power> {
	
	@Autowired
	powerDao dao;

	@Override
	public BaseDao<power> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}
	//��ѯ��һ���˵�
	public List<power> findPowerOne(){
		return dao.findPowerOne();
	}
	//��ѯ������ĳ��һ���˵��Ķ����˵�
	public String findPowerMgrById(power entity){
		List<power> list=dao.findPowerMgrById(entity);
		if(list.size()==0 || list==null) return null;
		StringBuffer buffer=new StringBuffer();
		buffer.append("<ul>");
		for(power p:list){
			buffer.append("<li>");
			buffer.append("<a href='"+p.getP_url()+"'>");
			buffer.append(p.getP_name());
			buffer.append("</a>");
			buffer.append("</li>");
		}
		buffer.append("</ul>");
		return buffer.toString();
	}

}
