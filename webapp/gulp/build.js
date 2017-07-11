'use strict';

var gulp = require('gulp');
var runSequence = require('run-sequence');

gulp.task('app', function () {
    return gulp.src('./src/app/**/*')
        .pipe(gulp.dest('./dist/app'));
});

gulp.task('build', function(callback) {
    runSequence('scripts', 'styles', 'templates', 'app', callback);
});