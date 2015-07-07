var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', [
        '$scope', '$http', function ($scope, $http) {
            $scope.name = 'World';
            $scope.orderProp = 'age';
            $http.get('/restapi/service/phones').success(function(data) {
                  $scope.phones = data;
            });
        }
]);