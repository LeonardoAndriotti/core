youBuyApp.controller("carrerController", function($scope, $http){

    carregarCarrer = function(){
        $http({method:'GET', url: 'http://localhost:8900/carrer/1'})
        .then(function(response){
            $scope.carrer = response.data;

        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });

    };

    carregarCarrer();
});