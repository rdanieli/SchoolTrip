angular.module('trip.controllers', ['trip.services'])

.controller('AppCtrl', function($scope, $ionicModal, $timeout) {

	// With the new view caching in Ionic, Controllers are only called
	// when they are recreated or on app start, instead of every page change.
	// To listen for when this page is active (for example, to refresh data),
	// listen for the $ionicView.enter event:
	// $scope.$on('$ionicView.enter', function(e) {
	// });

	// Form data for the login modal

	// Create the login modal that we will use later
	$ionicModal.fromTemplateUrl('templates/login.html', {
		scope : $scope
	}).then(function(modal) {
		$scope.modal = modal;
	});

	// Triggered in the login modal to close it
	$scope.closeLogin = function() {
		$scope.modal.hide();
	};

	// Open the login modal
	$scope.login = function() {
		$scope.modal.show();
	};

})

.controller('PlaylistsCtrl', function($scope) {
	$scope.playlists = [ {
		title : 'Reggae',
		id : 1
	}, {
		title : 'Chill',
		id : 2
	}, {
		title : 'Dubstep',
		id : 3
	}, {
		title : 'Indie',
		id : 4
	}, {
		title : 'Rap',
		id : 5
	}, {
		title : 'Cowbell',
		id : 6
	} ];
})

.controller('PlaylistCtrl', function($scope, $stateParams) {
})

.controller('LoginCtrl', function($scope, $stateParams, LoginService) {
	$scope.loginData = {
		crypt : function(){
			return btoa($scope.loginData.username+':'+ $scope.loginData.password);
		}
	};
	$scope.doLogin = function() {
		LoginService.doLogin($scope.loginData,function(response){
			//Chamada de retorno
			if(response.status == 200){
				//autorizado
			}else if(response.status == 401){
				//nao autorizado
			}
		});
	};
});
