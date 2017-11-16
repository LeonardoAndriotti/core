(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('productRegistrationController', ProductRegistrationController);

    ProductRegistrationController.$inject = ['$http', '$window'];

    function ProductRegistrationController($http, $window) {

        var vm = this;
        vm.registerProduct = registerProduct;
        vm.closeAlert = closeAlert;
        clean();

        vm.alerts = [];

        function closeAlert(index) {
            vm.alerts.splice(index, 1);
        }

        function registerProduct() {
            $http.post('http://localhost:8092/product', vm.product)
                .then(function (response) {
                    clean();
                    vm.alerts.push({type: 'success', msg: 'Cadastro efetuado com sucesso.', timeout: 2000});
                    console.log("Deu bom!");
                }, function (response) {
                    $window.scrollTo(0, 0);
                    vm.alerts.push({type: 'danger', msg: 'Favor preencher os campos obrigatórios.', timeout: 5000});
                    console.log("Deu ruim! " + JSON.stringify(response));
                });
        }

        function clean() {
            vm.product = {
                status: true
            };
            $window.scrollTo(0, 0);
        }
    }
}());