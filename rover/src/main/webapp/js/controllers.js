'use strict';

var app = angular.module('rover.controllers', []);

app.controller('MyCtrl1', [ '$scope', 'UserFactory', '$http', '$window', function($scope, UserFactory, $http, $window) {

    $scope.platError = false;
    $scope.pos1Error = false;
    $scope.pos2Error = false;
    $scope.finalposition = {};
    $scope.instructions = {};

    $scope.drop = function() {

        if (!$scope.evaluate($scope.instructions)) {

            var data = $scope.instructions;
            var config = {
                headers : {
                    'Content-Type' : 'application/json;charset=utf-8'
                }
            }
            $http.post('/rover/rest/rover', data, config).success(function(data, status, headers, config) {
                $scope.finalposition = data;
            }).error(function(data, status, header, config) {

            });
        }

    };

    $scope.evaluate = function(instructions) {

        var req = false;
        $scope.platError = false;
        $scope.pos1Error = false;
        $scope.pos2Error = false;

        if (!instructions.plat) {
            $scope.platErrorMsg = "Required field";
            $scope.platError = true;
            req = true;
        } else {
            var sPlat = instructions.plat.split(" ");
            if (sPlat.length !== 2) {
                $scope.platErrorMsg = "Invalid Content, Coordinate(x y)";
                $scope.platError = true;
                req = true;
            }
            ;
        }
        if (!instructions.pos1) {
            $scope.pos1ErrorMsg = "Required field";
            $scope.pos1Error = true;
            req = true;
        } else {
            var sPos1 = instructions.pos1.split(" ");
            if (sPos1.length !== 3 || $scope.checkPosFields(sPos1)) {

                $scope.pos1ErrorMsg = "Invalid Content, Coordinate(x y) plus Direction(Ex: N)";
                $scope.pos1Error = true;
                req = true;
            }
            ;
        }
        if (!instructions.pos2) {
            $scope.pos2ErrorMsg = "Required field";
            $scope.pos2Error = true;
            req = true;
        } else {
            var sPos2 = instructions.pos2.split(" ");
            if (sPos2.length !== 3 || $scope.checkPosFields(sPos2)) {

                $scope.pos2ErrorMsg = "Invalid Content, Coordinate(x y) plus Direction(Ex: N)";
                $scope.pos2Error = true;
                req = true;
            }
            ;

            if (req === false) {
                if (parseInt(sPos1[0]) > parseInt(sPlat[0]) || parseInt(sPos1[1]) > parseInt(sPlat[1])) {

                    $scope.pos1ErrorMsg = "Can not drop the Rover off the plateau";
                    $scope.pos1Error = true;
                    req = true;
                }
                if (parseInt(sPos2[0]) > parseInt(sPlat[0]) || parseInt(sPos2[1]) > parseInt(sPlat[1])) {

                    $scope.pos2ErrorMsg = "Can not drop the Rover off the plateau";
                    $scope.pos2Error = true;
                    req = true;
                }
            }

        }
        return req;
    };

    $scope.checkPosFields = function(fields) {

        if (isNaN(fields[0]) || isNaN(fields[1]) || !isNaN(fields[2]) || fields[2].length !== 1) {
            return true;
        }
        return false;

    }

} ]);

app.directive('dirPlat', function() {
    return {
        require : 'ngModel',
        restrict : 'A',
        link : function(scope, element, attr, ctrl) {
            function inputValue(val) {
                if (val) {
                    var digits = val.replace(/[^0-9 ]/g, '');
                    if (digits !== val) {
                        ctrl.$setViewValue(digits);
                        ctrl.$render();
                    }
                    return digits.toString();
                }
                return undefined;
            }
            ctrl.$parsers.push(inputValue);
        }
    };
});

app.directive('dirPosition', function($window) {
    return {
        require : 'ngModel',
        link : function(scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                var transformedInput = text.replace(/[^0-9NESW ]/g, '');
                console.log(transformedInput);
                if (transformedInput !== text) {
                    ngModelCtrl.$setViewValue(transformedInput);
                    ngModelCtrl.$render();
                }
                return transformedInput;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});

app.directive('dirInstruction', function($window) {
    return {
        require : 'ngModel',
        link : function(scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                var transformedInput = text.replace(/[^LRM]/g, '');
                console.log(transformedInput);
                if (transformedInput !== text) {
                    ngModelCtrl.$setViewValue(transformedInput);
                    ngModelCtrl.$render();
                }
                return transformedInput;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});


