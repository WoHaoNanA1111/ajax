<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<body>
<center>
<ul>
<c:forEach items="${list }" var="power">
<li id="${power.p_id }">
<a href="javascript:void(0)" onclick="findPower(${power.p_id})">${power.p_name }</a>
</li>
</c:forEach>
</ul>
</center>
</body>
<script type="text/javascript">
function findPower(id){
	$.ajax(
			{
		url:'/ajax/findPowerMgrById',
		data:{"p.p_id":id},
		type:'post',
		dataType:'html',
		success:function(data){
			$("#"+id).find("ul").remove();
			$("#"+id).append(data);
		}
	});
}
</script>
</html>