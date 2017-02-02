var app = angular.module('CRM', []);

app.controller('AuthController', function () {
    this.authenticated = true;
    this.user = null;
    this.getUser = function (user) {
        this.user = user;
    }
});
app.controller('RegisterCtrl', [function () {
    this.user = null;
    this.setUser = function (user) {
        this.user = user;
    }

}]);

app.directive('passVerify', function () {
    return {
        restrict: 'A', // only activate on element attribute
        require: '?ngModel', // get a hold of NgModelController
        link: function (scope, elem, attrs, ngModel) {
            if (!ngModel) return; // do nothing if no ng-model

            // watch own value and re-validate on change
            scope.$watch(attrs.ngModel, function () {
                validate();
            });

            // observe the other value and re-validate on change
            attrs.$observe('passVerify', function (val) {
                validate();
            });

            var validate = function () {
                // values
                var val1 = ngModel.$viewValue;
                var val2 = attrs.equals;

                // set validity
                ngModel.$setValidity('passVerify', !val1 || !val2 || val1 === val2);
            };
        }
    }
});
//     return {
//         require: "ngModel",
//         scope: {
//             passVerify: "="
//         },
//         link: function (scope, element, attrs, ctrl) {
//             scope.$watch(function () {
//                 var combined;
//
//                 if (scope.passVerify || ctrl.$viewValue) {
//                     combined = scope.passVerify + '_' + ctrl.$viewValue;
//                 }
//                 return combined;
//             }, function (value) {
//                 if (value) {
//                     ctrl.$parsers.unshift(function (viewValue) {
//                         var origin = scope.passVerify;
//                         if (origin != viewValue) {
//                             ctrl.$setValidity("passVerify", true);
//                         } else {
//                             ctrl.$setValidity("passVerify", false);
//                             return viewValue;
//                         }
//                     });
//                 }
//             });
//         }
//     };
// });