<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
<link type="text/css" rel="stylesheet" href="resources/css/global.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm mb-4">
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
       <a class="nav-link" href="<%= request.getContextPath() %>/RoadServlet">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<%= request.getContextPath() %>/AddCatalogServlet">Add Catalog</a>
    </li>
  </ul>
  
  <ul class="navbar-nav mx-auto">
 	 <li class="nav-item">
	     <form class="form-inline" action="<%= request.getContextPath() %>/searchItems" method="get">
	    	<input class="form-control mr-sm-2" type="text" placeholder="Search by name" 
	    	      name="searchKeyword">
	    	<button class="btn btn-success" type="submit">Search</button>
	  	</form>
  	</li>
  </ul>

</nav> 
  
  <div class="container">
      
      
    <c:if test="${showEditForm}">
	   <a href="<%= request.getContextPath() %>/RoadServlet" class="badge badge-info"><i class="fa fa-undo"></i>  Back to the List of Catalogs</a>
    <h1 class="h1 mt-4" style="text-align: center;">Update Catalog </h1>
      <div class="row mb-3">
        <div class="col-md-3"></div>
        <div class="col-md">
           <form action="<%= request.getContextPath() %>/updateItem" method="post">
           <input class="form-control" type="text"  hidden="true" name="idItem" 
				          value="<c:out value='${catalogItemData.itemId }'/>"/>
	           <div  class="form-group">
				   <label id="name">Name:</label>
				   <input class="form-control" type="text" id="name" name="name" 
				          value="<c:out value='${catalogItemData.name }'/>"/>
	           </div>
	           <div  class="form-group">
				   <label id="manufacturer">Manufacturer:</label>
				   <input class="form-control" type="text" id="manufacturer" 
				          name="manufacturer" 
				          value="<c:out value='${catalogItemData.manufacturer }'/>"/>
	           </div>
	           <div  class="form-group">
				   <label id="description">Description:</label>
				   <input class="form-control" type="text" id="description" name="description" 
				         value="<c:out value='${catalogItemData.description }'/>"/>
	           </div>
	           <div  class="form-group">
				   <label id="date">Date available:</label>
				   <input class="form-control" type="date" id="date" name="availableDate"
				          value="<c:out value='${catalogItemData.availableDate }'/>"/>
	           </div>
	           <button class="btn btn-primary"><i class="fa fa-paper-plane"></i> Update Catalog</button>
           </form>
           
        </div>
        <div class="col-md-3"></div>
      </div>
	  </c:if>
      
  
	  <table class="table table-striped">
		  <thead>
			  <tr>
				  <th>#</th>
				  <th>Name</th>
				  <th>Manufacturer</th>
				  <th>Description</th>
				  <th>Available date</th>
				  <th>Actions</th>
			  </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${catalogItems}" var="catalog">
			  <tr>
				  <td><c:out value="${catalog.itemId}"></c:out></td>
				  <td><c:out value="${catalog.name}"></c:out></td>
				  <td><c:out value="${catalog.manufacturer}"></c:out></td>
				  <td><c:out value="${catalog.description}"></c:out></td>
				  <td><c:out value="${catalog.availableDate}"></c:out></td>
				  <td>
				    <div class="icons">
				    <a href="<%= request.getContextPath() %>/detailItem?idItem=<c:out value='${catalog.itemId}' />"> 
				        <i class="fa fa-eye"></i>
				    </a>
				    <a href="<%= request.getContextPath() %>/editItem?idItem=<c:out value='${catalog.itemId}' />"> 
				      <i class="fa fa-edit"></i>
				     </a>
				    <a href="<%= request.getContextPath() %>/removeItem?idItem=<c:out value='${catalog.itemId}' />">
				     	<i class="fa fa-trash-alt"></i>
				    </a>
				    </div>
				  </td>
			  </tr>
			 </c:forEach>
		  </tbody>
	  </table>
  </div>
  
  
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</body>
</html>