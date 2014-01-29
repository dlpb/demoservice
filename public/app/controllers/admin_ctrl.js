'use strict';

function AdminCtrl($scope, $resource, $window, times) {


    $scope.projectTemplate = function(){
        return {
            name: "",
            desc : "",
            dateStart:"",
            dateEnd : "",
            timeStart : "",
            timeEnd : ""
        }
    };

    $scope.index;
    $scope.allProjs = [];
    $scope.currentlySelectedProject = $scope.projectTemplate();

    $scope.allProjects = $resource('/api/v1/events', {},
        { get: { method: 'GET', isArray: true } }
    );

    $scope.addProject = $resource('/api/v1/events/add', {},
        { post: { method: 'POST', isArray: false } }
    );

    $scope.loadEvents = function(){

        $scope.allProjects.get({},
            function(data){
                $scope.allProjs = data;
                times.add($scope.allProjs);
            },
            function(err){
                console.log(err);
            }
        );
    };

    $scope.saveEvent = function(vote) {
        $scope.addProject.post(
        {
            name: $scope.currentlySelectedProject.name,
            desc: $scope.currentlySelectedProject.desc,
            dateStart: $scope.currentlySelectedProject.dateStart,
            timeStart: $scope.currentlySelectedProject.timeStart,
            dateEnd: $scope.currentlySelectedProject.dateEnd,
            timeEnd: $scope.currentlySelectedProject.timeEnd,
            active: true
        },
        function (data) {
            $scope.msg = data;
            $('#editModal').modal('hide');

        },
        function (error) {
            console.log(error);
        });

    };

    $scope.editProject = function(index){
        if(index >= 0){
            $scope.index = true;
        }
        else{
            $scope.index = false;
        }

        $('#editModal').modal('show');

        $scope.currentlySelectedProject = $scope.allProjs[index];
    };

}