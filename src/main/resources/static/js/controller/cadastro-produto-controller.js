(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('cadastroProdutoController', CadastroProdutoController);

    CadastroProdutoController.$inject = ['$http'];

    function CadastroProdutoController($http) {

        var vm = this;

        vm.cadastrarProduto = cadastrarProduto;

        function cadastrarProduto() {
            $http.post('http://localhost:8092/product', vm.product)
                .then(function (response) {
                    console.log("Deu bom!");

                }, function (response) {
                    console.log("Deu ruim! " + JSON.stringify(response));
                });
        }
    }
}());