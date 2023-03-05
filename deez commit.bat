@echo off
title Commiting to github....
echo Adding files to commit..
call git add .
echo Commiting..
call git commit -m "whatever"
echo Switching Branch to 1.19...
call git branch -M 1.19
echo Fixing...
call git pull origin 1.19 --allow-unrelated-histories
echo Pushing the commit
call git push origin 1.19
echo As some people say 'Running something twice might fix everything'
pause