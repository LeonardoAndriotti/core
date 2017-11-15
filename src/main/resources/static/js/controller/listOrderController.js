youBuyApp.controller('listOrderController', function ($scope, $http) {
    $http.get('http://localhost:8900/order/user/1').then(function (response) {
        $scope.orders = response.data;
    });
});