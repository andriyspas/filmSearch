'use strict';

var gulp = require('gulp');
var runSequence = require('run-sequence');

var requireDir = require('require-dir');
requireDir('./gulp');

gulp.task('default', function (callback) {
    runSequence('clean', 'build', 'serve', callback);
});
