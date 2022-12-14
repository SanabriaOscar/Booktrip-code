<%
    /* Evitamos que la p?gina se guarde en el cach? del navegador y en los proxys */
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); // prevents caching at the proxy server
%>

<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Iniciar sesion</title>

        <link rel="stylesheet" href="bootstrap/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Dashboard/usuario/css/estilosRegister.css">
        <link href="https://fonts.googleapis.com/css2?family=PT+Serif:ital,wght@1,700&display=swap" rel="stylesheet">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/bootstrap.bundle.min.js"></script>


    </head>

    <body class="bg-gradient-primary">
 <% HttpSession sesion = request.getSession();
            int nivel = 0;
            if (request.getAttribute("rol")!=null) {
                nivel = (Integer) request.getAttribute("rol");
                if (nivel==1) {
                    sesion.setAttribute("nombre", request.getAttribute("email"));
                     sesion.setAttribute("nivel",nivel);
                      out.println("<script type=\"text/javascript\">");
                    out.println("window.location.href='/booktripO/vista/Dashboard/indexListaSolicitud.jsp';");
                    out.println("</script>");
                }
                if (nivel==2) {
                    sesion.setAttribute("email", request.getAttribute("email"));
                     sesion.setAttribute("nivel",nivel);
                      out.println("<script type=\"text/javascript\">");
                    out.println("window.location.href='/booktripO/vista/Propietario/indexListaInmueble.jsp';");
                    out.println("</script>");
                }if (nivel==3) {
                    sesion.setAttribute("email", request.getAttribute("email"));
                     sesion.setAttribute("nivel",nivel);
                     out.println("<script type=\"text/javascript\">");
                    out.println("window.location.href='/booktripO/vista/Viajero/indexListaPago.jsp';");
                    out.println("</script>");
                }
            }

        %>
        <a href="index.jsp" class="btn btn-outline-light ml-sm-5 mt-4">Volver al inicio</a>
        <div class="container">
            <h1 class="row justify-content-center tituloBooktrip">Booktrip</h1>
            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">Iniciar sesi?n</h1>
                                        </div>
                                        <form class="user" action="/booktripO/login" method="post">
                                            <div class="form-group">
                                                <input type="email" class="form-control form-control-user
                                                       " name="email" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Email">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user" name="password" id="exampleInputPassword" placeholder="Contrase?a">
                                            </div>
                                            <input type="submit" class="btn btn-primary btn-user btn-block" value="Login" name="btnIngresar">
                                            <!-- <a href="index.html" class="btn btn-primary btn-user btn-block"> Login </a>-->
                                            <hr>

                                        </form>
                                        <hr>

                                        <div class="text-center">
                                            <a class="small" href="Dashboard/usuario/add.jsp">Crea una cuenta</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>

            </div>

        </div>
       

        <%    if (request.getParameter("cerrar") != null) {
                session.invalidate();
            }
        %>  

    </body>

</html>