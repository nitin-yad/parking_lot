import com.go.jek.constants.CommandType;
import com.go.jek.impl.command.Create;
import com.go.jek.impl.command.Park;
import com.go.jek.impl.pl.ParkingHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ParkingTest {

    ParkingHandler parkingHandler = ParkingHandler.getInstance();

    public void initialise(){

        Create create = new Create();
        List<String> args = new ArrayList<String>();
        create.setCommand(CommandType.CREATE.getValue());
        args.add("4");
        create.setArgs(args);
        create.processCommand();
    }

    @Test
    public void testPark(){

        initialise();
        Park park = new Park();
        List<String> args = new ArrayList<String>();
        args.add("RN-1");
        args.add("Blue");
        park.setCommand(CommandType.PARK.getValue());
        park.setArgs(args);

        assertEquals(parkingHandler.getOccupiedSlotDetails().size(), 0);
        park.processCommand();
        assertEquals(parkingHandler.getOccupiedSlotDetails().size(), 1);
    }
}
