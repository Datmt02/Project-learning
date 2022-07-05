<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="offset-3">
	<h3 >CATEGORY MANAGEMENT</h3>
</div>
<div class="row">
	<div class="">
		<jsp:include page="${ form }"></jsp:include>
	</div>
	
	<div class="">
		<jsp:include page="_table.jsp"></jsp:include>
	</div>
	
</div>
