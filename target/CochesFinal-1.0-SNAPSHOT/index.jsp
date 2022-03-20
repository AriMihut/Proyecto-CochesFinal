<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shirk-to-fit=no">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e7f8583fb5.js" crossorigin="anonymous"></script>  
        <title>Coches de Fórmula 1</title>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>  
    </head>
    <body>
        <!-- Encabezado -->
        <jsp:include page="WEB-INF/paginas/comunes/encabezado.jsp"/>
        <div class="container mt-3">
                  
         <form action="${pageContext.request.contextPath}/ServletControlador?accion=hacerLogin"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row">
                       <div class="col">
                         <label for="nombre">Nombre</label>
                         <input type="text" class="form-control" name="usuario" style="width:500px;height:40px;background-color:blue;color:#ffffff;text-align:center;" required> 
                           </div>
                         <div class="col">
                         <label for="contrasena">Contrasena</label>
                        <input type="password" class="form-control" name="contrasena" style="width:500px;height:40px;background-color:blue;color:white;text-align:center;" required>     
                        </div>
                    </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Enviar</button>
                </div>
            </form>
                  </div>
        <!-- footer -->
        <jsp:include page="WEB-INF/paginas/comunes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
