<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form
	modelAttribute="item"
	method="POST"
	action="/su22b1_it16304_sof3021/admin/orders/store"
	class="col-6 offset-3"
>
	<div>
		<label>Account</label>
		<select class="form-select" aria-label="Default select example" name="user">
			<option disabled selected>Choose order</option>
			<c:forEach items="${ accList }" var="order">
				<option value="${ order.id }">
					${ order.username }
				</option>
			</c:forEach>
		</select>
		<form:errors path="user" class="text-danger" />	
	</div>
	
	<div>
		<label>Date</label>
		<form:input class="form-control" name="createdDate" path="createdDate" value="${ nowDate }"/>
		<form:errors path="createdDate" class="text-danger" />	
	</div>
	<div>
		<label>Address</label>
		<form:input class="form-control" name="address" path="address" />
		<form:errors path="address" class="text-danger" />	
	</div>
	
	<button class="mt-2 btn btn-primary">Create</button>
	<a href="/su22b1_it16304_sof3021/admin/orders/index" class="btn btn-danger mt-2">Clear form</a>
</form:form>