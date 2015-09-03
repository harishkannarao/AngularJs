'use strict';

/* App Module */
var phonecatApp = angular.module('phonecatApp', [
  'ngRoute',
  'phonecatAnimations',
  'phonecatControllers',
  'phonecatFilters'
]);

phonecatApp.config(['$routeProvider', function($routeProvider) {
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
      when('/userDetails', {
        templateUrl: 'partials/user-details.html',
        controller: 'UserDetailsCtrl'
      }).
      otherwise({
        redirectTo: '/phones'
      });

}]);

phonecatApp.service('authService', ['$rootScope', function ($rootScope) {
    this.authData = undefined;
    this.setAuthData = function (authData) {
        this.authData = authData;
        $rootScope.$broadcast('authChanged');
    };
    this.getAuthData = function () {
        return this.authData;
    };
    this.isAuthenticated = function () {
        return !angular.isUndefined(this.getAuthData());
    };
}]);

phonecatApp.factory('authHttpRequestInterceptor', ['$rootScope', '$injector', 'authService', function ($rootScope, $injector, authService) {
    var authHttpRequestInterceptor = {
        request: function ($request) {
            if (authService.isAuthenticated()) {
                $request.headers['auth-id'] = authService.getAuthData().authId;
                $request.headers['auth-token'] = authService.getAuthData().authToken;
            }
            return $request;
        }
    }
    return authHttpRequestInterceptor;
}]);

phonecatApp.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push('authHttpRequestInterceptor');
}]);

phonecatApp.run(['$rootScope', '$location', '$anchorScroll', '$routeParams', function($rootScope, $location, $anchorScroll, $routeParams) {
  //when the route is changed scroll to the proper element
  $rootScope.$on('$routeChangeSuccess', function(newRoute, oldRoute) {
    $location.hash($routeParams.scrollTo);
    $location.replace();
  });
}]);

