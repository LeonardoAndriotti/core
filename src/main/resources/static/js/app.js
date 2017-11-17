var youBuyApp = angular.module("youBuyApp", ['ngRoute', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

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
        .when("/shoppingList", {
            templateUrl: 'views/shoppingList.html',
            controller: 'shoppingListController as vm'
        })
        .otherwise({
            rediretTo: '/'
        });

    $locationProvider.hashPrefix('').html5Mode(false);
});