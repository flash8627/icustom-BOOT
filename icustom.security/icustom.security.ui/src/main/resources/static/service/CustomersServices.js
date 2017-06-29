define(['application-configuration', 'ajaxService'], function (app) {

    app.register.service('customersService', ['ajaxService', function (ajaxService) {

        this.importCustomers = function (successFunction, errorFunction) {
            ajaxService.AjaxGet("/services/api/customers/ImportCustomers", successFunction, errorFunction);
        };

        this.getCustomers = function (customer, successFunction, errorFunction) {          
            ajaxService.AjaxGetWithData(customer, "/services/api/customers/GetCustomers", successFunction, errorFunction);
        };

        this.createCustomer = function (customer, successFunction, errorFunction) {
            ajaxService.AjaxPost(customer, "/services/api/customers/CreateCustomer", successFunction, errorFunction);
        };

        this.updateCustomer = function (customer, successFunction, errorFunction) {
            ajaxService.AjaxPost(customer, "/services/api/customers/UpdateCustomer", successFunction, errorFunction);
        };
     
        this.getCustomer = function (customerID, successFunction, errorFunction) {
            ajaxService.AjaxGetWithData(customerID, "/services/api/customers/GetCustomer", successFunction, errorFunction);
        };

    }]);
});