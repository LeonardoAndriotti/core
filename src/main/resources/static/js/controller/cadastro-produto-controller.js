angular.module('youBuyApp',[]).controller('cadastroProdutoController', function($scope) {

    $scope.produto = {};

    $scope.cadastrarProduto = function(produto){
        $scope.produto.nome = $scope.nome;
        console.log($scope.produto.nome);
    };
});