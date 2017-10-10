youBuyApp.controller("promocaoController", function($scope, $http){

    $scope.produtos = [];

    carregarProdutos = function(){
        $http({method:'GET', url: 'http://localhost:8092/product'})
        .then(function(response){
            $scope.produtos = response.data;

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    };

    carregarProdutos();
});