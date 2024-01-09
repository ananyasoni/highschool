#pragma config(Sensor, in1,    lineFollower,   sensorLineFollower)
#pragma config(Sensor, in2,    potentiometer,  sensorPotentiometer)
#pragma config(Sensor, dgtl1,  limitSwitch,    sensorTouch)
#pragma config(Sensor, dgtl2,  bumpSwitch,     sensorTouch)
#pragma config(Sensor, dgtl9,  yellow,         sensorLEDtoVCC)
#pragma config(Sensor, dgtl10, red,            sensorLEDtoVCC)
#pragma config(Sensor, dgtl12, green,          sensorLEDtoVCC)
#pragma config(Motor,  port1,           clawMotor,     tmotorServoContinuousRotation, openLoop)
#pragma config(Motor,  port2,           rightMotor,    tmotorServoContinuousRotation, openLoop)
#pragma config(Motor,  port3,           leftMotor,     tmotorServoContinuousRotation, openLoop)

// Motor movements and LED control
task main()
{
    // Move forward until bumpSwitch or limitSwitch is pressed
    while(true)
    {
        while(SensorValue[bumpSwitch] == 1 && SensorValue[limitSwitch] == 1)
        {
            startMotor(rightMotor, 127);
            startMotor(leftMotor, 127);
            turnLEDOn(red);

            wait1Msec(500);

            if(SensorValue[bumpSwitch] == 0 || SensorValue[limitSwitch] == 0)
                break;

            turnLEDOff(red);
            turnLEDOn(yellow);

            wait1Msec(500);

            if(SensorValue[bumpSwitch] == 0 || SensorValue[limitSwitch] == 0)
                break;

            turnLEDOff(yellow);
            turnLEDOn(green);

            wait1Msec(500);

            if(SensorValue[bumpSwitch] == 0 || SensorValue[limitSwitch] == 0)
                break;

            turnLEDOff(green);
            stopMotor(rightMotor);
            stopMotor(leftMotor);
        }

        stopMotor(rightMotor);
        stopMotor(leftMotor);
        turnLEDOff(yellow);
        turnLEDOff(red);
        turnLEDOff(green);
    }

    // Move the claw motor and stop
    while(true)
    {
        untilTouch(bumpSwitch);
        startMotor(clawMotor, -40);
        wait1Msec(700);
        stopMotor(clawMotor);

        untilTouch(bumpSwitch);
        startMotor(clawMotor, 40);
        wait1Msec(700);
        stopMotor(clawMotor);
    }

    // Move motors until bumpSwitch is released
    while(true)
    {
        untilTouch(bumpSwitch);
        startMotor(rightMotor, 127);
        startMotor(leftMotor, -127);
        untilRelease(bumpSwitch);
        stopMotor(rightMotor);
        stopMotor(leftMotor);
    }

    // Move motors until limitSwitch is touched and released
    task main()
    {
        while(true)
        {
            startMotor(leftMotor, 50);
            startMotor(rightMotor, 50);
            untilTouch(limitSwitch);
            stopMotor(leftMotor);
            stopMotor(rightMotor);
            untilRelease(limitSwitch);
        }
    }

    // Move motors based on potentiometer values
    untilPotentiometerLessThan(10, potentiometer);
    stopMotor(leftMotor);
    stopMotor(rightMotor);
    untilPotentiometerGreaterThan(10, potentiometer);
    startMotor(rightMotor, 30);
    startMotor(leftMotor, 30);
    untilPotentiometerGreaterThan(1001, potentiometer);
    stopMotor(rightMotor);
    stopMotor(leftMotor);
    startMotor(rightMotor, 60);
    startMotor(leftMotor, 60);
    untilPotentiometerGreaterThan(2001, potentiometer);
    stopMotor(rightMotor);
    stopMotor(leftMotor);
    startMotor(rightMotor, 90);
    startMotor(leftMotor, 90);
    untilPotentiometerGreaterThan(3001, potentiometer);
    stopMotor(rightMotor);
    stopMotor(leftMotor);
    startMotor(rightMotor, 127);
    startMotor(leftMotor, 127);

    // Control LEDs based on bumpSwitch presses
    turnLEDOn(red);
    turnLEDOff(yellow);
    turnLEDOff(green);
    int varNumPresses = 0;  // Variable to count button presses
    while(true)
    {
        untilTouch(bumpSwitch);
        wait1Msec(250);
        varNumPresses = varNumPresses + 1;

        if (varNumPresses >= 3)
        {
            turnLEDOff(red);
            turnLEDOn(yellow);
        }

        if (varNumPresses >= 6)
        {
            turnLEDOff(yellow);
            turnLEDOn(green);
        }

        if (varNumPresses >= 10)
        {
            turnLEDOff(green);
        }
    }

    // Move motors based on potentiometer values and control LEDs
    turnLEDOff(red);
    turnLEDOff(yellow);
    turnLEDOff(green);
    while(SensorValue[potentiometer] < 3000)
    {
        if(SensorValue[potentiometer] >= 0 && SensorValue[potentiometer] < 1000)
        {
            startMotor(rightMotor, 25);
            startMotor(leftMotor, 25);
            turnLEDOn(red);
        }

        if(SensorValue[potentiometer] >= 1001 && SensorValue[potentiometer] < 2000)
        {
            stopMotor(leftMotor);
            stopMotor(rightMotor);
            turnLEDOff(red);
            startMotor(rightMotor, 70);
            startMotor(leftMotor, 70);
            turnLEDOn(yellow);
        }

        if(SensorValue[potentiometer] >= 2001 && SensorValue[potentiometer] < 3000)
        {
            stopMotor(leftMotor);
            stopMotor(rightMotor);
            turnLEDOff(yellow);
            startMotor(rightMotor, 127);
            startMotor(leftMotor, 127);
            turnLEDOn(green);
        }
    }

    turnLEDOff(red);
    turnLEDOff(yellow);
    turnLEDOff(green);
}
