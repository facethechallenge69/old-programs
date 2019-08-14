package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import android.graphics.Color;
import android.os.SystemClock;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class autofunctions
{
    private DcMotor motorL_Up;
    private DcMotor motorleftback;
    private DcMotor motorrightfront;
    private DcMotor motorrightback;
    private DcMotor armmotor;
    private DcMotor armmotorud;
    private DcMotor armmotormold;
    private DcMotor motorArmcirc_left;

//yoyoyoyoyo
    
    private Servo arm;
    private Servo grootservo;

    NormalizedColorSensor colorSensor;
    NormalizedColorSensor colorSensor2;

    Telemetry telemetry;

    public void Initialize(DcMotor motorleftbackIn,
                           DcMotor motorL_UpIn,
                           DcMotor motorrightbackIn,
                           DcMotor motorrightfrontIn,
                           DcMotor armmotorudIn,
                           DcMotor motorArmcirc_leftIn,
                           DcMotor armmotorIn,
                           DcMotor armotormoldIn,
                           NormalizedColorSensor colorSensorIn,
                           NormalizedColorSensor colorSensor2In,
                           Servo armIn,
                           Servo grootservoIn,

                           Telemetry telemetryIn)
    {
        motorleftback = motorleftbackIn;
        motorL_Up = motorL_UpIn;
        motorrightback = motorrightbackIn;
        motorrightfront = motorrightfrontIn;
        armmotor = armmotorIn;
        armmotorud = armmotorudIn;
        motorArmcirc_left = motorArmcirc_leftIn;
        armmotormold = armotormoldIn;
        arm = armIn;
        grootservo = grootservoIn;

        colorSensor = colorSensorIn;
        colorSensor2 = colorSensor2In;
        telemetry = telemetryIn;


    }

    public void DriveForward(double Power, int Distance)
    {
        AllFLOAT();

        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorrightfront.setTargetPosition(Distance);
        motorrightback.setTargetPosition(Distance);
        motorL_Up.setTargetPosition(-Distance);
        motorleftback.setTargetPosition(-Distance);

        motorrightfront.setPower(Power);
        motorrightback.setPower(Power);
        motorL_Up.setPower(-Power);
        motorleftback.setPower(-Power);


        while (motorrightfront.isBusy() && motorrightback.isBusy()&& motorL_Up.isBusy()&& motorleftback.isBusy())
        {
            //Wait until the task is done
        }
        StopDriving();

        motorrightfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public int DriveForwardcolor(double Power, int Distance)
    {
        AllFLOAT();

        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorrightfront.setTargetPosition(Distance);
        motorrightback.setTargetPosition(Distance);
        motorL_Up.setTargetPosition(-Distance);
        motorleftback.setTargetPosition(-Distance);

        motorrightfront.setPower(Power);
        motorrightback.setPower(Power);
        motorL_Up.setPower(-Power);
        motorleftback.setPower(-Power);


        while (motorrightfront.isBusy() && motorrightback.isBusy()&& motorL_Up.isBusy()&& motorleftback.isBusy())
        {
            int got_color = getcubecolor();
            if(got_color==1)
            {
                break;
            }

        }

        StopDriving();

        int CurrentPosition = motorrightfront.getCurrentPosition();

        motorrightfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        return CurrentPosition;
    }

    public void TurnLeft(double Power, int Distance)
    {
        AllFLOAT();

        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorrightfront.setTargetPosition(Distance);
        motorrightback.setTargetPosition(Distance);
        motorL_Up.setTargetPosition(Distance);
        motorleftback.setTargetPosition(Distance);

        motorrightfront.setPower(Power);
        motorrightback.setPower(Power);
        motorL_Up.setPower(Power);
        motorleftback.setPower(Power);

        while (motorrightfront.isBusy() && motorrightback.isBusy()&& motorL_Up.isBusy()&& motorleftback.isBusy())
        {
            //Wait until the task is done
        }

        StopDriving();
    }



    public void TurnRight(double Power, int Distance)
    {
        AllFLOAT();
        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorrightfront.setTargetPosition(-Distance);
        motorrightback.setTargetPosition(-Distance);
        motorL_Up.setTargetPosition(-Distance);
        motorleftback.setTargetPosition(-Distance);

        motorrightfront.setPower(-Power);
        motorrightback.setPower(-Power);
        motorL_Up.setPower(-Power);
        motorleftback.setPower(-Power);

        while (motorrightfront.isBusy() && motorrightback.isBusy()&& motorL_Up.isBusy()&& motorleftback.isBusy())
        {
            //Wait until the task is done
        }

        StopDriving();
    }

    public void StrafeRight(double Power, int Distance)
    {
        AllFLOAT();

        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorrightfront.setTargetPosition(-Distance);
        motorrightback.setTargetPosition(Distance);
        motorL_Up.setTargetPosition(-Distance);
        motorleftback.setTargetPosition(Distance);

        motorrightfront.setPower(-Power);
        motorrightback.setPower(Power);
        motorL_Up.setPower(-Power);
        motorleftback.setPower(Power);

        while (motorrightfront.isBusy() && motorrightback.isBusy()&& motorL_Up.isBusy()&& motorleftback.isBusy())
        {
            //Wait until the task is done
        }

        StopDriving();
    }

    public void StrafeLeft(double Power, int Distance)
    {
        AllFLOAT();

        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorrightfront.setTargetPosition(Distance);
        motorrightback.setTargetPosition(-Distance);
        motorL_Up.setTargetPosition(Distance);
        motorleftback.setTargetPosition(-Distance);

        motorrightfront.setPower(Power);
        motorrightback.setPower(-Power);
        motorL_Up.setPower(Power);
        motorleftback.setPower(-Power);

        while (motorrightfront.isBusy() && motorrightback.isBusy()&& motorL_Up.isBusy()&& motorleftback.isBusy())
        {
            //Wait until the task is done
        }

        StopDriving();
    }

    public void Grab()
    {
        grootservo.setPosition(0);
    }

    public void Release()
    {
        grootservo.setPosition(1);
    }

    public void UP()
    {
        arm.setPosition(1);
    }

    public void FLAT()
    {
        arm.setPosition(0.2969);
    }

    public void DOWN()
    {
        arm.setPosition(0);
    }

    public void ARaise(double Power, int Distance)
    {

        armmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorArmcirc_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorArmcirc_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        armmotor.setTargetPosition(-Distance);
        motorArmcirc_left.setTargetPosition(Distance);


        armmotor.setPower(-Power);
        motorArmcirc_left.setPower(Power);

        while (armmotormold.isBusy()&&motorArmcirc_left.isBusy())
        {

        }

    }

    public void Raise(double Power, int Distance)
    {

        armmotorud.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armmotorud.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        armmotorud.setTargetPosition(-Distance);

        armmotorud.setPower(-Power);

        while (armmotorud.isBusy())
        {
            //Wait
        }

    }

    public void Raisewhile(double Power, int Distance)
    {

        armmotorud.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armmotorud.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        armmotorud.setTargetPosition(Distance);

        armmotorud.setPower(-Power);

    }

    public void StopDriving ()
    {
        motorL_Up.setPower(0);
        motorleftback.setPower(0);
        motorrightfront.setPower(0);
        motorrightback.setPower(0);

    }
    public int getcubecolor ()
    {
        NormalizedRGBA colors = colorSensor.getNormalizedColors();
        NormalizedRGBA colors2 = colorSensor2.getNormalizedColors();



        int color = colors.toColor();
        int color2 = colors2.toColor();

        float max = Math.max(Math.max(Math.max(colors.red, colors.green), colors.blue), colors.alpha);
        colors.red /= max;
        colors.green /= max;
        colors.blue /= max;
        color = colors.toColor();

        float max2 = Math.max(Math.max(Math.max(colors2.red, colors2.green), colors2.blue), colors2.alpha);
        colors2.red /= max2;
        colors2.green /= max2;
        colors2.blue /= max2;
        color2 = colors2.toColor();

        telemetry.addLine("normalized color 18:  ")
                .addData("a", "%d", Color.alpha(color))
                .addData("r", "%d", Color.red(color))
                .addData("g", "%d", Color.green(color))
                .addData("b", "%d", Color.blue(color));

        if (Color.red(color) < 150 && Color.red(color) > 115)
        {
            telemetry.addLine("Got Yellow");
            telemetry.update();
            return 1; // 1 = true
        }

        if (Color.red(color2) < 150 && Color.red(color2) > 115 )
        {
            telemetry.addLine("Got Yellow2");
            telemetry.update();
            return 1; // 1 = true
        }

        telemetry.addLine("nope");
        telemetry.update();
        return 0;  // 0 = false

    }

    public void knockoffcube ()
    {
        DriveForward(1,-500);
        DOWN();
        DriveForward(1,1000);
        UP();
        DriveForward(1,-500);
    }

    public void AllFLOAT ()
    {
        motorrightback.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorleftback.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorrightfront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorL_Up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void AllBREAK ()
    {
        motorrightback.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorleftback.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorrightfront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorL_Up.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void DriveForward_mrf(double Power, int Distance)
    {
        AllFLOAT();

        motorrightfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorrightfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motorrightfront.setTargetPosition(Distance);


        motorrightfront.setPower(Power);



        while (motorrightfront.isBusy())
        {
            //Wait until the task is done
        }
        StopDriving();

        motorrightfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void DriveForward_mLup(double Power, int Distance)
    {
        AllFLOAT();

        motorL_Up.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorL_Up.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motorL_Up.setTargetPosition(Distance);


        motorL_Up.setPower(Power);



        while (motorL_Up.isBusy())
        {
            //Wait until the task is done
        }
        StopDriving();

        motorL_Up.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void DriveForward_mRDown(double Power, int Distance)
    {
        AllFLOAT();

        motorrightback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorrightback.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motorrightback.setTargetPosition(Distance);


        motorrightback.setPower(Power);



        while (motorrightback.isBusy())
        {
            //Wait until the task is done
        }
        StopDriving();

        motorrightback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void DriveForward_mLdown(double Power, int Distance)
    {
        AllFLOAT();

        motorleftback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorleftback.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motorleftback.setTargetPosition(Distance);


        motorleftback.setPower(Power);



        while (motorleftback.isBusy())
        {
            //Wait until the task is done
        }
        StopDriving();

        motorleftback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

}












