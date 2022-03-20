<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e7f8583fb5.js" crossorigin="anonymous"></script>    
        <title>Editar Coche</title>
    </head>
    <body>
        <!-- Encabezado -->
        <jsp:include page="/WEB-INF/paginas/comunes/encabezado.jsp"/>  
       <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarCoche&id=${coche.id}"
              method="POST" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="matricula">Matricula</label>
                                        <input type="text" class="form-control" name="matricula" required
                                        value="${coche.matricula}"> 
                                    </div>
                                <div class="form-group">
                                        <label for="marca">Marca</label>
                                        <input type="text" class="form-control" name="marca" required
                                        value="${coche.marca}"> 
                                </div>
                                <div class="form-group">
                                        <label for="anoFabricacion">Año Fabricación</label>
                                        <input type="number" class="form-control" name="anoFabricacion" required
                                        value="${coche.anoFabricacion}"> 
                                </div>
                                <div class="form-group">
                                        <label for="numCilindros">Número Cilindros</label>
                                        <input type="number" class="form-control" name="numCilindros" required
                                        value="${coche.numCilindros}"> 
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        <!-- Botones de navegación para editar cliente-->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>
        </form><!-- comment -->
        
        <!-- footer -->
         <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>