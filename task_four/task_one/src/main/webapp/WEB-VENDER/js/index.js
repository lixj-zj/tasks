/**
 * 
 */

$("#regist").click(function(){
	if(document.getElementById("username").value=="" || document.getElementById("password").value=="") { 
		alert("用户名或密码不能为空！");
		return false;
	} else {
		var user = {
						"username": $("#username").val(),
						"password": $("#password").val()
					}
	    $.ajax({
	        type: "post",
	        url: "/task_one/user/checkRegist",
	        dataType:'json',
	        contentType: "application/json;charset=utf-8",
	        data: JSON.stringify(user),
	        
	        success:function(result){
	        	alert(result.message);
	        	location.reload();
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            console.log(XMLHttpRequest.status);
	            console.log(XMLHttpRequest.readyState);
	            console.log(textStatus);
	        }
	    });
		//另一种写法
		/*$.post('/task_one/user/checkRegist',user,function(data){
	    	if(data==='success'){
	    		window.location.href='/task_one/user/login';
	    	}
	    })*/
	}
});

$("#login").click(function(){
	if(document.getElementById("username").value=="" || document.getElementById("password").value=="") { 
		alert("用户名或密码不能为空！");
		return false;
	} else {
		var user = {
						"username": $("#username").val(),
						"password": $("#password").val()
					}
	    $.ajax({
	        type: "post",
	        url: "/task_one/user/checkLogin",
	        dataType:'json',
	        contentType: "application/json;charset=utf-8",
	        data: JSON.stringify(user),
	        
	        success:function(result){
	        	console.log(result.message);
	        	if (result.message == "true"){
	        		alert("登录成功！");
	        		window.location.href='/task_one/user/system_index';
	        	} else {
	        		alert("登录失败！请检查用户名或密码！");
	        	}
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            console.log(XMLHttpRequest.status);
	            console.log(XMLHttpRequest.readyState);
	            console.log(textStatus);
	        }
	    });
	}
});

$("#selectAllUser").click(function(){
    $.ajax({
        type: "post",
        url: "/task_one/user/selectAllUser",
        contentType: "application/json;charset=utf-8",
        
        success:function(result){
        	console.log(result);
        	userJson = JSON.parse(result);		// 将后台返回的json字符串解析成json对象
        	var tmp = "<ul>";
        	
        	// 拼接的方式显示
            for (var i = 0; i < userJson.length; i++) {
                tmp +=  "<br>" +
                		"<li>ID：" + userJson[i]["id"] + "</li>" +
	                    "<li>姓名：" + userJson[i]["user_name"] + "</li>" +
	                    "<li>密码：" + userJson[i]["user_password"] + "</li>"
            }
            tmp += "</ul>";
            document.getElementById("userList").innerHTML = tmp;
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        }
    });
		
});
