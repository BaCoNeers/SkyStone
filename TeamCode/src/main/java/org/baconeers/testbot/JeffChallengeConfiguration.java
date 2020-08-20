package org.baconeers.testbot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.baconeers.common.RobotConfiguration;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * It is assumed that there is a configuration that is currently activated on the robot controller
 * (run menu / Configure Robot ) with the same name as this class.
 * It is also assumed that the device names in the 'init()' method below are the same as the devices
 * named on the activated configuration on the robot.
 */
public class JeffChallengeConfiguration extends RobotConfiguration {
       // Left motors
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public DcMotor testMotor;

    /**
     * Assign your class instance variables to the saved device names in the hardware map
     *
     * @param hardwareMap
     * @param telemetry
     */
    @Override
    protected void init(HardwareMap hardwareMap, Telemetry telemetry) {

        setTelemetry(telemetry);

        leftMotor = (DcMotor) getHardwareOn("LeftMotor", hardwareMap.dcMotor);
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        rightMotor = (DcMotor) getHardwareOn("RightMotor", hardwareMap.dcMotor);
    }


    /**
     * Factory method for this class
     *
     * @param hardwareMap
     * @param telemetry
     * @return
     */
    public static JeffChallengeConfiguration newConfig(HardwareMap hardwareMap, Telemetry telemetry) {

        JeffChallengeConfiguration config = new JeffChallengeConfiguration();
        config.init(hardwareMap, telemetry);
        return config;
    }


}
