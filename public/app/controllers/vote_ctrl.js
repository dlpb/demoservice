'use strict';

function VoteCtrl($scope, $resource, $window, $location, projectProperties, times) {

    $scope.event = "";

    $scope.currentProjects = $resource('/api/v1/events/current', {},
        { get: { method: 'GET', isArray: true } }
    );

    $scope.Vote = $resource('/api/v1/vote', {},
        { vote: { method: 'POST', isArray: false } }
    );

    $scope.vote = function(vote) {
        $scope.Vote.vote(
            {project: projectProperties.get("project").name, vote: vote},
            function (data) {
//               $scope.msg = data;
            },
            function (error) {
                console.log(error);
            });

    };

    $scope.loadProjects = function(){
        $scope.currentProjects.get({},
            function(data){
                $scope.events = data;
            },
            function(err){
                console.log(err);
        });
    };

    $scope.setProject = function(project){
        console.log("project is ", project)
        projectProperties.set("project", project);
        $location.path("/");
    };

    $scope.checkProject = function(){
        var project = projectProperties.get("project");
        if(!project){
            $scope.gotoChoose();
        }
        else{
            $scope.msg = project.desc  + " ("+  project.dateStart + ", " +project.timeStart + " - " + project.timeEnd + ")";
        }
    };

    $scope.gotoChoose = function(){
           $location.path("/vote/choose");
    };

}