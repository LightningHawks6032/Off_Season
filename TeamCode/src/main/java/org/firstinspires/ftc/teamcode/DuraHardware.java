package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DuraHardware {
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    private Gamepad gamepad;
    private HardwareMap hMap;

    public DuraHardware(HardwareMap nHMap, Gamepad nGP){
        hMap = nHMap;
        gamepad = nGP;
    }

    public void initHardware(){
        leftDrive  = hMap.get(DcMotor.class, "lm");
        rightDrive = hMap.get(DcMotor.class, "rm");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}