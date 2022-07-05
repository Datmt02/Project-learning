<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form
	modelAttribute="item"
	method="POST"
	action="/su22b1_it16304_sof3021/admin/accounts/update/${ item.id }"
	class="col-6 offset-3"
>
	<div>
		<label>Fullname</label>
		<form:input class="form-control" name="fullname" path="fullname" />
	</div>
	<div>
		<label>Email</label>
		<form:input class="form-control" name="email" type="email" path="email" />
	</div>
	<div>
		<label>Username</label>
		<form:input class="form-control" name="username" path="username" />
	</div>
	<div>
		<label>Password</label>
		<form:password class="form-control" name="password" path="password" value="${ pass }"/>
	</div>
	<div>
		<label>Photo</label>
		<input type="file" class="form-control" name="photo"/>
	</div>
	<div>
		<label>Role</label>
		<form:select class="form-select" name="admin" path="admin">
			<form:option value="0">User</form:option>
			<form:option value="1">Admin</form:option>
		</form:select>
	</div>
	<button class="btn btn-primary mt-2">Update</button>
	<a href="/su22b1_it16304_sof3021/admin/accounts/index" class="btn btn-danger mt-2">Clear form</a>
</form:form>