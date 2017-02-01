var app = angular.module('CRM', []);

app.controller('AuthController', function () {
    this.authenticated = true;
    this.user = null;
    this.getUser = function (user) {
        this.user = user;
    }
});
app.controller('RegisterCtrl', function () {
    this.user = null;
    this.setUser = function (user) {
        this.user = user;
    }
})