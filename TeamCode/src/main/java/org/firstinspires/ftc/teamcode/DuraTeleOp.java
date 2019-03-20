package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.DuraHardware;

@TeleOp(name="DuraBot TeleOp", group="Iterative Opmode")
public class DuraTeleOp extends OpMode {
    private DuraHardware hardware;
    private Gamepad gamepad = new Gamepad();

    public void init() {
        // init hardware
        hardware = new DuraHardware(hardwareMap, gamepad1);
        hardware.initHardware();
    }

    public void loop() {
        hardware.manageDrive();
    }
}