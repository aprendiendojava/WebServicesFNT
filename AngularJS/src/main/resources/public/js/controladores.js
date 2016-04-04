var controladoresAppMoviles = angular.module('controladoresAppMoviles',[]);

controladoresAppMoviles.controller('ControladorListadoMoviles',
									['$scope','$http',function($scope, $http){
	
	$scope.nombreTienda = 'Mi tienda de móviles';

	$http.get("json/datos.json")
		.success(function(data) {
			$scope.moviles = data;
		})
}]);

controladoresAppMoviles.controller('ControladorDetallesMovil',
		['$scope','$routeParams',function($scope, $routeParams){
			$scope.id_movil = $routeParams.id_movil;
}]);