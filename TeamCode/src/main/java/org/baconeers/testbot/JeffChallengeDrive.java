package org.baconeers.testbot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.baconeers.SkystoneDrive.SkystoneConfiguration;
import org.baconeers.common.BaconComponent;
import org.baconeers.common.BaconOpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Baconeers on 8/11/2018.
 */
public class JeffChallengeDrive extends BaconComponent {
    // members:
    private BaconOpMode opmode = null;
    private JeffChallengeConfiguration config = null;
    private int number;


       public JeffChallengeDrive(BaconOpMode opmode, JeffChallengeConfiguration config) {
        super(opmode);
        this.opmode = opmode;
        this.config = config;
    }

    public void update(){
           /*

           double stickThreshold = 0.1;

           if(opmode.gamepad1.left_stick_y > stickThreshold || opmode.gamepad1.left_stick_y < -stickThreshold) {
               double turnPower = opmode.gamepad1.right_stick_x;
               double minPower = 0d;
               double maxPower = 0.8d;
               turnPower = Range.clip(turnPower, minPower, maxPower);

               if(opmode.gamepad1.right_stick_x > stickThreshold) {
                   config.leftMotor.setPower(opmode.gamepad1.left_stick_y);
                   config.rightMotor.setPower(opmode.gamepad1.left_stick_y - turnPower);
               }
               else if(opmode.gamepad1.right_stick_x < -stickThreshold) {
                   config.leftMotor.setPower(opmode.gamepad1.left_stick_y - turnPower);
                   config.rightMotor.setPower(opmode.gamepad1.left_stick_y);
               }
               else {
                   config.leftMotor.setPower(opmode.gamepad1.left_stick_y);
                   config.rightMotor.setPower(opmode.gamepad1.left_stick_y);
               }
           }







           //Right stick right and left stick up. Left motor right x co-ord and right motor is x co-ord - 0.3
           if(opmode.gamepad1.right_stick_x > 0 && opmode.gamepad1.left_stick_y > 0) {
               if(opmode.gamepad1.right_stick_x < 0.4)
               config.leftMotor.setPower(opmode.gamepad1.left_stick_y);
               config.rightMotor.setPower(1 - opmode.gamepad1.right_stick_x);

           }
           //Right stick right and left stick down. Right motor right x co-ord and left motor is x co-ord - 0.3
        if(opmode.gamepad1.right_stick_x > 0 && opmode.gamepad1.left_stick_y < 0) {
            config.leftMotor.setPower(opmode.gamepad1.right_stick_x - 0.3);
            config.rightMotor.setPower(opmode.gamepad1.right_stick_x);
        }

        if(opmode.gamepad1.right_stick_x < 0 && opmode.gamepad1.left_stick_y > 0) {
            config.leftMotor.setPower(opmode.gamepad1.right_stick_x);
            config.rightMotor.setPower(opmode.gamepad1.right_stick_x + 0.3);

        }
        if(opmode.gamepad1.right_stick_x < 0 && opmode.gamepad1.left_stick_y < 0) {
            config.leftMotor.setPower(opmode.gamepad1.right_stick_x);
            config.rightMotor.setPower(opmode.gamepad1.right_stick_x + 0.3);

        }
           else if(opmode.gamepad1.right_stick_x < 0) {
               config.leftMotor.setPower(-opmode.gamepad1.right_stick_x);
               config.rightMotor.setPower(opmode.gamepad1.right_stick_x);
           }
           else {
               config.leftMotor.setPower(opmode.gamepad1.left_stick_y);
               config.rightMotor.setPower(opmode.gamepad1.left_stick_y);
           }

           */
        if(opmode.gamepad1.right_stick_x > 0) {
            config.leftMotor.setPower(opmode.gamepad1.right_stick_x);
            config.rightMotor.setPower(-opmode.gamepad1.right_stick_x);
        }
        else if(opmode.gamepad1.right_stick_x < 0) {
            config.leftMotor.setPower(-opmode.gamepad1.right_stick_x);
            config.rightMotor.setPower(opmode.gamepad1.right_stick_x);
        }
        else {
            config.leftMotor.setPower(opmode.gamepad1.left_stick_y);
            config.rightMotor.setPower(opmode.gamepad1.left_stick_y);
        }
    }
}