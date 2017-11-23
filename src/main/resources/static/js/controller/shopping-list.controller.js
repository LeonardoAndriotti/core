(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('shoppingListController', ShoppingListController);

    ShoppingListController.$inject = ['$http', '$window'];

    function ShoppingListController($http, $window) {

        var vm = this;
        vm.newShoppingList = newShoppingList;
        vm.closeAlert = closeAlert;
        clean();

        vm.alerts = [];

        function closeAlert(index) {
            vm.alerts.splice(index, 1);
        }

        function newShoppingList() {
            $http.post('http://localhost:8092/shoppingList', vm.shoppingList)
                .then(function (response) {
                    clean();
                    vm.alerts.push({type: 'success', msg: 'Nova lista criada com sucesso.', timeout: 2000});
                    console.log("Deu bom!");
                }, function (response) {
                    vm.alerts.push({type: 'danger', msg: 'Favor preencher os campos obrigatórios.', timeout: 5000});
                    console.log("Deu ruim! " + JSON.stringify(response));
                });
        }

        function clean() {
            $window.scrollTo(0, 0);
        }
    }
}());