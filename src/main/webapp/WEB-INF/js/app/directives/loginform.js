app.directive('loginForm', function () {
    return {
        restrict: 'E',
        scope: {
            info: '='
        },
        templateUrl: 'js/app/directives/loginform.html'
    };
});
