<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table class="table ">
	<thead>
    	<tr>
      		<th >Id</th>
		    <th >Fullname</th>
		    <th >UserName</th>
		    <th >Email</th>
		    <th > Photo</th>
		    <th >Activated</th>
		    <th >Role</th>
		    <th colspan="2">Action</th>
    	</tr>
  	</thead>
  	<tbody>
   		<c:forEach items="${ data.content }" var="acc">
   		<tr class="col-10">
   			<td>${ acc.id }</td>
   			<td>${ acc.fullname }</td>
   			<td>${ acc.username }</td>
   			<td>${ acc.email }</td>
   			<td class="col-2">
				<img alt="" src="${ acc.photo }" style="width:50%;">
			</td>
   			<td>${ acc.activated == 0 ? "Not Active" : "Active" }</td>
   			<td>${ acc.admin == 0 ? "User" : "Admin"}</td>
   			<td>
				<a href="/su22b1_it16304_sof3021/admin/accounts/edit/${ acc.id }" class="btn btn-primary">Update</a>
			</td>
			<td>
				<a 	href="/su22b1_it16304_sof3021/admin/accounts/delete/${ acc.id }"
					class="btn btn-danger"
				>delete</a>
			</td>
   		</tr>
   		</c:forEach>
  	</tbody>
</table>

<div class="position-relative">
	<ul class="pagination position-absolute mt-3 start-50 translate-middle">
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/accounts/index">
				First page
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/accounts/index?page=${data.number <= 0 ? data.totalPages - 1 : data.number - 1  }">
				Previos page
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/accounts/index?page=${ data.number >= data.totalPages - 1 ? 0:data.number + 1 }">
				Next page
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/accounts/index?page=${ data.totalPages - 1 }">
				Last page
			</a>
		</li>
	</ul>
</div>
