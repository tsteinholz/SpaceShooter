#!/bin/bash
echo "Building Project."
./gradlew desktop:dist
cp ./desktop/build/libs/*.jar ./releases/SpaceShooter.jar
echo "The Project has been built and saved Successfully"
echo "Do you wish to debug Space Shooter??"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) cd ./releases;java -jar SpaceShooter.jar --debug;break;;
        No ) exit;;
    esac
done
