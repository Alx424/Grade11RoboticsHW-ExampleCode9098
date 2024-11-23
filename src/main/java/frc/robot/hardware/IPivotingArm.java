package frc.robot.hardware;

public interface IPivotingArm {
    public void setArmMotorPower(double pow);

    public void setRollerMotorPower(double pow);

    public double getArmEncoderPosition();

    public void resetArmEncoderPos();
}
