(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('shoppingListController', ShoppingListController);

    ShoppingListController.$inject = ['$http'];

    function ShoppingListController($http) {

        var vm = this;

        vm.newShoppingList = newShoppingList;

        function newShoppingList() {
            $http.post('http://localhost:8092/shoppingList', vm.shoppingList)
                .then(function (response) {
                    console.log("Post deu bom!");
                }, function (response) {
                    console.log("Post deu ruim! " + JSON.stringify(response));
                });
        }
    }
}());
