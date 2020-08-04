// 定义actionApp模块，依赖于路由模块ngRoute
var actionApp = angular.module('actionApp', ['ngRoute']);
// 配置路由，并注入$routeProvider来配置
actionApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/oper', {
        controller: 'View1Controller', // 路由/oper的路由控制器名称
        templateUrl: 'views/view1.html', // 定义视图真正地址
    }).when('/directive', {
        controller: 'View2Controller',
        templateUrl: 'views/view2.html'
    });
}]);