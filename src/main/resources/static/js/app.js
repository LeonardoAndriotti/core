var youBuyApp = angular.module("youBuyApp", ['ngRoute', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

youBuyApp.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when("/search", {
            templateUrl: 'views/search.html',
            controller: 'searchController'
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
            controller: 'shoppingListController'
        })
        .otherwise({
            rediretTo: '/'
        });

    $locationProvider.hashPrefix('').html5Mode(true);
});