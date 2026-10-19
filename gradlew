#!/bin/sh
APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
if [ ! -f "$JAR" ]; then
    URL="https://raw.githubusercontent.com/gradle/gradle/v8.9.0/gradle/wrapper/gradle-wrapper.jar"
    if command -v curl >/dev/null 2>&1; then
        curl -fL "$URL" -o "$JAR" || exit 1
    elif command -v wget >/dev/null 2>&1; then
        wget -q "$URL" -O "$JAR" || exit 1
    else
        echo "Do pobrania Gradle Wrapper potrzebny jest curl lub wget."
        exit 1
    fi
fi
exec java -classpath "$JAR" org.gradle.wrapper.GradleWrapperMain "$@"
