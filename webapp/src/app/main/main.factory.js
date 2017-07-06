(function () {
    'use strict';

    angular
        .module('webapp')
        .factory('main', main);

    /** @ngInject */
    function main($http) {

        var factory = {
            getFilms: getFilms,
            getActors: getActors,
            getFilmsByYear: getFilmsByYear,
            getFilmsInRange: getFilmsInRange
        };
        return factory;

        function getFilms(title) {
            return $http.get('http://localhost:8080/api/film/get/title/' + title)
                .then(function (data) {
                    return data.data;
                });
        }

        function getActors(name) {
            return $http.get('http://localhost:8080/api/person/get/name/' + name)
                .then(function (data) {
                    return data.data;
                });
        }

        function getFilmsByYear(year) {
            return $http.get('http://localhost:8080/api/search/year/get', {
                    params: {
                        year: year
                    }
                })
                .then(function (data) {
                    return data.data;
                });
        }

        function getFilmsInRange(from, to) {
            return $http.get('http://localhost:8080/api/search/year/range', {
                    params: {
                        from: from,
                        to: to
                    }
                })
                .then(function (data) {
                    return data.data;
                });
        }
    }
})();

