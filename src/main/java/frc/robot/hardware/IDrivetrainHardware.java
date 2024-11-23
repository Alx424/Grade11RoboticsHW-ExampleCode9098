package frc.robot.hardware;

public interface IDrivetrainHardware {

    public void setLeftPower(double pow);

    public void setRightPower(double pow);

    public double getLeftEncoderPos();

    public double getRightEncoderPos();

    public void resetEncoderPos();

    public void resetGyro();
}
