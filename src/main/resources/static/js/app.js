var youBuyApp = angular.module("youBuyApp", ['ngRoute']);

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
    .when("/cadastro-produto", {
        templateUrl: 'views/cadastro-produto.html',
        controller: 'cadastroProdutoController as vm'
    })
    .when("/carrer", {
        templateUrl: 'views/carrer.html',
        controller: 'carrerController'
    })
    .otherwise({
        rediretTo: '/'
    });

    $locationProvider.hashPrefix('').html5Mode(true);
});