youBuyApp.controller("carrerController", function($scope, $http){
		
    carregarCarrer = function(){
        $http({method:'GET', url: 'http://localhost:8900/carrer/2'})
        .then(function(response){
            $scope.carrer = response.data;
        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });
        
    };

    carregarCarrer();
   
//    gerarTotal = function(response){
//    	$scope.total = 0;
//    	for (var i = 0; i < carrer.length; i++) {
//    		total += carrer[i].total;
//    		alert(total);
//		}
//    	
//    }
//    gerarTotal();
});