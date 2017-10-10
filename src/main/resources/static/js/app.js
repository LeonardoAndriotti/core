var youBuyApp = angular.module("youBuyApp", ['ngRoute']);

youBuyApp.config(function($routeProvider, $locationProvider){
    $routeProvider
    .when("/promocao",{
        templateUrl : 'views/promocao.html',
        controller : 'promocaoController'
    }).otherwise({
        rediretTo: '/'
    });

    $locationProvider.hashPrefix('').html5Mode(true);
});