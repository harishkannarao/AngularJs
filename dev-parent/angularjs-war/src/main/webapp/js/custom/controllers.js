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

phonecatControllers.controller('LoginCtrl', ['$scope', 'titleService', 'authService', '$http', function($scope, titleService, authService, $http) {
    titleService.setTitle('Login');
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

phonecatControllers.controller('UserDetailsCtrl', ['$scope', 'titleService', '$http', function($scope, titleService, $http) {
    titleService.setTitle('User Details');
    $http.get('/restapi/service/auth/authAccess').success(function(data) {
          $scope.authDetails = data;
    });
}]);

phonecatControllers.controller('FocusExampleCtrl', ['$scope', 'titleService', function($scope, titleService) {
    titleService.setTitle('Focus Example');
    $scope.items = [];
    for(var i=1; i<=200; i++) {
        $scope.items.push(i);
    }
}]);

phonecatControllers.controller('ErrorPageCtrl', ['$scope', 'titleService', function($scope, titleService) {
    titleService.setTitle('Error Page');
}]);

phonecatControllers.controller('TitleCtrl', ['$scope', '$rootScope', 'titleService', function($scope, $rootScope, titleService){
    $scope.title = titleService.currentTitle;
    $rootScope.$on('titleChanged', function (event, data) {
        $scope.title = titleService.currentTitle;
    });
}]);
