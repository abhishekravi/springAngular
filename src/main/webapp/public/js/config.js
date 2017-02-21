(function () {
    angular
        .module("MyProject", ['ngRoute'])
        .config(Config);
    function Config($routeProvider) {
        $routeProvider

            .when("/test", {
                templateUrl: "public/pages/views/test/test.html",
                controller: "TestController",
                controllerAs: "model"
            })
            .otherwise({redirectTo: '/'})
    }

})();