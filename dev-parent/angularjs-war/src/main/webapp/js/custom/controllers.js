var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', [
        '$scope', 'titleService', '$http', function ($scope, titleService, $http) {
            $scope.name = 'World';
            $scope.orderProp = 'age';
            $http.get('/restapi/service/phones').success(function(data) {
                  $scope.phones = data;
            });
            $scope.$watch('query', function(newValue, oldValue) {
                    if (angular.isUndefined($scope.query) || $scope.query=="") {
                        titleService.setDefaultTitle();
                    } else {
                        titleService.setTitle($scope.query);
                    }
                }
            );
        }
]);

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', 'titleService', '$routeParams', '$http',
  function($scope, titleService, $routeParams, $http) {
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

phonecatControllers.controller('LoginCtrl', ['$scope', 'authService', '$http', function($scope, authService, $http) {
    $scope.login = function () {
        var user = {
            username: $scope.username,
            password: $scope.password
        };
        $http.post('/restapi/service/auth/login', user).success(function (data) {
            authService.setAuthData(data);
        }).error(function () {
            $scope.invalidCredential = true;
        });
    };
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
