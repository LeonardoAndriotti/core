(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('productRegistrationController', ProductRegistrationController);

    ProductRegistrationController.$inject = ['$http', '$window'];

    function ProductRegistrationController($http, $window) {

        var vm = this;
        vm.closeAlert = closeAlert;
        vm.registerProduct = registerProduct;
        vm.alerts = [];
        vm.category = [];

        clean();
        getCategories();

        function registerProduct() {
            vm.product.category = vm.category.id;
            $http.post('http://localhost:8092/product', vm.product)
                .then(function (response) {
                    clean();
                    vm.alerts.push({type: 'success', msg: 'Cadastro efetuado com sucesso.', timeout: 2000});
                }, function (response) {
                    $window.scrollTo(0, 0);
                    vm.alerts.push({type: 'danger', msg: 'Favor preencher os campos obrigatórios.', timeout: 5000});
                    console.log(JSON.stringify(response));
                });
        }

        function getCategories() {
            $http.get('http://localhost:8900/api/category/all', vm.category)
                .then(function (response) {
                    var i;
                    for (i = 0; i < response.data.length; i++) {
                        vm.category.push(response.data[i]);
                    }
                }, function (response) {
                    console.log(JSON.stringify(response));
                });
        }

        function clean() {
            vm.product = {
                status: true
            };
            $window.scrollTo(0, 0);
        }

        function closeAlert(index) {
            vm.alerts.splice(index, 1);
        }
    }
}());