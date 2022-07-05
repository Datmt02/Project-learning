<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form
	modelAttribute="item"
	method="POST"
	action="/su22b1_it16304_sof3021/admin/categories/store"
	class="col-6 offset-3"
>
	<div>
		<label>Name</label>
		<form:input class="form-control" name="name" path="name" />
		<form:errors path="name" class="text-danger"/>
	</div>
	
	<button class="mt-2 btn btn-primary">Create</button>
	<a href="/su22b1_it16304_sof3021/admin/categories/index" class="btn btn-danger mt-2">Clear form</a>
</form:form>