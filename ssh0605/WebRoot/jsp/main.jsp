<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SSH主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="js/jQuery1.9.1-min.js"></script>
	<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
    <script language="javascript" type="text/javascript" src="js/main.js"></script>
	<style type="text/css">
		.login{text-align: center;font-size: 20px;color: red}
		.hibernate{color:mediumvioletred}
		.hibernate span{width:15px;height:15px;background-color:mediumvioletred;float: left;margin-right: 5px}
	</style>
  </head>
  
  <body>
    	<div class="login">登录成功！欢迎 <s:property value="#session.user.name" /> </div>
    	<div class="hibernate"><span></span><a href="jsp/hibernate/hibernateMain.jsp">hibernate实例</a></div><br>
        <div>
            注：1/当查询的列表记录为空时，依然返回list对象，其大小为0,不会返回null
                2/使用uniqueResult() 取得一个Object时，返回值有可能是null
        </div>


    	<div class="hibernate"><span></span><a href="jsp/javaExam/javaMain.jsp">java实例</a></div><br>
    	<div class="hibernate"><span></span><a href="jsp/inputalert/alert.jsp">input弹出层</a></div><br>
    	<div class="hibernate"><span></span><a href="jsp/showLoading/jquery.showLoading.example.html">jsp遮罩</a></div><br>
    	<div class="hibernate"><span></span>
    		<!-- 添加这个样式后 style="opacity: 0;"不会显示浏览，这样就没有空白了 -->
    		<input type="file" id="license" name="license">
    	</div><br>
    	<div class="hibernate"><span></span>
    		<a href="jsp/usestaticmethod/usestaticmethod.jsp">struts标签使用静态方法</a></div>
    	</div><br>
    	
    	<div class="hibernate"><span></span><a href="http://www.my97.net" target="_blank">97时间插件</a>
    		<p>
    			使用：
    			1、My97DatePicker目录是一个整体,不可破坏里面的目录结构,也不可对里面的文件改名,可以改目录名
    			2、WdatePicker.js 配置文件,在调用的地方仅需使用该文件,可多个共存,以xx_WdatePicker.js方式命名
    			
    			实现：
    			1、开始日期不大于结束时间
    			2、设定结束时间的最大值maxDate和,minDate
    			3、isShowClear:false或true控制是否显示清除按钮。
    		</p>
    		<p>
    			开始时间： <input type="text" id="starttime" readonly="readonly" name="beginTime"
	           		value="2013-10-11 00:00:00" class="Wdate"
	           		onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endtime\')||\'2020-10-01\'}',isShowClear:false,dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})"/>
    			结束时间：<input id="endtime" type="text" readonly="readonly" name="startTime"
	           		value="" class="Wdate"
	           		onclick="WdatePicker({minDate:'#F{$dp.$D(\'starttime\')}',maxDate:'2020-10-01',isShowClear:false,dateFmt:'yyyy-MM-dd HH:mm:ss',lang:'zh-cn'})" />
    		</p>
    	</div><br>
    	
    	<div class="hibernate"><span></span>
    		<a href="jsp/jqueryduidialog/defaultdialog.jsp">1、默认jquery-ui-dialog弹出层</a></div>
    		&nbsp;&nbsp;<a href="jsp/jqueryduidialog/dialog-form.jsp">2、设置属性和事件的弹出层</a></div>
    	</div><br><br>
    	
    	<div class="hibernate"><span></span>
    		<a href="getStuMessage_JSOperate.action">*****使用js实现增删改操作*****</a>
    	</div><br>

        <div class="hibernate"><span></span>
            <a href="getDagaLogList_page.action">*****分页操作*****</a>
        </div><br>
    	
    	<div class="hibernate"><span></span>
            <a href="jsp/jspplugins/jsp.jsp">jsp插件测试</a></div>
        </div><br>

        <div class="hibernate"><span></span>
            <a href="/jsp/filepath/filepath.jsp">jsp路径</a></div>
        </div><br>

        <div class="hibernate"><span></span>
            <a href="testDB_JSOperate.action">查询数据库返回值</a>
        </div><br>

        <div class="hibernate"><span></span>
            <a href="javascript:void(0);" onclick="backValue()">当input值为空时，传到action的值.</a>
            <div>注：当input 为"input id='test'" 传递到action的值为"".</div>
                input：<input id="test">
        </div><br>

        <div class="hibernate"><span></span>
            <a href="javascript:void(0);" onclick="selectTest('name')">取s:select和select的值</a><br>
            取s:select和select的值：给select一个id，直接通过val()方法取值。
            例如：“var select = $("#select1").find('option:selected').val();
            var sel2 = $("#sel2").find('option:selected').val();”
            <p>
             s:select:
                <s:select id="select1" name="alarmInfoBean.level" list="#{'ERROR':'错误','FATAL':'失败','INFO':'信息','WARN':'警告'}"
                          headerKey="all" headerValue="所有级别" cssClass="sel"></s:select>
            </p>
            <p>
            select:
                <select id="sel2">
                    <option selected="selected">
                        1234
                    </option>
                    <option>
                        5678
                    </option>
                </select>
            </p>
        </div>

        <div class="hibernate"><span></span>
            <a href="/jsp/drag/drag1.jsp">页面拖拽</a>
        </div><br>


  </body>
</html>
