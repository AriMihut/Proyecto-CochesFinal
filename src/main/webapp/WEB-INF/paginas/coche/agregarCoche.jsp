<div class="modal fade" id="agregarCocheModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Coche</h5>
                <button class="close" data-dismiss="modal"> 
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarCoche"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="matricula">Matricula</label>
                        <input type="text" class="form-control" name="matricula" required> 
                    </div>
                    <div class="form-group">
                        <label for="marca">Marca</label>
                        <input type="text" class="form-control" name="marca" required> 
                    </div>
                    <div class="form-group">
                        <label for="anoFabricacion">Año Fabricación</label>
                        <input type="number" class="form-control" name="anoFabricacion" required> 
                    </div>
                    <div class="form-group">
                        <label for="numCilindros">Número cilindros</label>
                        <input type="number" class="form-control" name="numCilindros" required> 
                    </div>
                </div>
                 <div class="modal-footer">
               <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
             </form>
        </div> 
    </div>    
</div>