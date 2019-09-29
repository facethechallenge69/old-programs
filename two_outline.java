//Program for Autonomous Functions for the FTC 2018 - 2019 Rover Ruckus Season

//Package for all of the functions and code
package org.firstinspires.ftc.teamcode.oldprograms;

//Importing op mode Functions
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//Importing dcmotor and servo Functions
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Importing color sensor Functions
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import android.graphics.Color;

//Importing telemetry Functions
import org.firstinspires.ftc.robotcore.external.Telemetry;

//Importing Clock Functions
import android.os.SystemClock;

//Importing color Functions
import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

//Importing AutoFunctions
import org.firstinspires.ftc.teamcode.oldprograms.autofunctions;

//Naming the Program
<<<<<<< HEAD
/*@Autonomous (name = "Frick the Feds", group = "Tutorials")
=======

@Autonomous (name = "Frick the Feds", group = "Tutorials")
@Disabled
>>>>>>> a1547ba04a87817fa4895575652d42bd7a943e4d
public class two_outline extends LinearOpMode {

    //Declaring the motors and servos and other things
    private DcMotor motorL_Up;
    private DcMotor motorleftback;
    private DcMotor motorrightfront;
    private DcMotor motorrightback;
    private DcMotor armmotorhanging;
    private DcMotor armmotor;
    private DcMotor armmotormold;
    private DcMotor armmotorud;
    private Servo arm;
    private DcMotor motorArmcirc_left;

    NormalizedColorSensor colorSensor;
    NormalizedColorSensor colorSensor2;

    private int field;

    private static final double armRetracted = 0.5;
    private static final double armExtended = 1;

    //Setting variables for the possible places for Autonomous
    private static final int REDCUBE = 201;
    private static final int REDBALL = 202;
    private static final int BLUECUBE = 203;
    private static final int BLUdrEBALL = 204;

    private static final int LEFT = 300;
    private static final int MID = 301;
    private static final int RIGHT = 302;

    private static final int GOLD = 401;
    private static final int SILVER = 402;
    private static final int UNKNOWN = 403;

    //Declaring the new autofunctions
    autofunctions auto_functions = new autofunctions();

    @Override
    public void runOpMode() throws InterruptedException {

        //Receiving the necessary hardware for the motors
        motorL_Up = hardwareMap.dcMotor.get("left_motor_up");
        motorleftback = hardwareMap.dcMotor.get("left_motor_d");
        motorrightfront = hardwareMap.dcMotor.get("right_motor_up");
        motorrightback = hardwareMap.dcMotor.get("right_motor_d");

        armmotormold = hardwareMap.dcMotor.get("arm_claw");
        armmotorud = hardwareMap.dcMotor.get("motor_lift");
        armmotor = hardwareMap.dcMotor.get("arm_arc");
        motorArmcirc_left = hardwareMap.dcMotor.get("arm_arc_left");

        arm = hardwareMap.servo.get("arm_servo");

        colorSensor = (NormalizedColorSensor) hardwareMap.colorSensor.get("color_sensor");
        colorSensor2 = (NormalizedColorSensor) hardwareMap.colorSensor.get("color_sensor");

        //Running Code to Active Encoders for Left Drive Motor
        motorleftback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Running Code to Activate Encoders for Right Drive Motor
        motorrightback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Running Code to Activate Encoders for the armmotors
        armmotorud.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armmotorud.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armmotorud.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotormold.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armmotormold.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armmotormold.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorArmcirc_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArmcirc_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorArmcirc_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Initializing the motors and servos for auto_functions
        /*auto_functions.Initialize(motorleftback,
                motorL_Up,

                motorrightback,
                motorrightfront,
                armmotorud,
                motorArmcirc_left,
                armmotor,
                armmotormold,
                colorSensor,
                colorSensor2,
                arm,
                telemetry);
*/
        //Waiting for the user to press the start button
        waitForStart();

        //AUTONOMOUS STARTS HERE

        //Coming Down from Thing
        auto_functions.Raise(1, 14269);

        //Strafe Left

        auto_functions.StrafeLeft(1,169);

        //Backing out to not hit Lander
        auto_functions.DriveForward(1, -569);

        //Lower the arm
        auto_functions.Raisewhile(1, 14269);

        //Strafe Left
        auto_functions.StrafeLeft(1, 1500);

        //Back Up
        auto_functions.DriveForward(1, -2500);

        //360 Turn Joint5
        auto_functions.TurnRight(1, 8000);

        //Drive Backwards and Knock Off the Cube

        int CurrentPosition = auto_functions.DriveForwardcolor(0.356, -5000);

        auto_functions.knockoffcube();

        auto_functions.DriveForward(1,-5000-CurrentPosition);

        //Strafe Right
        auto_functions.StrafeRight(1, 1500);

        //Turn Right
        auto_functions.TurnRight(1, 2569);

        //Drive Forward
        auto_functions.DriveForward(1, 4169);

        //Lower arm
        auto_functions.ARaise(0.35, -7000);

        //Release Arm
        auto_functions.Grab();

        //Drive Forward
        auto_functions.DriveForward(1, -11069);
    }
}

*/