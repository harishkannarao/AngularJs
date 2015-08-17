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

