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
				action="/su22b1_it16304_sof3021/resetPass"
				method="POST"
				modelAttribute="itemCode"
				class="mt-5 pt-5"
			>
				<h3>Quên mật khẩu</h3>
				<div>
					<label>Email của bạn</label>
					<form:input class="form-control" path="email" name="email" type="email" />
					<form:errors path="email" class="text-danger"/>
				</div>
				
				<button type="submit" class="btn btn-primary mt-2" data-bs-toggle="modal" data-bs-target="#modalRegister">Lấy lại mật khẩu</button>
				<a href="/su22b1_it16304_sof3021/admin/accounts/index" class="btn btn-danger mt-2">Clear form</a>
				
			</form:form>
			<!-- Modal -->
			<div class="modal fade" id="modalRegister" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Nhập mã xác nhận</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <form:form action="/su22b1_it16304_sof3021/confirmReset"
			      		method="post"
			      		modelAttribute="itemCode" >
				      <div class="modal-body">
		      			<p>Chúng tôi đã gửi mã xác nhận qua Email</p>
		        		<input class="form-control" name="code"/>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        <button type="submit" class="btn btn-primary">Xác nhận</button>
				      </div>
			      </form:form>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</div>