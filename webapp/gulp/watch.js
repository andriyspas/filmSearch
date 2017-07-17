'use strict';

var gulp = require('gulp');

gulp.task('watch', function () {
    gulp.watch('./src/assets/css/**/*.scss', ['styles']);
    gulp.watch('./src/scripts/**/*.js', ['scripts']);
    gulp.watch('./src/app/**/*', ['app']);
});