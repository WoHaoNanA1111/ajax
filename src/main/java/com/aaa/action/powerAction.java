package com.aaa.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.entity.power;
import com.aaa.service.powerService;

@Controller
public class powerAction {
	@Autowired
	powerService svc;
	public power p=new power();
	public List<power> list=new ArrayList<power>();
	
	public String findPowerOne(){
		list=svc.findPowerOne();
		return "list";
	}
	public void findPowerMgrById(){
		try {
			ServletActionContext.getResponse().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().write(svc.findPowerMgrById(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public powerService getSvc() {
		return svc;
	}
	public void setSvc(powerService svc) {
		this.svc = svc;
	}
	public power getP() {
		return p;
	}
	public void setP(power p) {
		this.p = p;
	}
	public List<power> getList() {
		return list;
	}
	public void setList(List<power> list) {
		this.list = list;
	}

}
