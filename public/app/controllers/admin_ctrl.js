'use strict';

function AdminCtrl($scope, $resource, $window, times) {


    $scope.eventTemplate = function(){
        return {
            name: "",
            desc : "",
            start: "",
            end: "",
            active: true
        }
    };

    $scope.allEvents = [];
    $scope.currentlySelectedEvent = $scope.eventTemplate();

    $scope.Events = $resource('/api/v1/events', {},
        { get: { method: 'GET', isArray: true } }
    );

    $scope.AddEvent = $resource('/api/v1/events/add', {},
        { post: { method: 'POST', isArray: false } }
    );

    $scope.loadEvents = function(){

        $scope.Events.get({},
            function(data){
                $scope.allEvents = data;
            },
            function(err){
                console.log(err);
            }
        );
    };

    $scope.saveEvent = function(vote) {
    console.log("Posting ", $scope.currentlySelectedEvent, " to server");
        $scope.AddEvent.post(
        {
            name: $scope.currentlySelectedEvent.name,
            desc: $scope.currentlySelectedEvent.desc,
            start: $scope.currentlySelectedEvent.start,
            end: $scope.currentlySelectedEvent.end,
            active: true
        },
        function (data) {
            $scope.msg = data;
            $('#editModal').modal('hide');
            $scope.loadEvents();

        },
        function (error) {
            console.log(error);
        });

    };

    $scope.editEvent = function(index){

        $('#editModal').modal('show');

        $scope.currentlySelectedEvent = $scope.allEvents[index];
    };

}