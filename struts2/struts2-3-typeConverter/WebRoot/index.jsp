<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
      <s:form action="register" method="post">
        <s:textfield name="username" label="用户名"></s:textfield>
        <s:textfield name="age" label="年龄"></s:textfield>
      <!--  <s:textfield name="insertdate" label="插入日期"></s:textfield>-->
        <!--<s:textfield name="point" label="点坐标" ></s:textfield>-->
        <s:submit value="提交按钮"></s:submit>
      </s:form>
  </body>
</html>
