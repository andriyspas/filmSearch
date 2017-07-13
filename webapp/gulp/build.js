'use strict';

var gulp = require('gulp');
var runSequence = require('run-sequence');

gulp.task('app', function () {
    return gulp.src('./src/app/**/*')
        .pipe(gulp.dest('./dist/app'));
});

gulp.task('images', function () {
    return gulp.src('./src/assets/img/**/*')
        .pipe(gulp.dest('./dist/assets/img'));
});


gulp.task('build', function(callback) {
    runSequence('images', 'scripts', 'styles', 'templates', 'app', callback);
});