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
		<c:if test="${ !empty sessionScope.lgError }">
			<div class="alert alert-danger m-0">
				<h4>${ sessionScope.lgError }</h4>
			</div>
			<c:remove var="lgError" scope="session" />
		</c:if>
		<div class="col-5 pt-3 pb-3">
			<img alt="" src="/su22b1_it16304_sof3021/images/6729328_preview.png" style="width:100%;">
		</div>
		<div class="col-6 p-4">
			<form:form
				action="/su22b1_it16304_sof3021/confirmResetPass"
				method="POST"
				modelAttribute="itemCode"
				class="mt-5 pt-5"
			>
				<h3>Quên mật khẩu</h3>
				<div>
					<label>nhập mật khẩu mới</label>
					<form:password class="form-control" path="newPass" name="newPass"  />
					<form:errors path="newPass" class="text-danger"/>
				</div>
				<div>
					<label>nhập lại mật khẩu </label>
					<form:password class="form-control" path="reNewPass" name="reNewPass" />
					<form:errors path="reNewPass" class="text-danger"/>
				</div>
				<button type="submit" class="btn btn-primary mt-2" data-bs-toggle="modal" data-bs-target="#modalRegister">Lấy lại mật khẩu</button>
				<a href="/su22b1_it16304_sof3021/admin/accounts/index" class="btn btn-danger mt-2">Clear form</a>
				
			</form:form>
		</div>
	</div>
</div>