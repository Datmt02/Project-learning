<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="pt-5" style=" background-image: url('/su22b1_it16304_sof3021/images/xe2.jpg'); height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 750px;">
  	
	<div class="border border-3 border-primary rounded row col-8 offset-2" style="background-color: #c0c0c0d1;color: #004492;">
		<c:if test="${ !empty sessionScope.lgError }">
			<div class="alert alert-danger m-0">
				<h4>${ sessionScope.lgError }</h4>
			</div>
			<c:remove var="lgError" scope="session" />
		</c:if>
		<div class="col-5 pt-3 pb-3">
			<img alt="" src="/su22b1_it16304_sof3021/images/c4N4n8k-_400x400.png" style="width:100%;">
		</div>
		<div class="col-6 p-4">
	      <form:form action="/su22b1_it16304_sof3021/admin/updatePass"
    		method="post"
    		modelAttribute="updatePass"
    		class="pt-5 col-10" >
		      <div class="modal-body">
		      	<h3>Đổi mật khẩu</h3>
      			<div class="">
      				<label>Nhập mật khẩu cũ</label>
      				<form:password class="form-control" path="oldPass" name="oldPass"/>
      				<form:errors path="oldPass" class="text-danger"/>
      			</div>
      			<div class="">
      				<label>Nhập mật khẩu mới</label>
      				<form:password class="form-control" path="newPass" name="newPass"/>
      				<form:errors path="newPass" class="text-danger"/>
      			</div>
      			<div class="">
      				<label>Nhập mật khẩu cũ</label>
      				<form:password class="form-control" path="reNewPass" name="reNewPass"/>
					<form:errors path="reNewPass" class="text-danger"/>      			
      			</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary mt-3 me-3" data-bs-dismiss="modal">Close</button>
		        <button type="submit" class="btn btn-primary mt-3" >Đổi mật khẩu</button>
		      </div>
	      </form:form>
		</div>
	</div>
</div>