package org.baconeers.testbot;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.baconeers.common.BaconOpMode;
import org.baconeers.common.GamePadSteerDrive;

import static org.baconeers.testbot.JeffChallengeConfiguration.*;

@TeleOp(name = "JeffChallengeOpMode")
public class JeffChallengeOpMode extends BaconOpMode {
    private JeffChallengeConfiguration config;
    private JeffChallengeDrive drive = new JeffChallengeDrive(this, config);

    @Override
    protected void onInit() {
       config  = newConfig(hardwareMap, telemetry);
    }

    @Override
    protected void activeLoop() throws InterruptedException {
        drive.update();
    }
}
