<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="pt-5" style=" background-image: url('/su22b1_it16304_sof3021/images/xe3.jpg'); height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 750px;">
	
	<div class="border border-2-primary rounded row col-8 offset-2" style="background-color: white;">
		<div class="col-5 pt-3 pb-3">
			<img alt="" src="/su22b1_it16304_sof3021/images/5087579.png" style="width:100%;">
		</div>
		<div class="col-6 p-4">
			<form:form method="POST"
			modelAttribute="item"
			action="/su22b1_it16304_sof3021/dologin"
			class="col-8 mt-5 offset-3">
				<h3>Đăng nhập</h3>
				<c:if test="${ !empty sessionScope.lgError }">
					<div class="alert alert-danger">
						${ sessionScope.lgError }	
					</div>
					<c:remove var="lgError" scope="session" />
				</c:if>
				<c:if test="${ !empty sessionScope.lgSuccess }">
					<div class="alert alert-success">
						${ sessionScope.lgSuccess }	
					</div>
					<c:remove var="lgSuccess" scope="session" />
				</c:if>
				<div>
					<label>Email</label>
					<input type="email" name="email" class="form-control" />
					<form:errors path="email" class="text-danger"/>
				</div>
				<div>
					<label>Password</label>
					<input type="password" name="password" class="form-control" />
					<form:errors path="password" class="text-danger"/>
				</div>
				<button class="btn btn-primary mt-3">Đăng nhập</button>
				<a href="/su22b1_it16304_sof3021/showResetPass" class="btn btn-warning mt-3">Quyên mật khẩu</a> <br>
				<a href="/su22b1_it16304_sof3021/showFormRegister" >Bạn chưa có tài khoản ? Bấm để đăng ký</a>
			</form:form>
		</div>
	</div>
	
</div>



	
