'use strict';

function ResultCtrl($scope, $resource, $window) {

    $scope.projects = [];

    $scope.currentProject = "";

    $scope.AllResultsProjects = $resource('/api/v1/events', {},
        { get: { method: 'GET', isArray: true } }
    );
    $scope.Results = $resource('/api/v1/vote/:project', {},
        { get: { method: 'GET', isArray: true } }
    );

    $scope.loadResultsProjects = function(){
        console.log("getting some result data");
         $scope.AllResultsProjects.get({},
            function(data){
            console.log(data);
                $scope.projects = data;
            },
            function(err){
                console.log(err);
        });
    };

    $scope.showChart = function(project) {
        $scope.currentProject = project;
        $scope.Results.get({project: project},

        function(data) {
            $scope.data = $scope.extract(data, 0);

            var keys = $scope.unique($scope.data).sort();
            var values = $scope.count($scope.data);

            var ctx = document.getElementById("myChart").getContext("2d");
            var chartData = {
                labels : keys,
                datasets : [
                    {
                        fillColor : "rgba(151,187,205,0.5)",
                        strokeColor : "rgba(151,187,205,1)",
                        data : values
			        }
                ]
            };
            var max = $scope.max(values);
            var myNewChart = new Chart(ctx).Bar(chartData, {
                scaleOverride: true,
                scaleSteps: max,
                scaleStepWidth: 1,
                scaleStartValue: 0
            });
            $('#chartModal').modal('show');
        },
        function(err){
            console.log(err);
        });
    };
    $scope.max = function(array) {
        var max = -1 ;
        for(var i = 0; i < array.length; i++) {
            if(array[i] > max)
                max = array[i];
        }
        return max;
    };
    $scope.extract = function(array, key) {
        var arr = new Array();
        for(var i = 0; i < array.length; i++) {
            arr.push(array[i][key]);
        }
        return arr;
    };
    $scope.unique = function(array){
        var arr = new Array();
        for(var i = 0; i < array.length; i++) {
            if(!contains(array[i], arr)) {
                arr.push(array[i]);
            }
        }
        return arr;
        function contains(needle, haystack) {
            for(var i = 0; i < haystack.length; i++) {
                if(haystack[i] === needle) return true;
            }
            return false;
        }
    }

    $scope.count = function(array) {
        var counts = new Array();
        for (var i = 0; i < array.length; i++) {
            counts[array[i]] = 1 + (counts[array[i]] || 0);
        }
        counts = counts.filter(function(n){return n;});
        console.log("counts are ", counts);
        return counts;
    }
}