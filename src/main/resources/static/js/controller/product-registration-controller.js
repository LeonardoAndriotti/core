(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('productRegistrationController', ProductRegistrationController);

    ProductRegistrationController.$inject = ['$http'];

    function ProductRegistrationController($http) {

        var vm = this;

        vm.registerProduct = registerProduct;

        function registerProduct() {
            $http.post('http://localhost:8092/product', vm.product)
                .then(function (response) {
                    console.log("Deu bom!");
                }, function (response) {
                    console.log("Deu ruim! " + JSON.stringify(response));
                });
        }
    }
}());