youBuyApp.controller("carrerController", function($scope, $http){
		
    carregarCarrer = function(){
        $http({method:'GET', url: 'http://localhost:8900/carrer/1'})
        .then(function(response){
        	$scope.total = total(response.data);
            $scope.carrer = response.data;
        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });
        
    };

    carregarCarrer();
   
    $scope.remove = function(id){
    	 $http({method:'GET', url: 'http://localhost:8900/carrer/delete/'+id})
         .then(function(response){
        	 carregarCarrer();
             $scope.retorno = response.data;
         }, function(response){
             console.log(response.data);
             console.log(response.status);

         });
    }
    
    $scope.enviar = function(){
   	 $http({method:'POST', url: 'http://localhost:8900/order/post/'})
        .then(function(response){
       	 carregarCarrer();
            $scope.retorno = response.data;
            alert('alou');
        }, function(response){
            console.log(response.data);
            console.log(response.status);

        });
   }
    
   function total(response){
	   var total2 = 0;
    	for (var i = 0; i < response.length; i++) {
    		total2 += response[i].total;
    		//alert(total);
		}
    	return total2;
    	
    }
  
});