#!/bin/bash

###############################################################################
# Space Shooter Software License
# Version 0.0.2-alpha
#
# Copyright (C) 2015 Last Stand Studio
#
#  SpaceShooter is free software: you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation, either version 3 of the License, or
#  (at your option) any later version.
#
#  SpaceShooter is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  You should have received a copy of the GNU General Public License
#  along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
###############################################################################

VERSION="-v0.0.2-alpha"
RELEASE_FOLDER="Releases"

clear
echo "Space Shooter Community Jar Builder for LINUX"
echo "Building Project..."

./gradlew desktop:dist

mkdir ./${RELEASE_FOLDER} -p
cp ./desktop/build/libs/*.jar ./${RELEASE_FOLDER}/SpaceShooter${VERSION}.jar
echo "Space Shooter has been built and saved Successfully"
echo "Space Shooter is now being cleaned up!"
gradle clean

echo "Do you wish to debug Space Shooter??"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) cd ./${RELEASE_FOLDER};java -jar SpaceShooter${VERSION}.jar --debug;break;;
        No ) exit;;
    esac
done
ls
