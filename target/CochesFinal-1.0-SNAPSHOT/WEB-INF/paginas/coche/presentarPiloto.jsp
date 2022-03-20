<div class="modal fade" id="presentarPilotoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Presentar piloto</h5>
                <button class="close" data-dismiss="modal"> 
                    <span>&times;</span>
                </button>
            </div>
            <div class="container-fluid mt-3">
            <a href="${pageContext.request.contextPath}/ServletControlador?accion=presentarPiloto"
                           class="btn btn-danger btn-block">
                            <i class="fas fa-trash"></i>Presentar Piloto
            </a> 
            <h1 style="text-align: center">PILOTOS</h1>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col p-3 bg-warning">
                            <div class="card" >
                                 <img class="card-img-top" src="${pageContext.request.contextPath}/WEB-INF/iconos/LewisHamilton.jpg" alt="Card image" >
                                    <div class="card-body">
                                        <h3 style="text-align:center">Lewis Hamilton</h3>
                                        <h5 class="card-title" style="text-align:center"> - Piloto británico de automovilismo - </h5>
                                            <p class="card-text" style="text-align:center">Nació el 7 de enero de 1985.</p>
                                            <p style="text-align:center">Ganador de siete campeonatos mundiales de Fórmula 1: McLaren en 2008, y Mercedes en 2014, 2015, 2017, 2018, 2019, 2020.</p>
                                    </div>
                            </div>
                        </div>
                        <div class="col p-3 bg-primary">
                            <div class="card" >
                                <img class="card-img-top" src="${pageContext.request.contextPath}/iconos/MichaelSchumacher.jpg" alt="Card image" >
                                    <div class="card-body">
                                        <h3 style="text-align:center">Michael Schumacher</h3>
                                        <h5 class="card-title" style="text-align:center"> - Piloto alemán de automovilismo - </h5>
                                            <p class="card-text" style="text-align:center">Nació el 3 de enero de 1969.</p>
                                            <p style="text-align:center">Ganador de siete campeonatos mundiales de Fórmula 1: Benetton - 1994 y 1995, Ferrari entre 2000 y 2004.</p>
                                    </div>
                            </div>
                        </div>  
                        <div class="col p-3 bg-primary">
                            <div class="card" >
                                <img class="card-img-top" src="iconos/LandoNorris.jpg" alt="Card image" >
                                    <div class="card-body">
                                        <h3 style="text-align:center">Lando Norris</h3>
                                        <h5 class="card-title" style="text-align:center"> - Piloto británico de automovilismo - </h5>
                                            <p class="card-text" style="text-align:center">Nació el 13 de noviembre de 1999.</p>
                                            <p style="text-align:center">Piloto de McLaren desde desde 2019.</p>
                                    </div>
                            </div>
                        </div>
                        <div class="col p-3 bg-warning">
                            <div class="card" >
                                <img class="card-img-top" src="iconos/Alonso.jpg" alt="Card image" >
                                    <div class="card-body">
                                        <h3 style="text-align:center">Fernando Alonso</h3>
                                        <h5 class="card-title" style="text-align:center"> - Piloto español de automovilismo - </h5>
                                            <p class="card-text" style="text-align:center">Nació el 29 de julio de 1981.</p>
                                            <p style="text-align:center">Ganador de dos campeonatos mundiales de Fórmula 1: Ferrari - 2005, Renault 2006.</p>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        </div> 
    </div>    
</div>