app.directive('register', function () {
    return {
        restrict: 'E',
        scope: {
            info: '='
        },
        templateUrl: 'js/app/directives/registration.html'
    };
});
