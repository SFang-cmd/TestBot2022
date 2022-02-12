package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class ShootBall extends CommandBase {

    public double lastShooterSpeed;

    public ShootBall(){
        setName("ShootBall");
        addRequirements(Subsystems.flyShootiShoot, Subsystems.cellStop, Subsystems.transversal);
    }

    public void initialize(){
        lastShooterSpeed = 0;
    }
    
    @Override
    public void execute() {
        Subsystems.flyShootiShoot.voltageShootiShoot(RobotMap.leftVelocity, RobotMap.rightVelocity, RobotMap.topVelocity);

        //Starts Transversal and Cellstop after shooter is up to speed
        if (Subsystems.flyShootiShoot.getLeftVelocity() >= RobotMap.leftVelocity - RobotMap.speedCheckRange && Subsystems.flyShootiShoot.getLeftVelocity() <= RobotMap.leftVelocity + RobotMap.speedCheckRange && Subsystems.flyShootiShoot.getTopVelocity() >= RobotMap.topVelocity - RobotMap.speedCheckRange && Subsystems.flyShootiShoot.getTopVelocity() <= RobotMap.topVelocity + RobotMap.speedCheckRange){
            Subsystems.transversal.motorForward(RobotMap.transversalSpeed);
            Subsystems.cellStop.motorForward(RobotMap.cellStopSpeed);
        } else {
            Subsystems.transversal.stopMotor();
            Subsystems.cellStop.stopMotor();
        }

        if (Subsystems.flyShootiShoot.getLeftVelocity() - lastShooterSpeed <= RobotMap.speedCheckOffset){
            RobotMap.ballCounter--;
        }
        lastShooterSpeed = Subsystems.flyShootiShoot.getLeftVelocity();
    }

    @Override
    public boolean isFinished() {
        if (RobotMap.ballCounter == 0){
            return true;
        } else {
            return false;
        }
    }

}
