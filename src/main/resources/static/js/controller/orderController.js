youBuyApp.controller('orderController', function ($scope, $http, $routeParams) {


    $http.get('http://localhost:8900/order/' + $routeParams.id).then(function (response) {
        $scope.order = response.data;
    });

    $scope.update = function (id, status) {
        $http.get('http://localhost:8900/update/status/' + id + '/' + status).then(function (response) {
            $scope.order = response.data;
        });
    };

    $scope.updateState = function (id) {
        $http.put('http://localhost:8900/order/update/status/' + id + '/APROVADO').then(function (response) {
            $scope.order = response.data;
        });
    };


    $scope.state = function (status) {
        if (status === 'APROVADO') {
            if ($scope.order.status === 'ACAMINHO'
                || $scope.order.status === 'ENTREGUE'
                || $scope.order.status === 'APROVADO') {
                return true;
            } else {
                return false;
            }
        }
        else if (status === 'ACAMINHO') {
            if ($scope.order.status === 'ENTREGUE'
                || $scope.order.status === 'ACAMINHO') {
                return true
            } else {
                return false;
            }
        }
        else if (status === 'ENTREGUE') {
            if ($scope.order.status === 'ENTREGUE') {
                return true;
            } else {
                return false;
            }
        }
    };
});