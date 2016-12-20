/**
 * Created by Max on 09.12.2016.
 */
(function () {
    angular.module("lab4")
        .config(['$routeProvider', '$httpProvider', '$locationProvider',
            function ($routeProvider, $httpProvider, $locationProvider) {
                $routeProvider
                    .when("/", {
                        templateUrl: "/resources/pages/image-gallery.html"
                    })
                    .otherwise({
                        templateUrl: '/resources/pages/image-gallery.html'
                    });

                $locationProvider.html5Mode(true);
            }])
})();