youBuyApp.controller("carrerController", function($scope, $http){

    $scope.carrer = [];
    $scope.value = ['14.50','18.20','22.49'];
    $scope.quant = 1;
    
    $scope.getTotal = function(){
        var soma = 0;
        for (var i = 0; i < $scope.value.length; i++) {
			soma += ($scope.value[i] * $scope.quant);
		}
        return soma;
    }
    
//    carregarCarrer = function(){
//        $http({method:'GET', url: 'http://localhost:8093/order'})
//        .then(function(response){
//            $scope.carrer = response.data;
//
//        }, function(response){
//            console.log(response.data);
//            console.log(response.status);
//
//        });
//
//    };
//
//    carregarCarrer();
});