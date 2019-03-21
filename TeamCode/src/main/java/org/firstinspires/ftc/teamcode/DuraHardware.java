package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import android.media.AudioAttributes;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.Voice;

import java.util.Locale;

public class DuraHardware {
    public DcMotor leftDrive;
    public DcMotor rightDrive;

    private Gamepad gamepad;
    private HardwareMap hMap;

    private TextToSpeech textToSpeech = null;

    private boolean tts = false;

    private double boost = 1;

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

        if (tts) {
            textToSpeech = new TextToSpeech(hMap.appContext, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {

                }
            });
            textToSpeech.setLanguage(Locale.US);
        }

    }


    //teleOp Opmodes

    //drive
    public void manageDrive(){
        leftDrive.setPower(gamepad.left_stick_y * boost);
        rightDrive.setPower(gamepad.right_stick_y * boost);
    }

    //boost
    public void manageBoost(){
        if (gamepad.right_bumper) boost = 1;
        if (gamepad.left_bumper) boost = 0.3;
    }

    //attempt at text to speech
    public void manageSpeech(){

        //if(!textToSpeech.isSpeaking()) {
            //oof
            if (gamepad.x) {
                textToSpeech.speak("oof", TextToSpeech.QUEUE_ADD, null);
            }

            //annoying
            if (gamepad.y) {
                textToSpeech.speak("la la la la la la la la la la la la la la la", TextToSpeech.QUEUE_ADD, null);
            }

            //E
            if (gamepad.a) {
                textToSpeech.speak("E", TextToSpeech.QUEUE_ADD, null);
            }

            //no
            if (gamepad.b) {
                textToSpeech.speak("no.", TextToSpeech.QUEUE_ADD, null);
            }
        //}
    }

}