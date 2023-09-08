#!/bin/bash

if [ "$1" == "reflection" ]; then
    cd /reflection && xelatex -synctex=1 -interaction=nonstopmode main.tex
elif [ "$1" == "groupreport" ]; then
    cd /groupreport && xelatex -synctex=1 -interaction=nonstopmode main.tex
else
    cd /reflection && xelatex -synctex=1 -interaction=nonstopmode main.tex
    cd /groupreport && xelatex -synctex=1 -interaction=nonstopmode main.tex
fi