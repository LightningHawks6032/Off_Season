package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.ftccommon.SoundPlayer;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;

import java.util.Locale;
import android.media.MediaPlayer;



public class DuraSteeringHardware{
    public int STEER_LEFT_LIMIT = 100;
    public int STEER_RIGHT_LIMIT = 0;
    private double boost = 0.6;

    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor frontSteering;

    private Gamepad gamepad;
    private HardwareMap hMap;

    public DuraSteeringHardware(HardwareMap nHMap, Gamepad nGP){
        hMap = nHMap;
        gamepad = nGP;
    }

    public void initHardware() {
        leftDrive = hMap.get(DcMotor.class, "lm");
        rightDrive = hMap.get(DcMotor.class, "rm");
        frontSteering = hMap.get(DcMotor.class, "fs");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontSteering.setDirection(DcMotor.Direction.FORWARD);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        frontSteering.setPower(0);
    }

    //drive
    public void manageDrive(){
        leftDrive.setPower(gamepad.left_stick_y * boost);
        rightDrive.setPower(gamepad.right_stick_y * boost);
    }

    public void manageSteering(){

    }

    }
