app.directive('profile', function () {
    return {
        restrict: 'E',
        scope: {
            info: '='
        },
        templateUrl: 'js/app/directives/profile.html'
    };
});
