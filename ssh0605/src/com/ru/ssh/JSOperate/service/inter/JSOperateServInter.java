package com.ru.ssh.JSOperate.service.inter;

import java.util.List;
import java.util.Map;

import com.ru.ssh.JSOperate.entity.Student;

public interface JSOperateServInter {
	
	public List<Map<String, String>> getStuList(String data);
	public boolean saveStuData(List<Map<String, String>> list);
	public List<Student> getStuDataByDatabase();
    public List<Object[]> getUser();

}
