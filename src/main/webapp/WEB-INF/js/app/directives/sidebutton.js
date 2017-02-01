app.directive('sidebutton', function () {
    return {
        restrict: 'E',
        scope: {
            info: '='
        },
        templateUrl: 'js/app/directives/sidebutton.html'
    };
});
