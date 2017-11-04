youBuyApp.controller("promocaoController", function($scope, $http){

    $scope.produtos = [];
    $scope.myDecimal = 0;
    $scope.selected = [];

    carregarProdutos = function(){
        $http({method:'GET', url: 'https://api-product.herokuapp.com/product'})
        .then(function(response){
           $scope.produtos = response.data;
           console.log($scope.produtos);

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    },
    
        $scope.ordenar = function(keyname){
            $scope.sortKey = keyname;
            $scope.reverse = !$scope.reverse;
    },
    
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

    $scope.exists = function (item, list){
        return list.indexOf(item) > -1;
    };

    carregarProdutos();

});