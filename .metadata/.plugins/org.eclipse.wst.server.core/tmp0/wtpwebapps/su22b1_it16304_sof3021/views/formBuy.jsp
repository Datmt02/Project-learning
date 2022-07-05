<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"%>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:if test="${ !empty sessionScope.lgError }">
	<div class="alert alert-danger">
		${ sessionScope.lgError }	
	</div>
	<c:remove var="lgError" scope="session" />
</c:if>

<div class="m-3 p-4">
	<div class="row p-3 border">
		<div class="col-6">
			<div class="col-8 offset-2">
				<img alt="" src="${ product.image }" style="width:100%;">
			</div>
		</div>
		
		<div class="col-4 ps-3 pt-4 border-start">
			<h4>Tên sản phẩm: ${ product.name } </h4> 
			<h4>Giá thành: ${ product.price } VND</h4> 
			<h4>Mô tả: ${ product.mota }</h4> 
		</div>
	</div>
	
	<div class="row p-4 mt-2 border">
		<form:form 
			modelAttribute="item"
			method="POST"
			action="/su22b1_it16304_sof3021/confirm"
			class="row"
		>
			<div class="col-4 ">
				<label>Họ Và Tên</label>
				<form:input class="form-control" path="fullname" type="text" name="fullname" value="${ sessionScope.user.fullname }" />
				<form:errors path="fullname" class="text-danger" />	
				<label>Địa chỉ</label>
				<form:textarea class="form-control" path="address" name="address" rows="3"></form:textarea>
				<form:errors path="address" class="text-danger" />
				
					

			</div>
			<div class="col-4">
				<label>Date</label>
				<form:input class="form-control disabled" name="createdDate" path="createdDate" value="${ nowDate }"/>
				<form:errors path="createdDate" class="text-danger" />
				<label>Số Lượng</label>
				<form:input type="number" path="available" class="form-control" name="available" value="1" />
				<form:errors path="available" class="text-danger" />	
				<p>Thành tiền: <h4 class="text-danger">${ product.price } VND</h4> </p>
				
			</div>
			<button class="btn btn-primary mt-2 col-2 offset-1">Xác Nhận đặt Hàng</button>
		</form:form>
	</div>
	
</div>