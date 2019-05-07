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

    public DcMotor backDrive;
    public DcMotor frontSteering;

    private Gamepad gamepad;
    private HardwareMap hMap;

    public DuraSteeringHardware(HardwareMap nHMap, Gamepad nGP){
        hMap = nHMap;
        gamepad = nGP;
    }

    public void initHardware() {
        backDrive = hMap.get(DcMotor.class, "bd");
        frontSteering = hMap.get(DcMotor.class, "fs");

        backDrive.setDirection(DcMotor.Direction.FORWARD);
        frontSteering.setDirection(DcMotor.Direction.FORWARD);


        backDrive.setPower(0);
        frontSteering.setPower(0);
    }

    //drive
    public void manageDrive(){
        backDrive.setPower(gamepad.left_stick_y * boost);
    }

    public void manageSteering(){

    }

    }
