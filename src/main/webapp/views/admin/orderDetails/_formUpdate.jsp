<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form:form
	modelAttribute="item"
	method="POST"
	action="/su22b1_it16304_sof3021/admin/orderDetails/update/${ item.id }"
	class="col-6 offset-3"
>
	<div>
		<label>Orders</label>
		<select class="form-select" aria-label="Default select example" name="order">
			<option disabled selected>Choose order</option>
			<c:forEach items="${ orderList }" var="order">
				<option value="${ order.id }" ${ order.id == item.order.id ? "selected" : ""}>
					${ order.user.username }
				</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Product</label>
		<select class="form-select" aria-label="Default select example" name="product">
			<option disabled selected>Choose product</option>
			<c:forEach items="${ productList }" var="product">
				<option value="${ product.id }" ${ item.product.id == product.id? "selected" : ""}>
					${ product.name }
				</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Price</label>
		<form:input class="form-control" name="price" path="price" />
	</div>
	<div>
		<label>Quantity</label>
		<form:input class="form-control" name="quantity" path="quantity" />
	</div>
	
	<button class="btn btn-primary mt-2">Update</button>
	<a href="/su22b1_it16304_sof3021/admin/orderDetails/index" class="btn btn-danger mt-2">Clear form</a>
</form:form>