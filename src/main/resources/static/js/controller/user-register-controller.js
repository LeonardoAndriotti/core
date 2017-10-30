(function () {
    'use strict';

    angular
        .module('youBuyApp')
        .controller('userRegistryController', UserRegistryController);

    UserRegistryController.$inject = ['$http'];

    function UserRegistryController($http) {

        var vm = this;

        vm.registry = registry;

        function registry() {
            $http.post('http://localhost:8092/user/registry', vm.user)
                .then(function (response) {
                    console.log("Deu bom!");

                }, function (response) {
                    console.log("Deu ruim! " + JSON.stringify(response));
                });
        }
    }
}());