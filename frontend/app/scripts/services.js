angular.module('trip.services', [])

.service('TripAPI', ['$http', function($http) {

}])

.service('LoginService', [ '$http', function($http) {
	var LoginService = {};
	LoginService.doLogin = function(loginData, callback){
		$http({
			method : 'POST',
			url : 'http://localhost:8080/schooltrip/api/authz/login',
			headers : {
				'Authorization' : 'Basic ' + loginData.crypt()
			}
		}).then(function successCallback(response) {
			$log.log("OK")
			callback(response);
		}, function errorCallback(response) {
//			if (response.status = 401) { // If you have set 401
//				callback(response);
//			}else{
				callback(response);
//			}
		});
	};
	return LoginService;
} ]);
