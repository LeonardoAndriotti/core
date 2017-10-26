youBuyApp.controller("promocaoController", function($scope, $http){

    $scope.produtos = [];

    carregarProdutos = function(){
        $http({method:'GET', url: 'https://api-product.herokuapp.com/product'})
        .then(function(response){
           $scope.produtos = response.data;
           console.log($scope.produtos);

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    };

    carregarProdutos();
});