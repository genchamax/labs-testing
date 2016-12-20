/**
 * Created by Max on 10.12.2016.
 */
(function () {
    angular.module("lab4")
        .factory('AjaxFactory', ['$http', '$mdDialog',
            function ($http, $mdDialog) {
                var ajaxFactory = {};

                ajaxFactory.askAndCallFunction = function (title, message, func) {
                    var args = [].slice.call(arguments, 3);
                    var dialog = $mdDialog.confirm()
                        .title(title)
                        .textContent(message)
                        .ok('OK')
                        .cancel('Отмена');

                    $mdDialog.show(dialog)
                        .then(function () {
                            func.apply(this, args);
                        }, function () {

                        });

                };


                ajaxFactory.deleteFile = function (url, fileIdentifier) {
                    $http.delete(url + fileIdentifier);
                };

                ajaxFactory.renameFile = function (url, oldName, newName) {

                    $http.put(url, JSON.stringify({
                        oldFileName: oldName,
                        newFileName: newName
                    }))

                };

                return ajaxFactory;
            }])
})();