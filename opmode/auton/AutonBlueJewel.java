package org.firstinspires.ftc.teamcode.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.HardwareMain;
import org.firstinspires.ftc.teamcode.util.VisionManager;

/**
 * AutonBlueJewel is a class containing the following autonomous routine for the BLUE alliance:
 * <ol>
 *   <li>Score jewel</li>
 * </ol>
 */
@Autonomous(name="Auton: Blue Jewel", group="Auton")
public class AutonBlueJewel extends LinearOpMode {

    /* Private OpMode members */
    private ElapsedTime     runtime = new ElapsedTime();

    /* Robot hardware */
    private HardwareMain robot = new HardwareMain(this);

    /**
     * Runs the autonomous routine.
     */
    @Override
    public void runOpMode() {

        // Initialize CV
        VisionManager visionManager = new VisionManager();
        visionManager.jewelInit(hardwareMap);

        // Initialize robot
        robot.init(hardwareMap);

        // Wait until we're told to go
        waitForStart();

        // Score jewel
        robot.jewel(visionManager, false);
        sleep(1000);

        // Stop CV
        visionManager.jewelStop();

    }

}
