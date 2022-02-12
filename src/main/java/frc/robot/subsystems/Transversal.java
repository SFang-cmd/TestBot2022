package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Transversal extends SubsystemBase {
    
    public CANSparkMax transversal;

    public Transversal(){
        setSubsystem("Transversal");

        this.transversal = new CANSparkMax(RobotMap.transversalPort, MotorType.kBrushless);
    }

    public void motorForward(double speed){
        transversal.set(speed);
    }
    
    public void stopMotor(){
        transversal.stopMotor();
    }
    
    public double getSpeed(){
        return transversal.get();
    }
}
