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

echo "/u001B[36mSpace Shooter Community Jar Builder for LINUX"
echo "/u001B[35mBuilding Project..."
./gradlew desktop:dist
mkdir ./releases -p
cp ./desktop/build/libs/*.jar ./releases/SpaceShooter.jar
echo "/u001B[32mSpace Shooter has been built and saved Successfully"
echo "/u001B[36mSpace Shooter is now being cleaned up!"
gradle clean
echo "/u001B[35mDo you wish to debug Space Shooter??"
select yn in "/u001B[32mYes" "/u001B[31mNo"; do
    case $yn in
        Yes ) cd ./releases;java -jar SpaceShooter.jar --debug;break;;
        No ) exit;;
    esac
done
