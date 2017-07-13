'use strict';

var gulp = require('gulp');
var concat = require('gulp-concat');

gulp.task('scripts', function() {
    return gulp.src([
        './bower_components/jquery/dist/jquery.js',
        './bower_components/bootstrap/dist/js/bootstrap.js',
        './bower_components/angular/angular.js',
        './bower_components/angular-animate/angular-animate.js',
        './bower_components/angular-cookies/angular-cookies.js',
        './bower_components/angular-touch/angular-touch.js',
        './bower_components/angular-sanitize/angular-sanitize.js',
        './bower_components/angular-ui-router/release/angular-ui-router.js',
        './bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
        './bower_components/bootstrap-switch/dist/js/bootstrap-switch.js',
        './bower_components/angular-bootstrap-switch/dist/angular-bootstrap-switch.js',
        './bower_components/Chart.js/Chart.js',
        './bower_components/angular-chart.js/dist/angular-chart.js',
        './node_modules/lodash/lodash.js'
        ])
        .pipe(concat('main.js'))
        .pipe(gulp.dest('./dist/assets/js'));
});


