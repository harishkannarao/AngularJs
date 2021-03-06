var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', ['$scope', 'titleService', '$http', function ($scope, titleService, $http) {
    $scope.name = 'World';
    $scope.orderProp = 'age';
    $scope.changeTitle = function() {
        if (angular.isUndefined($scope.query) || $scope.query=="") {
            titleService.setDefaultTitle();
        } else {
            titleService.setTitle($scope.query);
        }
    };
    $http.get('/restapi/service/phones').success(function(data) {
          $scope.phones = data;
    });
}]);

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', 'titleService', '$routeParams', '$http', function($scope, titleService, $routeParams, $http) {
    $scope.phoneId = $routeParams.phoneId;
    $http.get('/restapi/service/phones/' + $routeParams.phoneId).success(function(data) {
      $scope.phone = data;
      titleService.setTitle($scope.phone.name);
      $scope.mainImageUrl = data.images[0];
    });
    $scope.setImage = function(imageUrl) {
      $scope.mainImageUrl = imageUrl;
    };
}]);

phonecatControllers.controller('LoginCtrl', ['$scope', 'authService', '$http', '$location', function($scope, authService, $http, $location) {
    $scope.login = function () {
        var user = {
            username: $scope.username,
            password: $scope.password
        };
        $http.post('/restapi/service/auth/login', user).success(function (data) {
            authService.setAuthData(data);
            if (!angular.isUndefined($location.search().redirectTo)) {
                $location.url($location.search().redirectTo);
                $location.replace();
            } else {
                $location.path("/phones");
                $location.replace();
            }
        }).error(function () {
            $scope.invalidCredential = true;
        });
    };
}]);

phonecatControllers.controller('LoginElementCtrl', ['$scope', '$location', '$route', 'authService', '$rootScope', function($scope, $location, $route, authService, $rootScope) {
    $scope.$location = $location;
    $scope.$route = $route;
    $scope.isAuthenticated = authService.isAuthenticated();
    $rootScope.$on('authChanged', function(newRoute, oldRoute) {
        $scope.isAuthenticated = authService.isAuthenticated();
    });
}]);

phonecatControllers.controller('LoggedInUserElementCtrl', ['$scope', '$location', '$route', 'authService', '$rootScope', '$http', function($scope, $location, $route, authService, $rootScope, $http){
    $scope.$route = $route;
    $scope.isNotAuthenticated = !authService.isAuthenticated();
    $scope.logout = function () {
        $http.delete('/restapi/service/auth/logout').success(function (data) {
            authService.clearAuthData();
            if (!angular.equals($location.path(), '/phones')) {
                $location.hash('').search({}).path("/phones");
                $location.replace();
            }
        });
    };
    $rootScope.$on('authChanged', function(newRoute, oldRoute) {
        $scope.isNotAuthenticated = !authService.isAuthenticated();
    });
}]);

phonecatControllers.controller('UserDetailsCtrl', ['$scope', '$http', function($scope, $http) {
    $http.get('/restapi/service/auth/authAccess').success(function(data) {
          $scope.authDetails = data;
    });
}]);

phonecatControllers.controller('FocusExampleCtrl', ['$scope', function($scope) {
    $scope.items = [];
    for(var i=1; i<=200; i++) {
        $scope.items.push(i);
    }
}]);

phonecatControllers.controller('ErrorPageCtrl', ['$scope', '$location', function($scope, $location) {
    $scope.errorReference = $location.search().errorReference;
}]);

phonecatControllers.controller('TitleCtrl', ['$scope', '$route', '$rootScope', 'titleService', function($scope, $route, $rootScope, titleService){
    $scope.title = titleService.defaultTitle();
    $rootScope.$on('$routeChangeSuccess', function(newRoute, oldRoute) {
        if (!angular.isUndefined($route.current.pageTitle)) {
            $scope.title = titleService.delimitedTitle() + $route.current.pageTitle;
        } else {
            $scope.title = titleService.defaultTitle();
        }
    });
    $rootScope.$on('titleChanged', function (event, data) {
        $scope.title = titleService.currentTitle;
    });
}]);
