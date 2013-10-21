package com.ru.ssh.JSOperate.service.imp;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;

public class JSOperateServImp {
	
	private JSOperateDaoInter JSOperateDao;

	public JSOperateDaoInter getJSOperateDao() {
		return JSOperateDao;
	}

	public void setJSOperateDao(JSOperateDaoInter jSOperateDao) {
		JSOperateDao = jSOperateDao;
	}
}
