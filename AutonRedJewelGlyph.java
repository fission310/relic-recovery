package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.hardware.HardwareMain;
import org.firstinspires.ftc.teamcode.hardware.mecanum.Drivetrain;
import org.firstinspires.ftc.teamcode.util.VisionManager;

/**
 * AutonRedJewelGlyph is a class containing the following autonomous routine for the RED alliance:
 * <ol>
 *   <li>Score jewel</li>
 *   <li>Score glyph</li>
 *   <li>Park in safe zone</li>
 * </ol>
 */
@Autonomous(name="Auton: Red Jewel Glyph", group="Auton")
public class AutonRedJewelGlyph extends LinearOpMode {

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
        robot.drivetrain.encoderInit();

        // Wait until we're told to go
        waitForStart();

        // Score jewel
        robot.jewel(visionManager, true);
        sleep(1000);

        // Stop CV
        visionManager.jewelStop();

        // Score glyph
        robot.scoreGlyph(1, true);

        // Note: can extend arm at end to ensure safe zone park

        sleep(1000);

        telemetry.addData("Path", "Complete");
        telemetry.update();

    }

}
