/**
 * js实现增删改
 */

$(function(){
	var listIndex = 0;//列表索引值
	var addOrUpdate = "";//添加或修改标识
	
	$("#checkAll")[0].checked = false;
	//设置弹出层属性
 	$("#dialog").dialog({
		autoOpen: false,//隐藏弹出div
		height: 300,
		width: 350,
		modal: true,//遮罩其他页面内容
		buttons:{
			"确定":function(){
				var name = $("#name").val();
				var age = $("#age").val();
				var major = $("#major").val();
				
				if(addOrUpdate == "add"){//添加操作
					listIndex++;
					var htmlStr = "<tr><td><input type='checkbox' id='user' value='" + listIndex + "'/></td><td>" +
						name + "</td><td>" + age + "</td><td>" + major + "</td></tr>";
					
					$("#content").append(htmlStr);
					
					$("#dialog").dialog("close");
				}else if(addOrUpdate == "update"){//修改操作
			 		
			 		var tdElementArray = $("input[id='user']:checked").parent().nextAll();
			 		$(tdElementArray[0]).text(name);
			 		$(tdElementArray[1]).text(age);
			 		$(tdElementArray[2]).text(major);
			 		$("#dialog").dialog("close");
				}
			},
			"取消":function(){
				$( this ).dialog( "close" );
			}
		}
		
	});
 	
 	
 	//添加
 	$("#add").click(function(){
 		addOrUpdate = "add";
 		$("#dialog").dialog("open");
 		$("#dialog").dialog({title:"添加"});
 	});
 	
 	//修改
 	$("#update").click(function(){
 		//判断是否没有选择用户，或者是否选择多个用户
 		/*var userCount = 0;
 		var users = $("input[id='user']");
 		var length = users.length;
 		
 		for(var i = 0; i < length; i++){
 			if(users[i].checked){
 				userCount++;
 			}
 		}*/
 		userCount = $("input[id='user']:checked").length;
 		
 		if(userCount == 0){
			alert("必须选择一个用户");
			return;
		}else if(userCount > 1){
			alert("不能同时修改多的用户");
			return;
		}
 		addOrUpdate = "update";
 		$("#dialog").dialog("open");
 		$("#dialog").dialog({title:"修改"});
 	});
 	
 	$("#del").click(function(){
 		$("input[id='user']:checked").each(function(){
 			$(this).parent().parent().remove();
 		});
 	});
 	
});

//点击标题栏复选框全选所有复选框
function checkAll(){
	if($("input[id='checkAll']:checked").length == 1){
		$("input[id='user']").each(function(){
			this.checked=true;
		});
	}else{
		$("input[id='user']").each(function(){
			this.checked=false;
		});
	}
}