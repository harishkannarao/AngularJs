'use strict';

/* App Module */
var phonecatApp = angular.module('phonecatApp', [
  'ngRoute',
  'phonecatAnimations',
  'phonecatControllers',
  'phonecatFilters'
]);

phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/phones', {
        templateUrl: 'partials/phone-list.html',
        controller: 'PhoneListCtrl'
      }).
      when('/phones/:phoneId', {
        templateUrl: 'partials/phone-detail.html',
        controller: 'PhoneDetailCtrl'
      }).
      when('/login', {
        templateUrl: 'partials/login.html',
        controller: 'LoginCtrl'
      }).
      when('/focusExample', {
        templateUrl: 'partials/focus-example.html',
        controller: 'FocusExampleCtrl'
      }).
      otherwise({
        redirectTo: '/phones'
      });
  }
]);

phonecatApp.factory('authFactory', ['$rootScope', '$http', function ($rootScope, $http) {
    var authFactory = {
        authData: undefined
    };
    authFactory.setAuthData = function (authData) {
        this.authData = {
            authId: authData.authId,
            authToken: authData.authToken,
            authPermission: authData.authPermissions
        };
        $rootScope.$broadcast('authChanged');
    };
    authFactory.getAuthData = function () {
        return this.authData;
    };
    authFactory.isAuthenticated = function () {
        return !angular.isUndefined(this.getAuthData());
    };
    authFactory.login = function (user) {
        return $http.post('/restapi/service/auth/login', user);
    };
    return authFactory;
}]);

phonecatApp.run(['$rootScope', '$location', '$anchorScroll', '$routeParams', function($rootScope, $location, $anchorScroll, $routeParams) {
  //when the route is changed scroll to the proper element
  $rootScope.$on('$routeChangeSuccess', function(newRoute, oldRoute) {
    $location.hash($routeParams.scrollTo);
    $location.replace();
  });
}]);

