define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('mainService', ['ajaxService', function (ajaxService) {
                 
        this.initializeApplication = function (successFunction, errorFunction) {       
            ajaxService.AjaxGet("/services/api/main/InitializeApplication", successFunction, errorFunction);           
        };
    
        this.authenicateUser = function (successFunction, errorFunction) {
            ajaxService.AjaxGet("/services/api/main/AuthenicateUser", successFunction, errorFunction);
        };

        this.logout = function (successFunction, errorFunction) {
            ajaxService.AjaxGet("/services/api/main/Logout", successFunction, errorFunction);
        };
    }]);
});