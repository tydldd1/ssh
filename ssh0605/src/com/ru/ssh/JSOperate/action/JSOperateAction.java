package com.ru.ssh.JSOperate.action;

import com.ru.ssh.JSOperate.dao.inter.JSOperateDaoInter;
import com.ru.ssh.JSOperate.service.inter.JSOperateServInter;

public class JSOperateAction {

	private JSOperateServInter JSOperateService;

	public JSOperateServInter getJSOperateService() {
		return JSOperateService;
	}

	public void setJSOperateService(JSOperateServInter jSOperateService) {
		JSOperateService = jSOperateService;
	}
}
