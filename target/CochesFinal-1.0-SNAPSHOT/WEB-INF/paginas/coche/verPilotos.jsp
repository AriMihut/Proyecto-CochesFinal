<div class="modal fade" id="verPilotos">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Ver Piloto</h5>
                <button class="close" data-dismiss="modal"> 
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=verPiloto"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombrePiloto">Nombre Piloto</label>
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