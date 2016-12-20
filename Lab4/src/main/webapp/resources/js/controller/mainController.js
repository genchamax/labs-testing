/**
 * Created by Max on 09.12.2016.
 */
(function () {
    angular.module("lab4")
        .controller('MainController', ['$http', '$scope', 'PaddingFactory', 'AjaxFactory',
            function ($http, $scope, PaddingFactory, AjaxFactory) {
                $scope.imageList = [];
                $scope.currentPage = 1;
                $scope.currentImage = '';

                $http.get('/api/images').then(function (data) {
                        $scope.imageList = data.data;
                    },
                    function () {

                    });

                $scope.setCurrentImage = function (image) {
                    $scope.currentImage = image;
                };

                $scope.getBegin = function () {
                    return parseInt($scope.currentPage * 5 - 5);
                };

                $scope.getRange = function () {
                    var range = [];

                    for (var i = 1; i < Math.ceil(($scope.imageList.length + 1) / 5) + 1; i++) {
                        range.push(i);
                    }
                    return range;
                };

                $scope.setPage = function (newCurrent) {
                    if (!(newCurrent < 1)) {
                        $scope.currentPage = newCurrent;
                    }
                };

                $scope.indicatorNumber = PaddingFactory.getIndicatorNumber($scope.currentPage, $scope.imageList.length);

                $scope.startPage = PaddingFactory.getStartPage($scope.currentPage);

                $scope.uploadImage = function (element) {
                    var image = element.files[0];
                    var fd = new FormData();
                    fd.append('image', image);
                    $http.post('/api/images', fd, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                    }).then(function () {
                        window.location.reload(true);
                    }, function () {

                    });
                };

                $scope.askAndDeleteImage = function (image) {
                    AjaxFactory.askAndCallFunction(
                        "Видалення картинки",
                        "Ви хочете видалити малюнок " + image + " ?",
                        $scope.deleteImage,
                        image
                    );
                };

                $scope.deleteImage = function (image) {
                    $http.delete('/api/images/' + image)
                        .then(function () {
                            window.location.reload(true);
                        }, function () {

                        });
                };

                $scope.renameImage = function (oldName, newName) {
                    AjaxFactory.renameFile("/api/images/", oldName, newName)
                        .success(function () {
                            window.location.reload(true);
                        })
                };

                $scope.askAndRenameImage = function (oldName, newName) {
                    AjaxFactory.askAndCallFunction(
                        "Зміна імені картинки",
                        "Ви хочете змінити назву картинки" + oldName + "?",
                        $scope.renameImage,
                        oldName,
                        newName
                    )
                }
            }]);
})();