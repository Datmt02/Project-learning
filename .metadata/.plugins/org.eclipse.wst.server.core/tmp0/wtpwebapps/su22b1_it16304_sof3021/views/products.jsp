<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ !empty sessionScope.lgSuccess}">
	<div class="alert alert-success">
		${ sessionScope.lgSuccess }
	</div>
	<c:remove var="lgSuccess" scope="session" />
</c:if>

<c:if test="${ empty cateLst || empty items}">
	<p class="alert alert-warning">Không có dữ liệu</p>
</c:if>
<c:if test="${ !empty cateLst || !empty items}">
	<div class="ms-4 ">
		<h3>Danh sách sản phẩm</h3>
			<form:form action="/su22b1_it16304_sof3021/findpro" method="POST" modelAttribute="item">
				<div class="input-group" style="width: 20%;">
					<select class="form-select" aria-label="Default select example" name="category">
						<option disabled selected>Chọn Danh mục</option>
						<option value="0"> Tất cả sản phẩm </option>
						<c:forEach items="${ cateLst }" var="category">
							<option value="${ category.id }">
								${ category.name }
							</option>
						</c:forEach>
					</select>
					
					<!-- <a href="/su22b1_it16304_sof3021/findpro" type="button" class="btn btn-warning">
						
					</a> -->
					<button class="btn btn-warning"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-funnel-fill" viewBox="0 0 16 16">
						  <path d="M1.5 1.5A.5.5 0 0 1 2 1h12a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.128.334L10 8.692V13.5a.5.5 0 0 1-.342.474l-3 1A.5.5 0 0 1 6 14.5V8.692L1.628 3.834A.5.5 0 0 1 1.5 3.5v-2z"></path>
						</svg>
		                Chọn</button>
				</div>
			</form:form>
			
			
		<c:forEach items="${ items }" var="product">
			
			<div class="card mt-3 me-2" style="float: left; width:24%;">
				<div class="p-2">
					<figure class="container m-0 p-0">
						<img src='${ product.image }' class="card-img-top image" alt="..." style="height:250px;">
					</figure>
				</div>
				<div class="card-body" style="background-color: #fbdcdc;">
					<h5 class="card-title">${ product.name }</h5>
					<p class="card-text">Giá thành: ${ product.price }</p>
					<p class="card-text">Số lượng: ${ product.available }</p>
					<a href="/su22b1_it16304_sof3021/action/addToCart/${product.id}" class="btn btn-outline-primary offset-5"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-cart-plus-fill" viewBox="0 0 16 16">
					  <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z"/>
					</svg></a>
					<a href="/su22b1_it16304_sof3021/action/buy/${product.id}" class="btn btn-success p-2">Mua Hàng</a>
				</div>
			</div>
		</c:forEach>
	</div>
	
</c:if>