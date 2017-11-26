youBuyApp.controller("promocaoController", function($scope, $http){

    $scope.produtos = [];
    $scope.myDecimal = 0;
    $scope.selected = [];
    /*Função que faz o GET de produtos na api-produto*/
    carregarProdutos = function(){
        $http({method:'GET', url: 'https://api-product.herokuapp.com/product'})
        .then(function(response){
           $scope.produtos = response.data;

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    },
    /*Ordenar a lista para tela */
    $scope.ordenar = function(){
        langKey = $scope.selected;
        $scope.sortKey = langKey;
        /*$scope.reverse = !$scope.reverse;*/
    },
    /*Adiciona os itens na lista do checkbox*/
    $scope.toggle = function(item, list){
        var idx = list.indexOf(item);

        if (idx > -1) {
            list.splice(idx, 1);
            console.log(list);
        }else {
            list.push(item);
            console.log(list);
        }

    },
    /*Verifica se existe itens na lista*/
    $scope.exists = function (item, list){
        return list.indexOf(item) > -1;
    };

    carregarProdutos();

});