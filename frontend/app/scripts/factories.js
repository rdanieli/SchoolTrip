angular.module('trip.factories', [])
.factory('myInterceptor', ['$log', function($log) {  
    $log.debug('$log is here to show you that this is a regular factory with injection');

    var myInterceptor = {
		request: function(config) {
//            if (!SessionService.isAnonymus) {
//                config.headers['x-session-token'] = SessionService.token;
//            }
			$log.debug(config)
			
            return config;
        }
    };

    return myInterceptor;
}]);