youBuyApp.controller("carrerController", function($scope, $http){

    $scope.carrer = [];

    carregarCarrer = function(){
        $http({method:'GET', url: 'http://localhost:8093/order'})
        .then(function(response){
            $scope.carrer = response.data;

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    };

    carregarCarrer();
});