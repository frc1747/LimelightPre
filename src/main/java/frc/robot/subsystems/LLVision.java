package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LLVision extends SubsystemBase {
    NetworkTable table;
    NetworkTableEntry xOffset;
    NetworkTableEntry yOffset;
    NetworkTableEntry area;

    /** Creates a new ExampleSubsystem. */
    public LLVision() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        xOffset = table.getEntry("tx");
        yOffset = table.getEntry("ty");
        area = table.getEntry("ta");
    }

    /**
     * Default value is 361.0
     * @return  horizontal offset in degrees 
     * from target
     */
    public double getXOffset() {
        return xOffset.getDouble(361.0);
    }

    /**
     * Default value is 361.0
     * @return  vertical offset in degrees 
     * from target
     */
    public double getYOffset() {
        return yOffset.getDouble(361.0);
    }

    /**
     * Default value is 101.0
     * @return  area of target in field of 
     * view by percentage
     */
    public double getArea() {
        return area.getDouble(101.0);
    }
    
    /**
    * Example command factory method.
    *
    * @return a command
    */
    public Command exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
        () -> {
          /* one-time action goes here */
        });
    }

    /**
    * An example method querying a boolean state of the subsystem (for example, a digital sensor).
    *
    * @return value of some boolean subsystem state, such as a digital sensor.
    */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
        System.out.println(xOffset.getDouble(361.0));
        System.out.println(yOffset.getDouble(362.0));
    }

    public void print(double number) {
        System.out.println(number);
    }

    public void print(int number) {
        System.out.println(number);
    }

    public void print(String number) {
        System.out.println(number);
    }

    public void print(Object object) {
        System.out.
        println(object);
    }
}
