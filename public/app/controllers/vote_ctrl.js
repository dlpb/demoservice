'use strict';

function VoteCtrl($scope, $resource, $window, $location, projectProperties, times) {

    $scope.project = "";

    $scope.currentProjects = $resource('/api/v1/projects/current', {},
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
                $scope.projects = data;
                times.add($scope.projects);
            },
            function(err){
                console.log(err);
        });
    };

    $scope.setProject = function(project){
        projectProperties.set("project", $scope.projects[project]);
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