//Program for Autonomous Functions for the FTC 2018 - 2019 Rover Ruckus Season

//Package for all of the functions and code
package org.firstinspires.ftc.teamcode.oldprograms;

//Importing op mode Functions
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

//Importing AutoFunctions
import org.firstinspires.ftc.teamcode.oldprograms.autofunctions;

//Naming the Program
@Autonomous (name = "BlueZone", group = "Tutorials")
public class BlueZone extends LinearOpMode {

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
    private Servo grootservo;
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

    //Declaring the new auto-functions
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
        grootservo = hardwareMap.servo.get("groot_servo");

        colorSensor = (NormalizedColorSensor) hardwareMap.colorSensor.get("color_sensor");

        colorSensor2 = (NormalizedColorSensor) hardwareMap.colorSensor.get("color_sensor2");

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
        auto_functions.Initialize(motorleftback,
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
                grootservo,
                telemetry);

        //Init position for the Color arm
        auto_functions.UP();

        //Init position for the Groot Servo
        auto_functions.Grab();

        //Waiting for the user to press the start button
        waitForStart();

        //Raise arm to get down from lander
        auto_functions.Raise(1, 13900);
        sleep(100);

        //Strafe Left to keep bronze thing from keeping the plexiglass.
        auto_functions.StrafeLeft(1, 69);
        sleep(100);

        //Backing out to not hit Lander
        auto_functions.DriveForward(1, -560);
        sleep(100);

        //Lower the arm
        auto_functions.Raisewhile(1, 13000);
        sleep(250);

        //Turn Left and face the minerals.
        auto_functions.TurnLeft(0.969, 2700);

        //Drive Forward out of the lander area, and closer to the minerals.
        auto_functions.DriveForward(1, 1700);

        //Turn Left towards wall.
        auto_functions.TurnLeft(0.969,2250);

        //Drive Towards wall.
        auto_functions.DriveForward(1,4750);

        //Turn to face the minerals at a horizontal angle.
        auto_functions.TurnLeft(0.969,1800);

        //Drive Forward to get the color arm along the minerals.
        auto_functions.DriveForward(1,-3969);
        sleep(150);

        //Turn so that the color arm is exactly parallel.
        auto_functions.TurnRight(0.969,1350);
        sleep(150);

        //Drive Backward so that we can sense the first mineral.
        auto_functions.DriveForward(1,569);

        //Bring color arm to Flat Position
        auto_functions.FLAT();

        sleep(100);

        //The whole color mechanism that we use.
        int CurrentPosition = auto_functions.DriveForwardcolor(0.356, -5669);

        //The knock off cube stuff
        auto_functions.knockoffcube();

        //Drive back to current position
        auto_functions.DriveForward(1,-5669-CurrentPosition);

        //Drive closer to the wall
        auto_functions.DriveForward(1,-269);

        //Turn right to face depot.
        auto_functions.TurnRight(0.969,1250);

        //Drive towards the depot.
        auto_functions.DriveForward(1,1750);

        //Release groot
        auto_functions.Release();
        sleep(350);

        //Grab the arm again.
        auto_functions.Grab();

        //Drive Back so that we don't hit the white ball, or whatever there is when coming back.
        auto_functions.DriveForward(1,-4000);

        //Turn
        auto_functions.TurnRight(1,300);

        //Drive into crater.
        auto_functions.DriveForward(1,-6000);
    }
}








