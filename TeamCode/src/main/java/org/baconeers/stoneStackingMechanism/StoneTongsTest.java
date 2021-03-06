/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.baconeers.stoneStackingMechanism;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="StoneTongsTest", group="Linear Opmode")

public class StoneTongsTest extends LinearOpMode {

    // Declare OpMode members
    private ElapsedTime runtime = new ElapsedTime();
    private Servo gripServo; // Grips the stone
    private CRServo movementServo; // Moves the stone tongs

    private boolean aPrevState = false; // Previous state for the a button
    private boolean bPrevState = false;// Previous state for the b button

    private double servoPos = 0.0;

    private String tongStatus = "Up (deactivated)";

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables
        gripServo = hardwareMap.get(Servo.class, "gripServo");
        movementServo = hardwareMap.get(CRServo.class, "movementServo");

        gripServo.setPosition(servoPos);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Move the stone tongs
            double servoPower = gamepad2.left_stick_x;
            movementServo.setPower(servoPower);

            // Grab/release the stone
            boolean aCurrentState = gamepad2.a;
            boolean bCurrentState = gamepad2.b;

            if (aCurrentState && !aPrevState) {
                servoPos = 0.0;
                gripServo.setPosition(servoPos);
                tongStatus = "Down (activated)";
            } else if (bCurrentState && !bPrevState){
                servoPos = 1.0;
                gripServo.setPosition(servoPos);
                tongStatus = "Up (deactivated)";
            }

            aPrevState = aCurrentState;
            bPrevState = bCurrentState;

            // Show the elapsed game time, servo power, and state of stone tongs.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Servo", "Power: " + servoPower);
            telemetry.addData("Tongs Status", "Stone Tongs: " + tongStatus);
            telemetry.update();
        }
    }
}
