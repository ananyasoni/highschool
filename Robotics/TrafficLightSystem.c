//Task Description: Implement a two-way-street intersection traffic light system for a small town.

//Pseudocode: 
//- Implement a normal traffic light cycle for Main Street.
//- Implement an emergency button handling mechanism that can prolong the green light on Main Street.

//setup:
#pragma config(Sensor, in1,    emergencyButton, sensorPotentiometer)
#pragma config(Sensor, in2,    bumpSwitch,      sensorTouch)
#pragma config(Sensor, dgtl1,  mainStreetRed,   sensorLEDtoVCC)
#pragma config(Sensor, dgtl2,  mainStreetYellow, sensorLEDtoVCC)
#pragma config(Sensor, dgtl3,  mainStreetGreen, sensorLEDtoVCC)
#pragma config(Sensor, dgtl4,  sideStreetRed,   sensorLEDtoVCC)
#pragma config(Sensor, dgtl5,  sideStreetYellow,sensorLEDtoVCC)
#pragma config(Sensor, dgtl6,  sideStreetGreen, sensorLEDtoVCC)
#pragma config(Motor,  port1,           leftMotor,     tmotorServoContinuousRotation, openLoop)
#pragma config(Motor,  port2,           rightMotor,    tmotorServoContinuousRotation, openLoop)



#include <stdbool.h>

// Function to check if a touch sensor is pressed
bool isBumpPressed(int sensorPort)
{
    return SensorValue[sensorPort] == 1;
}

// Function to check if the emergency button is activated
bool isEmergencyButtonActivated()
{
     return isBumpPressed(emergencyButton);
}

// Function to simulate the normal traffic light cycle
void trafficLightCycle()
{
    // Main Street Green
    turnLEDOn(mainStreetGreen);
    startMotor(leftMotor, 50);
    startMotor(rightMotor, 50);
    wait(30);

    // Main Street Yellow
    turnLEDOff(mainStreetGreen);
    turnLEDOn(mainStreetYellow);
    wait(3);

    // Main Street Red
    turnLEDOff(mainStreetYellow);
    turnLEDOn(mainStreetRed);
    wait(2);

    // Side Street Green
    turnLEDOff(mainStreetRed);
    turnLEDOn(sideStreetGreen);
    startMotor(leftMotor, -50);
    startMotor(rightMotor, -50);
    wait(30);

    // Side Street Yellow
    turnLEDOff(sideStreetGreen);
    turnLEDOn(sideStreetYellow);
    wait(3);

    // Side Street Red
    turnLEDOff(sideStreetYellow);
    turnLEDOn(sideStreetRed);
    wait(2);
}

task main()
{
    while (true)
    {
        // Normal Traffic Light Cycle
        trafficLightCycle();

        // Emergency Button Handling
        while (isBumpPressed(bumpSwitch))
        {
            startMotor(rightMotor, 127);
            startMotor(leftMotor, 127);
            turnLEDOn(mainStreetGreen);

            wait1Msec(500);

            if (!isBumpPressed(bumpSwitch))
                break;

            turnLEDOff(mainStreetGreen);
            turnLEDOn(mainStreetYellow);

            wait1Msec(500);

            if (!isBumpPressed(bumpSwitch))
                break;

            turnLEDOff(mainStreetYellow);
            turnLEDOn(mainStreetRed);

            wait1Msec(500);

            if (!isBumpPressed(bumpSwitch))
                break;

            // Check if the emergency button is activated
            if (isEmergencyButtonActivated())
            {
                // Emergency button is activated
                while (isEmergencyButtonActivated())
                {
                    // Main Street stays green until the emergency button is deactivated
                    startMotor(leftMotor, 127);
                    startMotor(rightMotor, 127);
                    turnLEDOn(mainStreetGreen);
                }

                // Emergency button deactivated, return to normal traffic light cycle
                stopMotor(leftMotor);
                stopMotor(rightMotor);
                turnLEDOff(mainStreetGreen);
                turnLEDOff(mainStreetYellow);
                turnLEDOff(mainStreetRed);
            }

            stopMotor(rightMotor);
            stopMotor(leftMotor);
        }
    }
}
