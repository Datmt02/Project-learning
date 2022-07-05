<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TD Shop</title>
<link rel="stylesheet" href="/su22b1_it16304_sof3021/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="shortcut icon" href=" /su22b1_it16304_sof3021/images/fpt.png">
</head>
<body>
	<nav class="row navbar navbar-dark fixed-top navbar-expand-lg " style="background-color: #49c4ff;">
        <div class="container-fluid " style="height: 100%;">
            <button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse ms-5" id="navbarSupportedContent">
            	<div class="col-2 col-md-1 " style="  top: 10px;"> 
	                <a href="/su22b1_it16304_sof3021/home" class="navbar-brand mt-2"><img src="/su22b1_it16304_sof3021/images/logo2.png" style="width: 330%;" alt="logo" title="logo">
	                    <!-- <Strong class="text-uppercase " style="font-family: -webkit-pictograph;">TD Motor</Strong> -->
	                </a>
	            </div>
                <ul class="navbar-nav ms-auto me-auto mb-2 mb-lg-0 fw-bold">
                    <li class="nav-item me-2" >
                        <a style="color: white;border-color: #ffffff00;font-weight: bold;font-family: cursive;font-size: larger;" class="p-3 btn btn-outline-secondary" aria-current="page" href="/su22b1_it16304_sof3021/home">Trang Chủ</a>
                    </li>
                    <li class="nav-item me-2">
                        <a style="color: white;border-color: #ffffff00;font-weight: bold;font-family: cursive;font-size: larger;" class="p-3 btn btn-outline-secondary" href="/su22b1_it16304_sof3021/products">Sản phẩm</a>
                    </li>
                    <li class="nav-item me-2">
                        <a style="color: white;border-color: #ffffff00;font-weight: bold;font-family: cursive;font-size: larger;" class="p-3 btn btn-outline-secondary" href="#">Liên hệ</a>
                    </li>
                    <li class="nav-item me-2">
                        <a style="color: white;border-color: #ffffff00;font-weight: bold;font-family: cursive;font-size: larger;" class="p-3 btn btn-outline-secondary" href="#">Góp ý</a>
                    </li>
                    <li class="nav-item">
                        <a style="color: white;border-color: #ffffff00;font-weight: bold;font-family: cursive;font-size: larger;" class="p-3 btn btn-outline-secondary" href="#">Hỏi đáp</a>
                    </li>
                </ul>
            </div>
            
            <div class="me-4">
            	<a href="#" type="button" class="btn btn-outline-light p-0" style="border-color:#0d6efd00; border-radius: 7px;">
            		<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
					</svg>
            	</a>
            </div>
            
            <div class="me-4 " style="width: 40px;">
                <a href="#" type="button" class="btn btn-outline-light p-0" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight" style="border-color:#0d6efd00; border-radius: 50%;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                    </svg>
                </a>
            </div>
            
            <div class="me-4">
            	<a href="#" type="button" class="btn btn-outline-light p-0 position-relative" data-bs-toggle="modal" data-bs-target="#cartModel" style="border-color:#0d6efd00; border-radius: 7px;">
            		<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-cart-check-fill" viewBox="0 0 16 16">
					  	<path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm-1.646-7.646-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708.708z"/>
					</svg>
					<c:if test="${!empty sessionScope.user }">
						<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
							${ carts }
				  		</span>
					</c:if>
            	</a>
            </div>
        </div>
    </nav>
    <!-- Giỏ Hàng -->
    <div class="modal fade" id="cartModel">
    	<div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      	<div class="modal-header">
		        	<h3 class="modal-title ms-auto" id="cartModelLabel">Giỏ Hàng</h3>
		        	<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      	</div>
		      	<div class="modal-body">
		        	<c:if test="${empty cartValue }">
		        		<div class="alert alert-warning m-0">
							<h4>Giỏ Hàng trống</h4>
						</div>
		        	</c:if>
		        	<c:if test="${!empty cartValue }">
		        		<table class="table"> 
		        			<thead>
		        				<tr>
		        					<th>Name</th>
		        					<th>Image</th>
		        					<th>Quantity</th>
		        					<th>Price</th>
		        					<th>Action</th>
		        				</tr>
		        			</thead>
		        			<tbody>
		        				<c:forEach items="${ cartValue }" var="cart">
		        					<tr>
		        						<td>${ cart.product.name }</td>
		        						<td class="col-2">
											<img alt="" src="${ cart.product.image }" style="width:100%;">
										</td>
										<td> ${cart.available } </td>
										<td>${cart.product.price }</td>
										<td> 
											<input class="form-check-input" type="checkbox" name="" value="${ cart.id }"/>
										</td>
		        					</tr>
		        				</c:forEach>
		        			</tbody>
		        		</table>
		        	</c:if>
		        	
		      	</div>
		      	<div class="modal-footer">
		      		<div class="col-9 text-danger">
		      			<h4>Thành tiền:  VND</h4>
		      		</div>
		        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        	<button type="button" class="btn btn-primary">Mua hàng</button>
		    	</div>
		    </div>
		</div>
    </div>
    
    
    <!-- Danh mục  -->
    <div class="offcanvas offcanvas-end hide" style="width: 300px; visibility: visible;" data-bs-scroll="true" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasWithBothOptionsLabel" aria-modal="true" role="dialog">
        <div class="offcanvas-header">
            <h4>USER</h4>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <!-- content here! -->
            <div class="text-center">
                <div class="col-10 ms-3">
                    <img src="${ sessionScope.user.photo }" width="95%" alt="">
                </div>
                <h3>${sessionScope.user.fullname}</h3>
            </div>
            <ul class="list-group" style="list-style: none;">
                <c:if test="${empty sessionScope.user }">
                	<li data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                	<a class="list-group-item list-group-item-action" 
                       href="/su22b1_it16304_sof3021/login">Đăng nhập</a></li>
                </c:if>
                <li><a class="list-group-item list-group-item-action" href="/su22b1_it16304_sof3021/showFormRegister">Đăng ký</a></li>
                
                <c:if test="${!empty sessionScope.user }">
                	<li data-bs-toggle="offcanvas" 
                		data-bs-target="#offcanvasRight" 
                		aria-controls="offcanvasRight">
                	<a class="list-group-item list-group-item-action" href=""
                        ng-hide="value == -1"
                        data-bs-target="#form_logout"
                       	data-bs-toggle="modal"
                     >Đăng xuất</a></li>
                </c:if>
                <li><a class="list-group-item list-group-item-action" 
                	href="/su22b1_it16304_sof3021/admin/showUpPass"
                	>Đổi mật khẩu</a></li>
                <li>
                    	<a class="list-group-item list-group-item-action"
                    	data-bs-target="#form_Qtri"
                       	data-bs-toggle="modal"
                    	href="" >Trang quản trị</a>
                </li>
            </ul>
        </div>    
    </div>
    
    <!-- đăng xuất -->
    <div class="modal fade" id="form_logout" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h3>Confirm</h3>
                </div>
                <div class="modal-body">
                	<h4>XÁC NHẬN ĐĂNG XUẤT</h4>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary col-2" data-bs-dismiss="modal">Hủy</button>
                  <a type="button" class="btn btn-primary col-2" href="/su22b1_it16304_sof3021/logout">OK</a>
                </div>
            </div>    
        </div>
    </div>
    <!-- Chọn phần quản trị -->
    <div class="modal fade" id="form_Qtri" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body text-center">
                    <h3>Chọn trang quản trị</h3>
                </div>
                <div class="d-flex justify-conten-center m-3">
                  <a type="button" class="btn btn-primary col-3 me-2 offset-1"  href="/su22b1_it16304_sof3021/admin/accounts/index">Account</a>
                  <a type="button" class="btn btn-primary col-3 me-2"  href="/su22b1_it16304_sof3021/admin/products/index">Product</a>
                  <a type="button" class="btn btn-primary col-4 me-2"  href="/su22b1_it16304_sof3021/admin/categories/index">Category</a>
                	
                </div>
                <div class="m-3">
                	<a type="button" class="btn btn-primary col-3 me-2 offset-2"  href="/su22b1_it16304_sof3021/admin/orders/index">order</a>
                	<a type="button" class="btn btn-primary col-4 me-2"  href="/su22b1_it16304_sof3021/admin/orderDetails/index">orderDetail</a>
                </div>
            </div>    
        </div>
    </div>
    
    <!-- Nội dung -->
	<div class="">
		
		<div style="margin-top:79px;">
			
			<c:if test="${ !empty sessionScope.lgSuccess}">
				<div class="alert alert-success m-0">
					<h4>${ sessionScope.lgSuccess }</h4>
				</div>
				<c:remove var="lgSuccess" scope="session" />
			</c:if>
			<c:if test="${ !empty sessionScope.lgError }">
				<div class="alert alert-danger m-0">
					<h4>${ sessionScope.lgError }</h4>
				</div>
				<c:remove var="lgError" scope="session" />
			</c:if>
			<jsp:include page="${ views }"></jsp:include>
		</div>
		
	</div>

	<script src="/su22b1_it16304_sof3021/js/jquery.min.js"></script>
	<script src="/su22b1_it16304_sof3021/js/popper.min.js"></script>
	<script src="/su22b1_it16304_sof3021/js/bootstrap.min.js"></script>
</body>
</html>