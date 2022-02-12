package frc.robot;

public class RobotMap {
    // Robot Map is a centralized location at which all the numbers (ports, set speeds, etc) for the Robot can be placed
    // so that it can be replaced easily later if need be. 
    
    // Speed controls
    public static double speedCap = 0.8;
    public static double rotCap = 0.3;
    
    // Robot Dimensions
    public static double wheelDiameter = 7;

    // motor port numbers
    public enum RobotType{
        COMP, PBOT, TOASTER 
    }

    
    
    
    // Left side motor port numbers
    public static int leftMiddleMasterPort = 2;
    
    public static int leftFrontFollower = 3;
    public static int leftBackFollower = 6;
    
    // Right side motor port numbers
    public static int rightMiddleMasterPort = 14;
    
    public static int rightFrontFollower = 5;
    public static int rightBackFollower = 4;
    
    // Falcon drive ports
    public static int leftFront = 4;
    public static int rightFront = 3;
    public static int leftBack = 2;
    public static int rightBack = 1;
    
    // Transversal - 1 neo
    public static final int transversalPort = 423;

    // Cell Stop - 1 neo
    public static final int cellStopPort = 1086;

    // Intake stuff
    // public static int intakePivot = 46;
    // public static int intakeLeftArm = 9;
    // public static int intakeRightArm = 10;
    // public static int lift = 11;
    public static final int extensionInPort = 424;
    public static final int extensionOutPort = 427;
    public static final int intakeMotorPort = 420;
    public static final int beamBreakPort = 429;
    
    // Shooter
    public static final int RIGHT_FLY_PORT = 6;
    public static final int LEFT_FLY_PORT = 3;
    public static final int FLY_ROLLI_ROLL = 0;

    // Dimensions for Vision Calculations
    public static final double BALL_CAMERA_HEIGHT_METERS = 0.75;
    public static final double BALL_HEIGHT_METERS = 0.1;
    public static final double BALL_CAMERA_DEGREES_HORIZ = -25;
    
    public static final double TARGET_CAMERA_HEIGHT_METERS = 0.79;
    public static final double TARGET_HEIGHT_METERS = 2.642;
    public static final double HUB_CAMERA_DEGREES_HORIZ = 15;

    public static final int MAX_NO_TARGET_COUNTER = 9;
    
    public static final int BLUE_BALL_PIPELINE_INDEX = 0;
    public static final int RED_BALL_PIPELINE_INDEX = 1;
    
    //PIDFollowBall params for PIDController
    public static double kP = 1;
    public static double kI = 1;
    public static double kD = 1;
    
    //PIDFlyboi params for PIDController
    public static double FlykP = 1;
    public static double FlykI = 1;
    public static double FlykD = 1;

    // Shooter feedforward
    public static int FlykS = 0;
    public static int FlykV = 0;
    public static int FlykA = 0;

    // Shooter Expected Velocities in ticks
    public static double leftVelocity = 0;
    public static double rightVelocity = 0;
    public static double topVelocity = 0;

    //Transversal and CellStop speeds during shooter sequence
    public static final double transversalSpeed = 0.15;
    public static final double cellStopSpeed = 0.3;

    //Ball Counter
    public static int ballCounter = 1;

    //Shooter Speed and offsets, as used in ShootBall.java
    public static final double speedCheckOffset = -0.5;
    public static final double speedCheckRange = 5;
        
    
    public enum TeamColor{
        RED,BLUE;
    }

    public static final TeamColor teamColor = TeamColor.RED;

    /**
     * @param inches Inches to convert.
     * @return The equivalent distance in ticks (units for Talon Encoders).
     */
    public static double convertToTicks(double inches) {
        return ((2048 / (wheelDiameter * Math.PI)) * inches); // Math.PI
    }

        /**
     * @param inches Inches to convert.
     * @return The equivalent distance in ticks (units for Talon Encoders).
     */
    public static double convertToInches(double ticks) {
        return ((ticks * wheelDiameter * Math.PI ) / 2048); // Math.PI
    }
    

    

    /**
     * 
     * @param value the arbitrary amount inputted
     * @param min value can't be smaller than min
     * @param max value can't be larger tahn max
     * @return returns the cap if the value is too large/small, but will default to value if it does not reach the cap
     */
    public static double cap(double value, double min, double max){
        if(value < min){
            return min;
        } else if (value > max){
            return max;
        }
        return value;
    }
}
