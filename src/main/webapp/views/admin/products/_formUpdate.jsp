<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form
	modelAttribute="item"
	method="POST"
	action="/su22b1_it16304_sof3021/admin/products/update/${ item.id }"
	class="col-6 offset-3"
>
	<div>
		<label>name</label>
		<form:input class="form-control" name="name" path="name" />
	</div>
	<div>
		<label>image</label>
		<!-- <form:input class="form-control" name="image" path="image" /> -->
		<input type="file" class="form-control" name="image"/>
	</div>
	<div>
		<label>price</label>
		<form:input class="form-control" name="price" path="price" />
	</div>
	<div>
		<label>Available</label>
		<form:input class="form-control" name="available" path="available" />
	</div>
	<div>
		<label>Category</label>
		<select class="form-select" aria-label="Default select example" name="category">
			<option disabled selected>Choose categories</option>
			<c:forEach items="${ calst }" var="order">
				<option value="${ order.id }" ${order.id == item.category.id? "selected":"" }>
					${ order.name }
				</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Mô tả</label>
		<form:textarea class="form-control" name="mota" path="mota" />
		<form:errors path="mota" class="text-danger" />	
	</div>
	<div>
		<label>Create Date</label>
		<form:input class="form-control" name="createdDate" path="createdDate" value="${ newDate }"/>
	</div>
	
	<button class="btn btn-primary mt-2">Update</button>
	<a href="/su22b1_it16304_sof3021/admin/products/index" class="btn btn-danger mt-2">Clear form</a>
</form:form>