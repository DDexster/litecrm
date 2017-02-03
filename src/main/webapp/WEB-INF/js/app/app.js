var app = angular.module('CRM', []);

app.controller('AuthController', function () {
    this.authenticated = true;
    this.user = null;
    this.getUser = function (user) {
        this.user = user;
    };

    var userMock = {
        firstName: "Dmytro",
        lastName: "Bondarenko",
        email: "d.bondrnko@gmail.com",
        company: "DEX ltd.",
        password: "555282289",
        country: "Ukraine",
        phone: "(067)250-02-95"
    };

    this.user = userMock;
});
app.controller('RegisterCtrl', [function () {
    this.user = null;
    this.setUser = function (user) {
        this.user = user;
    }

}]);


