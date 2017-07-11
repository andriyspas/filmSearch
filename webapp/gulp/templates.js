'use strict';

var gulp = require('gulp');
var htmlmin = require('gulp-htmlmin');

gulp.task('templates', function() {
    return gulp.src('./src/index.html')
        .pipe(htmlmin({collapseWhitespace: true}))
        .pipe(gulp.dest('./dist'));
});