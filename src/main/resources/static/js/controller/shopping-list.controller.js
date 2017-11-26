youBuyApp.controller('shoppingListController', function ($scope, $http) {

    var list = '';
    $http.get('http://localhost:8900/api/list/product/user/1')
        .then(function (response) {
            $scope.listAll = hexaColor(response.data);
        });

    function hexaColor(color) {
        for (i = 0; i < color.length; i++) {
            color[i].color = '#' + color[i].color;
        }
        return color;
    }

    $scope.newList = function () {
        $scope.insertProductNewList = false;
    };

    $scope.newShoppingList = function () {
        $http.get('http://localhost:8900/api/create/new/list/'
            + $scope.name
            + "/" + $scope.description + "/"
            + 'DDDDDD')
            .then(function (response) {
                $scope.insertProductNewList = true;
                $scope.idList = response.data;
                this.list = response.data;
            });
    };

    $scope.newProduct = function (idList, product, amount) {
        $http.get('http://localhost:8900/api/create/new/list/product/'
            + idList
            + "/" + product + "/"
            + amount)
            .then(function (response) {
                $scope.listProd = response.data;
            });
    };

    $scope.remove = function (id) {
        $http.get('http://localhost:8900/api/list/product/remove/' + id)
            .then(function (response) {
                $scope.listProd = getProductList(this.list);
            });
    };

    function getProductList(id) {
        $http.get('http://localhost:8900/api/list/product/' + id)
            .then(function (response) {
                return response.data;
            });
    }


    $scope.viewList = function (id) {
        $http.get('http://localhost:8900/api/shopping/list/' + id)
            .then(function (response) {
                $scope.retorno =  response.data;
            });
    }

});