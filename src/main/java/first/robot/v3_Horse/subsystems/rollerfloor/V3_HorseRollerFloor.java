package first.robot.v3_Horse.subsystems.rollerfloor;

import org.wpilib.command2.SubsystemBase;
import org.wpilib.units.VoltageUnit;

import static org.wpilib.units.Units.Volts;

import edu.wpi.team190.gompeilib.core.utility.Setpoint;
import edu.wpi.team190.gompeilib.subsystems.generic.roller.GenericRoller;
import edu.wpi.team190.gompeilib.subsystems.generic.roller.GenericRollerIO;
import first.robot.v3_Horse.subsystems.rollerfloor.V3_HorseRollerFloorConstants.RollerFloorState;
import lombok.Getter;

public class V3_HorseRollerFloor extends SubsystemBase {

    private GenericRoller rollerFloor;
    @Getter private RollerFloorState rollerFloorGoal;

    private final Setpoint<VoltageUnit> rollerFloorSetpoint, rollerFloorOverrideSetpoint;

    private final Setpoint<VoltageUnit> rollerFloorStopSetpoint;

    public V3_HorseRollerFloor(GenericRollerIO rollerFloorIO) {
        rollerFloorGoal = RollerFloorState.STOP;

        rollerFloorSetpoint = 
        new Setpoint<>(V3_HorseRollerFloorConstants.ROLLER_FLOOR_RUN_VOLTAGE, V3_HorseRollerFloorConstants.ROLLER_FLOOR_CONSTANTS.voltageOffsetStep, Volts.of(-12), Volts.of(12));

        rollerFloorOverrideSetpoint = 
        new Setpoint<>(V3_HorseRollerFloorConstants.ROLLER_FLOOR_OVERRIDE_VOLTAGE, V3_HorseRollerFloorConstants.ROLLER_FLOOR_CONSTANTS.voltageOffsetStep, Volts.of(-12), Volts.of(12));

        rollerFloorStopSetpoint = 
                new Setpoint<>(Volts.of(0), V3_HorseRollerFloorConstants.ROLLER_FLOOR_CONSTANTS.voltageOffsetStep, Volts.of(0), Volts.of(0));


        rollerFloor = new GenericRoller(rollerFloorIO, this, V3_HorseRollerFloorConstants.ROLLER_FLOOR_CONSTANTS, "Floor", rollerFloorSetpoint);
    }
    
}
