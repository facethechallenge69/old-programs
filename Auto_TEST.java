
package org.firstinspires.ftc.teamcode.oldprograms;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.programs2021.autofunctions;

@TeleOp(name = "Autonomous Test Program", group = "Tutorials")
@Disabled
public class Auto_TEST extends LinearOpMode
{
    private DcMotor motorL_Up;
    private DcMotor motorL_Down;
    private DcMotor motorR_Up;
    private DcMotor motorR_Down;

    private DcMotor ArmMotor_Left;
    private DcMotor ArmMotor_Right;

    private DcMotor motor_bobber;

    NormalizedColorSensor colorSensor1;
    NormalizedColorSensor colorSensor2;

    BNO055IMU imu;

    private Servo grabber_servo;

    org.firstinspires.ftc.teamcode.programs2021.autofunctions auto_functions = new autofunctions();


    //  Telemetry telemetry = new Telemetry();

//hey
    @Override
    public void runOpMode() throws InterruptedException
    {
        //Receiving the necessary hardware for the motors
        motorL_Up = hardwareMap.dcMotor.get("left_motor_up");
        motorL_Down = hardwareMap.dcMotor.get("left_motor_d");
        motorR_Up = hardwareMap.dcMotor.get("right_motor_up");
        motorR_Down = hardwareMap.dcMotor.get("right_motor_d");

        grabber_servo = hardwareMap.servo.get("sg");

        ArmMotor_Left = hardwareMap.dcMotor.get("LaunchMotor_Left");
        ArmMotor_Right = hardwareMap.dcMotor.get("LaunchMotor_Left");

        motor_bobber = hardwareMap.dcMotor.get("am");

        int encoder_tics = 0;
        double encoder_speed = 0;

        //Setting the behavior for the motors to float.
        motorR_Down.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorL_Down.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorR_Up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorL_Up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        auto_functions.Initialize(motorL_Down,
                motorR_Down,
                motorR_Up,
                motorL_Up,
                ArmMotor_Left,
                ArmMotor_Right,
                grabber_servo,
                motor_bobber,
                imu,
                colorSensor1,
                colorSensor2,
                telemetry);

        //Waiting for the user to press start
        waitForStart();

        while (opModeIsActive())
        {
            if (gamepad1.a)
            {
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
            if (gamepad2.dpad_right)
            {
                auto_functions.StrafeRight(1, encoder_tics);
            }
            if (gamepad2.dpad_left)
            {
                auto_functions.StrafeLeft(1, encoder_tics);
            }


            telemetry.addData("encoder distance %d", encoder_tics);
            telemetry.addData("encoder speed %f", encoder_speed);
            telemetry.update();

            idle();
        }
    }

}



