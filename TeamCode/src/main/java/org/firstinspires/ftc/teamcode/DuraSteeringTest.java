package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import android.media.MediaPlayer;

import android.speech.tts.TextToSpeech;

import org.firstinspires.ftc.teamcode.DuraSteeringHardware;

@TeleOp(name="Steering test", group="Iterative Opmode")
public class DuraSteeringTest extends OpMode {
    private DuraSteeringHardware hardware;
    private Gamepad gamepad = new Gamepad();

    public void init() {
        // init hardware
        hardware = new DuraSteeringHardware(hardwareMap, gamepad1);
        hardware.initHardware();
    }

    public void loop() {
        if (gamepad1.left_trigger > 0) hardware.frontSteering.setPower(0.3);
        if (gamepad1.right_trigger > 0) hardware.frontSteering.setPower(-0.3);
        if (gamepad1.right_trigger * gamepad1.right_trigger > 0) hardware.frontSteering.setPower(0);
        if (gamepad1.right_trigger + gamepad1.right_trigger <= 0) hardware.frontSteering.setPower(0);

        hardware.manageDrive();

        telemetry.addData("Steer encoder value: ", hardware.frontSteering.getCurrentPosition());
        telemetry.update();
    }
}