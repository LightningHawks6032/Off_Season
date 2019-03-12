package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DuraHardware {
    // motors
    DcMotor leftDrive;
    DcMotor rightDrive;

    private HardwareMap hMap;

    public Hardware(){

    }

    public void initHardware(HardwareMap nHMap){
        hMap = nHMap;
        leftDrive  = hMap.get(DcMotor.class, "lm");
        rightDrive = hMap.get(DcMotor.class, "rm");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }
}