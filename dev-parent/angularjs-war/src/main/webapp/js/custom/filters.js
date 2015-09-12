'use strict';

/* Filters */
var phonecatFilters = angular.module('phonecatFilters', []);
phonecatFilters.filter('checkmark', function() {
  return function(input) {
    return input ? '\u2713' : '\u2718';
  };
});

phonecatFilters.filter('escape', function() {
  return function(input) {
    return window.encodeURIComponent(input);
  };
});