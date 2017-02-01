app.directive('footerApp', function () {
    return {
        restrict: 'E',
        scope: {
            info: "="
        },
        templateUrl: 'js/app/directives/footer.html'
    }
})