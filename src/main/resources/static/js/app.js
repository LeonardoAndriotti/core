var youBuyApp = angular.module("youBuyApp", ['ngRoute']);

youBuyApp.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when("/", {
            templateUrl: 'views/search.html',
            controller: 'searchController'
        })
        .when("/timeline/order/:id", {
            templateUrl: 'views/order.html',
            controller: 'orderController'
        }).when("/list/order", {
            templateUrl: 'views/list-order.html',
            controller: 'listOrderController'
        })
        .when("/promocao", {
            templateUrl: 'views/promocao.html',
            controller: 'promocaoController'
        })
        .when("/product-registration", {
            templateUrl: 'views/product-registration.html',
            controller: 'productRegistrationController as vm'
        })
        .otherwise({
            rediretTo: '/'
        });

    $locationProvider.hashPrefix('').html5Mode(true);
});