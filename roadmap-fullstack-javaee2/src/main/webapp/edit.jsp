<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form edit Catalog</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
    <a href="<%= request.getContextPath() %>/RoadServlet" class="badge badge-info"><i class="fa fa-undo"></i>  Back to the List of Catalogs</a>
    <h1 class="h1 mt-4" style="text-align: center;">Update Catalog </h1>
      <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md">
           <form action="<%= request.getContextPath() %>/updateItem" method="post">
	           <div  class="form-group">
				   <label id="name">Name:</label>
				   <input class="form-control" type="text" id="name" name="name" value="<c:out value='${catalogItemData.name }'/>"/>
	           </div>
	           <div  class="form-group">
				   <label id="manufacturer">Manufacturer:</label>
				   <input class="form-control" type="text" id="manufacturer" name="manufacturer" placeholder="Enter manufacturer"/>
	           </div>
	           <div  class="form-group">
				   <label id="description">Description:</label>
				   <input class="form-control" type="text" id="description" name="description" placeholder="Enter description"/>
	           </div>
	           <div  class="form-group">
				   <label id="date">Date available:</label>
				   <input class="form-control" type="date" id="date" name="availableDate"/>
	           </div>
	           <button class="btn btn-primary"><i class="fa fa-paper-plane"></i> Save Data</button>
           </form>
           
        </div>
        <div class="col-md-3"></div>
      </div>
      
    </div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</body>
</html>