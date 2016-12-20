/**
 * Created by Max on 10.12.2016.
 */
(function () {
    angular.module("lab4")
        .factory('PaddingFactory', [
            function () {
                var paddingFactory = {};

                var itemNumber = 5;
                var indicatorNumber = 10;

                paddingFactory.getBegin = function (currentPage) {
                    return parseInt(currentPage * itemNumber - itemNumber);
                };

                paddingFactory.getIndicatorNumber = function (currentPage, itemListLength) {
                    return currentPage * itemNumber - itemListLength;
                };

                paddingFactory.getStartPage = function (currentPage) {
                    return Math.ceil(currentPage / indicatorNumber) * indicatorNumber;
                };

                return paddingFactory;
            }])
})();