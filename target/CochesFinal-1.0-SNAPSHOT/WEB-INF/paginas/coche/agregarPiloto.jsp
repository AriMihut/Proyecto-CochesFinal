<div class="modal fade" id="agregarPilotoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Piloto</h5>
                <button class="close" data-dismiss="modal"> 
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarPiloto"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombrePiloto">Nombre piloto</label>
                        <input type="text" class="form-control" name="nombrePiloto" required> 
                    </div>
                    <div class="form-group">
                        <label for="idCoche">Id Coche</label>
                        <input type="number" class="form-control" name="idCoche" required> 
                    </div>
                </div>
                 <div class="modal-footer">
               <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
             </form>
        </div> 
    </div>    
</div>
                
              