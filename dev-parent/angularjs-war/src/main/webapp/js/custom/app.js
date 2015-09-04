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

phonecatApp.service('authService', ['$rootScope', '$window', function ($rootScope, $window) {
    this.setAuthData = function (authData) {
        if($window.localStorage) {
            $window.localStorage.setItem('auth-id', authData.authId);
            $window.localStorage.setItem('auth-token', authData.authToken);
            $rootScope.$broadcast('authChanged');
        }
    };
    this.getAuthData = function () {
        if($window.localStorage && $window.localStorage.getItem('auth-id') && $window.localStorage.getItem('auth-token')) {
            var authData = {
                authId: $window.localStorage.getItem('auth-id'),
                authToken: $window.localStorage.getItem('auth-token')
            };
            return authData;
        } else {
            return undefined;
        }
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

