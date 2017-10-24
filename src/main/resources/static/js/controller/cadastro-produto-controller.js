// youBuyApp.controller('cadastroProdutoController', function ($scope, $http) {
//
//     $scope.produtos = {};
//
//     cadastrarProduto = function () {
//         $http({method: 'POST', url: 'http://localhost:8092/product'})
//             .then(function (response) {
//                 console.log("Deu bom!");
//
//             }, function (response) {
//                 console.log("Deu ruim!");
//             });
//     };
// });

(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('cadastroProdutoController', CadastroProdutoController);

    CadastroProdutoController.$inject = ['$http'];

    function CadastroProdutoController($http) {

        var vm = this;

        vm.cadastrarProduto = cadastrarProduto;
        vm.category1 = {id:1};
        vm.category2 = {id:2};

        function cadastrarProduto() {
            vm.product.category = vm.category1;
            $http.post('http://localhost:8092/product', vm.product)
                .then(function (response) {
                    console.log("Deu bom!");

                }, function (response) {
                    console.log("Deu ruim! " + JSON.stringify(response));
                });
        }
    }
}());