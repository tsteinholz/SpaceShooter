#!/bin/bash
echo "Building Project."
./gradlew desktop:dist
mkdir ./releases -p
cp ./desktop/build/libs/*.jar ./releases/SpaceShooter.jar
echo "Space Shooter has been built and saved Successfully"
echo "Space Shooter is now being cleaned up!"
gradle clean
echo "Do you wish to debug Space Shooter??"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) cd ./releases;java -jar SpaceShooter.jar --debug;break;;
        No ) exit;;
    esac
done
