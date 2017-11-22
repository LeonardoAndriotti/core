youBuyApp.controller('searchController', function ($scope, $http) {
    var pesquisa = '';

    $http.get('http://localhost:8900/api/').then(function (response) {
        $scope.products = convertMoney(response);
    });

    $http.get('http://localhost:8900/api/category/all').then(function (response) {
        $scope.categorys = response.data;
    });

    $scope.searchForCategory = function (id) {
        $http.get('http://localhost:8900/api/category/'+id).then(function (response) {
            $scope.products = convertMoney(response);
        });
    };

    $scope.search = function () {
        pesquisa = $scope.busca;
        if (pesquisa === undefined) {
            $http.get('http://localhost:8900/api/').then(function (response) {
                $scope.products = convertMoney(response);
            });
        } else {
            $http({
                method: 'GET',
                url: 'http://localhost:8900/api/' + pesquisa
            }).then(function successCallback(response) {
                $scope.products = convertMoney(response);
            }, function errorCallback(response) {
                $scope.error = response.data;
            });
        }

    };

    function convertMoney(response){
        for(i = 0; i< response.data.length; i++){
            response.data[i].price =  new Intl.NumberFormat(
                'pt-br',{
                    style:'currency' ,
                    currency:'BRL'
                }
            ).format(response.data[i].price);
        }
        return response.data;
    }

});