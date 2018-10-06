import com.go.jek.constants.CommandType;
import com.go.jek.impl.command.Create;
import com.go.jek.impl.command.Leave;
import com.go.jek.impl.command.Park;
import com.go.jek.impl.pl.ParkingHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LeaveTest {

    ParkingHandler parkingHandler = ParkingHandler.getInstance();

    public void initialise(){

        Create create = new Create();
        List<String> args = new ArrayList<String>();
        create.setCommand(CommandType.CREATE.getValue());
        args.add("4");
        create.setArgs(args);
        create.processCommand();

        Park park = new Park();
        List<String> args1 = new ArrayList<String>();
        args1.add("RN-1");
        args1.add("Blue");
        park.setCommand(CommandType.PARK.getValue());
        park.setArgs(args1);
        park.processCommand();
    }

    @Test
    public void testLeave(){

        initialise();
        Leave leave = new Leave();
        List<String> args = new ArrayList<String>();
        args.add("2");
        leave.setCommand(CommandType.LEAVE.getValue());
        leave.setArgs(args);

        assertEquals(parkingHandler.getOccupiedSlotDetails().size(), 1);
        leave.processCommand();
        assertEquals(parkingHandler.getOccupiedSlotDetails().size(), 1);
        List<String> args1 = new ArrayList<String>();
        args1.add("1");
        leave.setArgs(args1);
        leave.processCommand();
        assertEquals(parkingHandler.getOccupiedSlotDetails().size(), 0);
    }

}
