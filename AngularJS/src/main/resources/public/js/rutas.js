var appCatMoviles = angular.module('appCatMoviles',
									['ngRoute', 'controladoresAppMoviles']
);

appCatMoviles.config(['$routeProvider', function($routeProvider){
	$routeProvider
		.when('/',
		{
			templateUrl: 'vistas/listado-moviles.html',
			controller: 'ControladorListadoMoviles'
		})
		.when('/moviles/:id_movil', 
		{
			templateUrl: 'vistas/detalles-movil.html',
			controller: 'ControladorDetallesMovil'
		});
}]);