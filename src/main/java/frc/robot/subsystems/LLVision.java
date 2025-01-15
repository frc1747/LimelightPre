
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LLVision extends SubsystemBase {
    Limelight[] limelights;

    class Limelight {
        String name;
        NetworkTable table;
        NetworkTableEntry xOffsetEntry;
        NetworkTableEntry yOffsetEntry;
        NetworkTableEntry areaEntry;

        public Limelight(String name) {
            this.name = name;
            table = NetworkTableInstance.getDefault().getTable(name);
            xOffsetEntry = table.getEntry("tx");
            yOffsetEntry = table.getEntry("ty");
            areaEntry = table.getEntry("ta");
        }

        public String getName() {
            return name;
        }

        public double getXOffset() {
            return xOffsetEntry.getDouble(361.0);
        }

        public double getYOffset() {
            return yOffsetEntry.getDouble(69.0);
        }

        public double getAreaOffset() {
            return areaEntry.getDouble(101.0);
        }
    }


    /** Creates a new ExampleSubsystem. */
    public LLVision(String... names) {
        limelights = new Limelight[names.length];
        for (int i = 0; i < names.length; i++) {
          limelights[i] = new Limelight(names[i]);                                                                                                                                                              
        }
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
        for (Limelight limelight : limelights) {
            System.out.printf("Name: %s \n", limelight.getName());
            System.out.println(limelight.getXOffset());
            System.out.println(limelight.getYOffset());
            System.out.println(limelight.getAreaOffset());
        }
              
    }
}
