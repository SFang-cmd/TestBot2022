package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class CellStop extends SubsystemBase {
    
    public CANSparkMax cellMotor;

    public CellStop(){
        setSubsystem("CellStop");

        this.cellMotor = new CANSparkMax(RobotMap.cellStopPort, MotorType.kBrushless);
    }

    public void motorForward(double speed){
        cellMotor.set(speed);
    }

    public void motorBack(double speed){
        cellMotor.set(-speed);
    }

    public void stopMotor(){
        cellMotor.stopMotor();
    }

    public double getMotorSpeed(){
        return cellMotor.get();
    }
}