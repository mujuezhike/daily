<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<script type="text/javascript" src="stc/jquery.min.js"></script>
		<style type="text/css">
			.chartbean {margin-top:5px;height:30px;}
			.chartbean .ln {background-color: #BBBBBB;margin-right:20px;height:30px;display:inline-block;line-height:30px;float: left;}
			.chartbean .ii {background-color: #EEEEEE;margin-right:20px;height:30px;display:inline-block;line-height:30px;float: left;}
		</style>
	</head> 
	<body>
		<div class="date">2014-02-15</div>
		<div class="main">
			<!-- <div class="game chartbean"><div class="ln" style="width:5px"></div><div class="ii">GAME</div></div>
			<div class="it chartbean"><div class="ln" style="width:1px"></div><div class="ii">IT</div></div> -->
		</div>
		<script type="text/javascript" >
			
			Date.prototype.Format = function (fmt) { //author: meizz 
			    var o = {
			        "M+": this.getMonth() + 1, //月份 
			        "d+": this.getDate(), //日 
			        "h+": this.getHours(), //小时 
			        "m+": this.getMinutes(), //分 
			        "s+": this.getSeconds(), //秒 
			        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
			        "S": this.getMilliseconds() //毫秒 
			    };
			    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			    for (var k in o)
			    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			    return fmt;
			}
			
			var dd = new Date("2014",1,15);
			var f = false;
			
			var generate = function(){
				
				//if(f){return};
				
				f = true;
				
				   dd = dd.valueOf();
				   dd = dd + 20 * 24 * 60 * 60 * 1000;
				   dd = new Date(dd);
				
				$.ajax({ 
			           type: "post", 
			           url: "/dailyAnalysis/ca", 
			           dataType: "json", 
			           data:{date:dd.Format("yyyy-MM-dd")},
			           success: function (data) { 
			        	   $(".date").html(dd.Format("yyyy-MM-dd"));
							
							var list = data.content;
							//console.info(data);
							//console.info(data.content);
							if(!list){
								f = false;
								return;
							}
							
							for(var i=0;i<list.length;i++){
								
								var bean = list[i];
								
								var title = bean.title;
								
								title = title.substring(0,title.indexOf("."));
								
								var m = $("."+title);
								
								if(m && m.length!=0){
									
									$(m).find(".ln").css("width",bean.count+"px");
									
								}else{
									
									var nm = $("<div class='"+title+" chartbean'><div class='ln' style='width:"+bean.count+"px'></div><div class='ii'>"+title+"</div></div>");
									$(".main").append(nm);
								}
								
							}
							
							f = false;
							return;
							     
			           }, 
			           error: function (XMLHttpRequest, textStatus, errorThrown) { 
			           } 
			    });
				
			};
			
			$(".date").click(function(){
				setInterval(generate,1000);
			});
		</script>
	</body>
</html>
