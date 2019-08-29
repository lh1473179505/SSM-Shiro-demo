<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
welcome : <shiro:principal></shiro:principal>
<br>
<a href="${pageContext.request.contextPath }/admin.jsp">admin</a>
<br>
<a href="${pageContext.request.contextPath }/user.jsp">user</a>
<br>
<a href="${pageContext.request.contextPath }/admin/testShiro">testShiro</a>
<br>
<a href="${pageContext.request.contextPath }/logout">退出</a>

<br>
<a href="${pageContext.request.contextPath }/emp/findAll">来吧</a>
<div class="container">
	<div class="row">
		
	</div>
	<div class="row">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>eid</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>部门</th>
					<shiro:hasRole name="admin">
					<th>操作</th>
					</shiro:hasRole>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageInfo.list}" var="emp" >
					<tr>
						<td>${emp.eid }</td>
						<td>${emp.name }</td>
						<td>${emp.age }</td>
						<td>${emp.dept.dname }</td>
						<td>
						<shiro:hasRole name="admin">
							<a href="${pageContext.request.contextPath }/emp/delete">删除</a>
						</shiro:hasRole>
							
						</td>
					</tr>
				</c:forEach>
					
				</tbody>
		</table>
	</div>
	<div class="row">
		当前是【${pageInfo.pageNum }】页，共有【${pageInfo.pages }】页，共有【${pageInfo.total }】条记录
	</div>
	<div class="row">
		<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="${pageContext.request.contextPath }/emp/findAll?pn=${pageInfo.prePage }" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <c:forEach items="${pageInfo.navigatepageNums }" var="page_num">
    	<c:if test="${page_num== pageInfo.pageNum}">
				    	<li class="active"><a href="#">${page_num }</a></li>
				    </c:if>
				    <c:if test="${page_num != pageInfo.pageNum}">
				    	<li><a href="${pageContext.request.contextPath }/emp/findAll?pn=${page_num }">${page_num }</a></li>
				    </c:if>
    </c:forEach>
    
    <li>
      <a href="${pageContext.request.contextPath }/emp/findAll?pn=${pageInfo.nextPage }" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
	</div>
</div>

</body>
</html>