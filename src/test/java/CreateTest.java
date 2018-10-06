import com.go.jek.constants.CommandType;
import com.go.jek.impl.command.Create;
import com.go.jek.impl.pl.ParkingHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CreateTest {

    ParkingHandler parkingHandler = ParkingHandler.getInstance();

    @Test
    public void testCreate(){

        Integer slotCount = 4;
        Create create = new Create();
        List<String> args = new ArrayList<String>();
        create.setCommand(CommandType.CREATE.getValue());
        args.add(slotCount+"");
        create.setArgs(args);
        Integer slotCountBeforeCreation = parkingHandler.getParkingCapacity();
        create.processCommand();
        assertEquals(parkingHandler.getParkingCapacity(), Integer.valueOf(slotCountBeforeCreation+slotCount));
    }
}
