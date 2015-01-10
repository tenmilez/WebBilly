#!/bin/sh

build_id=WebBilly
fortify_dir=/Applications/HP_Fortify/HP_Fortify_SCA_and_Apps_4.20
build_opts="-64 -Xmx4G"
app_srv_libs=/Applications/Tomcat/apache-tomcat-7.0.57/lib
code_dir=../../..
timestamp="$(date "+%Y.%m.%d-%H.%M.%S")"

function clean {
    #clean
    echo Cleaning "$build_id"
    sourceanalyzer -b "$build_id" -clean
}

function translate {
    #translate
    echo Translating "$build_id"
    sourceanalyzer -b "$build_id" $build_opts \
        -cp "$code_dir"/lib/**/*.jar \
        -cp "$app_srv_libs"/**/*.jar \
        -exclude "$code_dir"/web/WEB-INF/exclude/* \
        -exclude "$code_dir"/.idea \
        -exclude "$code_dir"/out \
        -source 1.7 \
        -debug \
        -logfile ./"$build_id".log \
        "$code_dir"
}

function scan {
    #scan
    echo Scanning "$build_id"
    sourceanalyzer -b "$build_id" $build_opts -scan -f ./"$build_id"_"$timestamp".fpr
}

function download {
    #download
    echo Downloading "$buil_id" from SSC
    fortifyclient downloadFPR -file ~/Documents/Development/IdeaProjects/WebBilly/web/WEB-INF/exclude/WebBilly_old.fpr \
        -project WebBilly -version 0.1 \
        -url http://localhost:8180/ssc \
        -authtoken 9a8bc3c1-24f3-46ad-b8fe-7bd977b9106b
}

function merge {
    echo "This doesn't work anymore; needs filenames as inputs. or maybe something else"
    #FPRUtility -merge -project ./WebBilly.fpr -source ./WebBilly_old.fpr -f ./test.fpr
}

function upload {
    #upload
    echo Uploading "$buil_id" to SSC
    fortifyclient uploadFPR -file ~/Documents/Development/IdeaProjects/WebBilly/web/WEB-INF/exclude/WebBilly_"$timestamp".fpr \
        -project WebBilly -version 0.1 \
        -url http://localhost:8180/ssc \
        -authtoken 3833c99a-8b0d-419f-b4d1-f22388f2250b
}

# Main

if [ -z "$1" ] ; then
    clean
    translate
    scan
    upload
else
    eval "$1"
fi