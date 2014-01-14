var App = angular.module('demoservice',
['ngResource', 'ngSanitize', 'ngAnimate', 'ngRoute']
);

App.config(function($locationProvider, $routeProvider) {

  $routeProvider.when('/', {
    templateUrl: 'assets/partials/index.html',
    controller: VoteCtrl
  });
  $routeProvider.when('/admin', {
    templateUrl: 'assets/partials/admin.html',
    controller: AdminCtrl
  });
  $routeProvider.when('/vote/choose', {
    templateUrl: 'assets/partials/choose.html',
    controller: VoteCtrl
  });
  $routeProvider.when('/results', {
    templateUrl: 'assets/partials/results.html',
    controller: ResultCtrl
  });
});

App.controller('voteCtrl', VoteCtrl);
App.controller('adminCtrl', AdminCtrl);
App.controller('resultCtrl', ResultCtrl);

App.service('projectProperties', function() {
    var properties = [];

    return {
        get: function(name) {
            return properties[name];
        },

        set: function(key, value) {
            properties[key] = value;
        }
    }
});

App.service('times', function(){
    return {
        add: function(array) {
                for(var i=0; i<array.length; i++){
                    var el = array[i];
                    var start = new Date();
                    start.setTime(el.start);
                    el.dateStart = start.toLocaleDateString();
                    el.timeStart = start.toLocaleTimeString();

                    var end = new Date();
                    end.setTime(el.end);
                    el.dateEnd = end.toLocaleDateString();
                    el.timeEnd = end.toLocaleTimeString();
                }
        }
    }
});