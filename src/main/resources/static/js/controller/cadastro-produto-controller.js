youBuyApp.controller("cadastroProdutoController", function($scope, $http){

    $scope.produtos = [];

    carregarCadastroProduto = function(){
        $http({method:'GET', url: 'http://localhost:8092/product'})
        .then(function(response){
            $scope.produtos = response.data;

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    };

    carregarCadastroProduto();
});