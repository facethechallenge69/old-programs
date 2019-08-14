package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.autofunctions;

@TeleOp(name = "1/26 Autonomous Test Program", group = "Tutorials")
public class Auto_TEST extends LinearOpMode
{
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


    private Servo ClawServo;

    autofunctions auto_functions = new autofunctions();


    //  Telemetry telemetry = new Telemetry();

//hey
    @Override
    public void runOpMode() throws InterruptedException
    {
        //Receiving the necessary hardware for the motors
        motorL_Up = hardwareMap.dcMotor.get("left_motor_up");
        motorleftback = hardwareMap.dcMotor.get("left_motor_d");
        motorrightfront = hardwareMap.dcMotor.get("right_motor_up");
        motorrightback = hardwareMap.dcMotor.get("right_motor_d");

        armmotormold = hardwareMap.dcMotor.get("arm_claw");
        armmotorud = hardwareMap.dcMotor.get("motor_lift");
        armmotor = hardwareMap.dcMotor.get("arm_arc");

        arm = hardwareMap.servo.get("arm_servo");

        int encoder_tics = 0;
        double encoder_speed = 0;

        //Setting the behavior for the motors to float.
        motorrightback.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorleftback.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorrightfront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorL_Up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        armmotorud.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


/*        auto_functions.Initialize(motorleftback,
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
        //Waiting for the user to press start
        waitForStart();

        while (opModeIsActive())
        {
            if (gamepad1.a)
            {
                encoder_tics += 100;
                sleep(100);
            }
            if (gamepad1.b)
            {
                encoder_speed += 0.1;
                sleep(100);
            }
            if(gamepad1.y)
            {
                encoder_speed -= 0.1;
                sleep(100);
            }
            if (gamepad1.x)
            {
                encoder_tics -= 50;
                sleep(100);
            }
            if (gamepad1.dpad_up)
            {
                auto_functions.DriveForward(encoder_speed, encoder_tics);
            }
            if (gamepad1.dpad_left)
            {
                auto_functions.TurnLeft(encoder_speed, encoder_tics);
            }
            if (gamepad1.dpad_right)
            {
                auto_functions.TurnRight(encoder_speed, encoder_tics);
            }
            if(gamepad1.right_bumper)
            {
                auto_functions.Raise(1,encoder_tics);
            }
            if(gamepad1.left_bumper)
            {
                auto_functions.ARaise(1,encoder_tics);
            }
            if (gamepad2.dpad_right)
            {
                auto_functions.StrafeRight(1, encoder_tics);
            }
            if (gamepad2.dpad_left)
            {
                auto_functions.StrafeLeft(1, encoder_tics);
            }
            if(gamepad2.left_bumper)
            {
                auto_functions.Grab();
            }
            if(gamepad2.right_bumper)
            {
                auto_functions.Release();
            }

            telemetry.addData("encoder distance %d", encoder_tics);
            telemetry.addData("encoder speed %f", encoder_speed);
            telemetry.update();

            idle();
        }
    }

}



