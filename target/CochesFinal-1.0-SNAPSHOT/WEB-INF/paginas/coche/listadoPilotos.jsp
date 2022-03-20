<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="pilotos">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de pilotos</h4>
                            </div>
                            <table class="table table-hover">
                                <thead class="table table-borderless">
                                    <tr>
                                        <th>#</th><!-- para el id-->
                                        <th>nombrePiloto</th>
                                        <th>idCoche</th>
                                        <th></th><!-- columna vacía-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="piloto" items="${pilotos}" >
                                        <tr>
                                            <td>${piloto.idPiloto}</td>
                                            <td>${piloto.nombrePiloto}</td>
                                            <td>${piloto.idCoche}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarPiloto&idPiloto=${piloto.idPiloto}"
                                                   class="btn btn-secondary">
                                                    <i class="fas fa-angle-double-right"></i>Editar 
                                                </a> 
                                            </td>     
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>    
                        </div>    
                    </div> 
                    <div class="col-md-3">
                        <div class="card text-center bg-primary text-white mb-5" style="height:180px;width:300px">
                            <div class="card-body">
                                <h3>Total Pilotos</h3>
                                <h4 class="display-4">
                                <i class="fas fa-users"></i> ${totalPilotos}
                                </h4>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>    
</section>    
                                
<!-- Agregar piloto MODAL-->    
<jsp:include page="/WEB-INF/paginas/coche/agregarPiloto.jsp"/>



