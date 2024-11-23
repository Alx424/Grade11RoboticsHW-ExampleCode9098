package frc.robot.hardware;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class pivotingArm implements IPivotingArm {
    private CANSparkMax arm;
    private CANSparkMax roller;
    private RelativeEncoder encoder;

    public pivotingArm() {
        arm = new CANSparkMax(RobotMap.ARM, MotorType.kBrushless);
        roller = new CANSparkMax(RobotMap.ROLLER, MotorType.kBrushless);
        encoder = arm.getEncoder();
        arm.enableVoltageCompensation(12);
    }

    @Override
    public void setArmMotorPower(double pow) {
        arm.set(pow);
    }

    @Override
    public void setRollerMotorPower(double pow) {
        roller.set(pow);
    }

    @Override
    public double getArmEncoderPosition() {
        return encoder.getPosition();
    }

    @Override
    public void resetArmEncoderPos() {
        encoder.setPosition(0.);
    }
}
