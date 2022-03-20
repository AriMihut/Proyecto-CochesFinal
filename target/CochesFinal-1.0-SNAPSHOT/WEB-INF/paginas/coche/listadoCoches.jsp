<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="coches">
            <div class="container">
                <div class="abs-center">
                <div class="row">
                    <div class="col-md-9">
                        <div class="card">
                            <div class="card-header">
                                <h4>Listado de coches</h4>
                            </div>
                            <table class="table table-borderless">
                                <thead class="table-success">
                                    <tr>
                                        <th>#</th><!-- para el id-->
                                        <th>matricula</th>
                                        <th>marca</th>
                                        <th>anoFabricacion</th>
                                        <th>numCilindros</th>
                                        <th></th><!-- columna vacía-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="coche" items="${coches}" >
                                        <tr>
                                            <td>${coche.id}</td>
                                            <td>${coche.matricula}</td>
                                            <td>${coche.marca}</td>
                                            <td>${coche.anoFabricacion}</td>
                                            <td>${coche.numCilindros}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarCoche&id=${coche.id}"
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
                                <h3>Total Coches</h3>
                                <h4 class="display-4">
                                <i class="fas fa-users"></i> ${totalCoches}
                                </h4>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>    
</section>    
                                
<!-- Agregar cliente MODAL-->    
<jsp:include page="/WEB-INF/paginas/coche/agregarCoche.jsp"/>
                                

