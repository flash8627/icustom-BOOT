/// <reference path="angularjs/ui-bootstrap-tpls-0.11.0.js" />
/// <reference path="angularjs/ui-bootstrap-tpls-0.11.0.js" />
/// <reference path="angularjs/ui-bootstrap-tpls-0.11.0.js" />
require.config({

    baseUrl: "",

    // alias libraries paths
    paths: {
        'application-configuration': 'scripts/application-configuration',       
        'angular': 'angularjs/angular',
        'angular-route': 'angularjs/angular-route',
        'angularAMD': 'angularjs/angularAMD',
         'ui-bootstrap' : 'angularjs/ui-bootstrap-tpls-0.11.0',
        'blockUI': 'angularjs/angular-block-ui',
        'ngload': 'angularjs/ngload',       
        'mainService': 'service/mainServices',
        'ajaxService': 'service/ajaxServices',
        'alertsService': 'service/alertsServices',
        'accountsService': 'service/accountsServices',
        'customersService': 'service/customersServices',
        'ordersService': 'service/ordersServices',
        'productsService': 'service/productsServices',
        'dataGridService': 'service/dataGridService',         
        'angular-sanitize': 'angularjs/angular-sanitize',
        'customersController': 'views/Shared/CustomersController',
        'productLookupModalController': 'Views/Shared/ProductLookupModalController'
    },

    // Add angular modules that does not support AMD out of the box, put it in a shim
    shim: {
        'angularAMD': ['angular'],
        'angular-route': ['angular'],
        'blockUI': ['angular'],
        'angular-sanitize': ['angular'],
        'ui-bootstrap': ['angular']
         
    },

    // kick start application
    deps: ['application-configuration']
});
