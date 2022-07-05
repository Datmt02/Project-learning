<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table class="table ">
	<thead>
    	<tr>
      		<th >Id</th>
		    <th >Name</th>
		    <th >Category</th>
		    <th >Price</th>
		    <th > Available</th>
		    <th > Create Date</th>
		    <th > Image</th>
		    <th colspan="2">Action</th>
    	</tr>
  	</thead>
  	<tbody>
   		<c:forEach items="${ data.content }" var="ordDt">
   		<tr>
   			<td>${ ordDt.id }</td>
   			<td>${ ordDt.name }</td>
   			<td>${ ordDt.category.name }</td>
   			<td>${ ordDt.price }</td>
   			<td>${ ordDt.available }</td>
   			<td>${ ordDt.createdDate }</td>
   			<td class="col-2">
				<img alt="" src="${ ordDt.image }" style="width:50%;">
			</td>
   			<td>
				<a href="/su22b1_it16304_sof3021/admin/products/edit/${ ordDt.id }" class="btn btn-primary">Update</a>
			</td>
			<td>
				<a 	href="/su22b1_it16304_sof3021/admin/products/delete/${ ordDt.id }"
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
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/products/index">
				First page
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/products/index?page= ${data.number <= 0 ? data.totalPages - 1 : data.number - 1  } ">
				Previos page
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/products/index?page=${ data.number >= data.totalPages - 1 ? 0:data.number + 1 }">
				Next page
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="/su22b1_it16304_sof3021/admin/products/index?page=${ data.totalPages - 1 }">
				Last page
			</a>
		</li>
	</ul>
</div>
