<section id="actions" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="pilotos.jsp" class="btn btn-light btn-block">
                            <i class="fas fa-arrow-left"></i>Regresar a Pilotos
                        </a>    
                    </div> 
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-success btn-block">
                            <i class="fas fa-check"></i>Guardar Piloto
                        </button>    
                    </div> 
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminarPiloto&idPiloto=${piloto.idPiloto}"
                           class="btn btn-danger btn-block">
                            <i class="fas fa-trash"></i>Eliminar Piloto
                        </a>    
                    </div> 
                </div>   
            </div>
</section> 
                         