var showsapp = angular.module('tvShowDbApp', ['ngResource', 'ngRoute']);

showsapp.constant('gatewayURL', 'http://localhost:8002');

showsapp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/', {
            templateUrl: 'show-list.html',
            controller: 'Show-List-Controller'
        }).
        when('/show/:id', {
            templateUrl: 'show.html',
            controller: 'ShowController'
        }).
        when('/info',{
            templateUrl: 'info.html'
        }).
        when('/contact',{
            templateUrl: 'contact.html'
        }).
        otherwise({
            redirectTo: '/'
        });
}]);

showsapp.factory('Shows', ['$resource', 'gatewayURL', function($resource, gatewayURL) {
    return $resource(gatewayURL+'/shows/shows/:id',
        {id:'@id'},
        {'query': {method: 'GET', isArray: false }}
    );
}]);

showsapp.factory('Reviews', ['$resource', 'gatewayURL', function($resource, gatewayURL) {
    return $resource(gatewayURL+'/reviews/reviews/:id',
        {id:'@id'},
        {'search': {method: 'GET', url:gatewayURL+'/reviews/reviews/search/by-show', isArray: false }}
    );
}]);

showsapp.controller('Show-List-Controller', function ($scope, $resource, Shows) {

    Shows.query().$promise.then(function(results) {
        $scope.shows = results._embedded.shows;
    });

});

showsapp.controller("ShowController", function($scope, $routeParams, Shows, Reviews) {

    $scope.show = Shows.get({id: $routeParams.id});
    Reviews.search({showId: $routeParams.id}).$promise.then(function(results) {
        $scope.reviews = results._embedded.reviews;
    });

});