<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Jekyll v4.1.1">
  <title>Robotap</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

  <!-- Bootstrap core CSS -->
  <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

  <!-- main -->
  <link href="assets/css/main.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/dashboard.css" rel="stylesheet">
</head>

<body>

  <jsp:include page="nav.jsp" />

  <div class="container-fluid">
    <div class="row">

      <jsp:include page="sidebar.jsp" />

      <%-- <jsp:include page="main.jsp" /> --%>
      <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">

        <% 
          //dynamic nav builder
          String p = (String) request.getAttribute("p");
          String pagePath;
          if(p != null){
            pagePath = p + ".jsp"; 
          } else {
            pagePath = "dashboard.jsp"; 
          }
        %>

        <jsp:include page="<%= pagePath %>" ></jsp:include>

      </main>

    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
  <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
  <script src="dashboard.js"></script>
</body>

</html>