app.directive('headerApp', function () {
    return {
        restrict: 'E',
        scope: {
            info: '='
        },
        templateUrl: 'js/app/directives/header.html'
    };
});