package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.HardwareMain;
import org.firstinspires.ftc.teamcode.hardware.mecanum.Drivetrain;

/**
 * AutonBlueGlyph is a class containing the following autonomous routine for the BLUE alliance:
 * <ol>
 *   <li>Score glyph into cryptobox</li>
 *   <li>Park in safe zone</li>
 * </ol>
 */
@Autonomous(name="Auton: Blue Glyph", group="Auton")
public class AutonBlueGlyph extends LinearOpMode {

    /* Robot hardware */
    private HardwareMain robot = new HardwareMain(this);

    /**
     * Runs the autonomous routine.
     */
    @Override
    public void runOpMode() {

        // Initialize robot
        robot.init(hardwareMap);
        robot.drivetrain.encoderInit();

        // Wait until we're told to go
        waitForStart();

        robot.arm.armUp();
        robot.scoreGlyph(1, false);

        robot.drivetrain.turn(Drivetrain.TURN_SPEED, 40, 2.0);
        robot.acquirer.setIntakePower(1);
        robot.drivetrain.driveToPos(Drivetrain.DRIVE_SPEED * 2, 55, 55, 5.0);
        sleep(2000);

        robot.acquirer.setIntakePower(0);

        robot.drivetrain.driveToPos(Drivetrain.DRIVE_SPEED * 2, -50, -50, 5.0);
        robot.drivetrain.turn(Drivetrain.TURN_SPEED, -40, 2.0);
        // score glyph
        robot.flipper.flipScore();
        robot.drivetrain.driveToPos(Drivetrain.DRIVE_SPEED, -6, -6, 2.0);
        robot.drivetrain.driveToPos(Drivetrain.DRIVE_SPEED, 6, 6, 2.0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

}
