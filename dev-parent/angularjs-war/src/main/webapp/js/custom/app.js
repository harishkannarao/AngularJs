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
      otherwise({
        redirectTo: '/phones'
      });

}]);

phonecatApp.factory('authFactory', ['$rootScope', function ($rootScope) {
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
    return authFactory;
}]);

phonecatApp.factory('authHttpRequestInterceptor', ['$rootScope', '$injector', 'authFactory', function ($rootScope, $injector, authFactory) {
    var authHttpRequestInterceptor = {
        request: function ($request) {
            var authFactory = $injector.get('authFactory');
            if (authFactory.isAuthenticated()) {
                $request.headers['auth-id'] = authFactory.getAuthData().authId;
                $request.headers['auth-token'] = authFactory.getAuthData().authToken;
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

