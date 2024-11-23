package frc.robot.hardware;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.RobotMap;

public class drivetrainHardware implements IDrivetrainHardware {
    private CANSparkMax left1;
    private CANSparkMax left2;
    private CANSparkMax right1;
    private CANSparkMax right2;
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;
    private AHRS gyro;


    public void DrivetrainHardware() {
        left1 = new CANSparkMax(RobotMap.LEFT_1, MotorType.kBrushless);
        left2 = new CANSparkMax(RobotMap.LEFT_2, MotorType.kBrushless);
        right1 = new CANSparkMax(RobotMap.RIGHT_1, MotorType.kBrushless);
        right2 = new CANSparkMax(RobotMap.RIGHT_2, MotorType.kBrushless);
        leftEncoder = left2.getEncoder();
        rightEncoder = right2.getEncoder();
        gyro = new AHRS(SPI.Port.kMXP);
        resetGyro();
    }

    @Override
    public void setLeftPower(double pow) {
        left1.set(pow);
        left2.set(pow);
    }

    @Override
    public void setRightPower(double pow) {
        right1.set(pow);
        right2.set(pow);
    }

    @Override
    public double getLeftEncoderPos() {
        return leftEncoder.getPosition();
    }

    @Override
    public double getRightEncoderPos() {
        return rightEncoder.getPosition();
    }

    @Override
    public void resetEncoderPos() {
        leftEncoder.setPosition(0.);
        rightEncoder.setPosition(0.);
        System.out.println("RESET ENCODERS");
    }

    @Override
    public void resetGyro() {
        gyro.zeroYaw();
    }
}
