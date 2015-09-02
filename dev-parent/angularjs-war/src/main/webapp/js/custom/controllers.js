var phonecatControllers = angular.module('phonecatControllers', []);

phonecatControllers.controller('PhoneListCtrl', [
        '$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {
            $scope.name = 'World';
            $scope.orderProp = 'age';
            $http.get('/restapi/service/phones').success(function(data) {
                  $scope.phones = data;
            });
            $scope.$watch('query', function(newValue, oldValue) {
                    if (angular.isUndefined($scope.query)) {
                        $rootScope.title = 'Google Phone Gallery: ';
                    } else {
                        $rootScope.title = 'Google Phone Gallery: ' + $scope.query;
                    }
                }
            );
        }
]);

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$rootScope', '$routeParams', '$http',
  function($scope, $rootScope, $routeParams, $http) {
    $scope.phoneId = $routeParams.phoneId;
    $http.get('/restapi/service/phones/' + $routeParams.phoneId).success(function(data) {
      $scope.phone = data;
      $rootScope.title = 'Google Phone Gallery: ' + $scope.phone.name;
      $scope.mainImageUrl = data.images[0];
    });
    $scope.setImage = function(imageUrl) {
      $scope.mainImageUrl = imageUrl;
    };
}]);

phonecatControllers.controller('LoginCtrl', ['$scope', '$rootScope', 'authFactory',
    function($scope, $rootScope, authFactory) {
        $rootScope.title = 'Google Phone Gallery: Login';
        $scope.invalidCredential = false;
        $scope.login = function () {
            var user = {
                username: $scope.username,
                password: $scope.password
            };
            authFactory.login(user).success(function (data) {
                authFactory.setAuthData(data);
            }).error(function () {
                $scope.invalidCredential = true;
            });
        };
    }
]);

phonecatControllers.controller('FocusExampleCtrl', ['$scope', '$rootScope', function($scope, $rootScope) {
        $rootScope.title = 'Google Phone Gallery: Focus Example';
        $scope.items = [];
        for(var i=1; i<=200; i++) {
            $scope.items.push(i);
        }
    }]);
