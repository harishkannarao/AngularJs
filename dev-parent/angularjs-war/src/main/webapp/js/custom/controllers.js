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

phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$rootScope', '$routeParams',
  function($scope, $rootScope, $routeParams) {
    $scope.phoneId = $routeParams.phoneId;
    $rootScope.title = 'Google Phone Gallery: ' + $scope.phoneId;
  }
]);