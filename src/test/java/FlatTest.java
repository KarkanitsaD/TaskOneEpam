import Models.*;
import Models.Options.SizeOptions;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class FlatTest {
    private Flat flat;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUpFlat(){
        Iron iron = new Iron(new SizeOptions(10,7,38), 120, 4.1F,300);
        iron.setPower(560);
        Fridge fridge = new Fridge(new SizeOptions(210,75,88), 720F, 217,450);
        fridge.setPower(3200);
        LEDStripLight ledStripLight = new LEDStripLight(new SizeOptions(1,5,100), 16.6F, 0.12F);
        ledStripLight.setPower(120);
        flat = new Flat();
        flat.addElectronicAppliance(iron);
        flat.addElectronicAppliance(fridge);
        flat.addElectronicAppliance(ledStripLight);

        flat.addSocket(new Socket(220));
        flat.addSocket(new Socket(220));
        flat.addSocket(new Socket(220));
        flat.addSocket(new Socket(220));
        flat.addSocket(new Socket(220));
        flat.addSocket(new Socket(220));
        flat.addSocket(new Socket(220));
    }

    @Test
    public void whenConnectApplianceCheckConnection(){
        flat.connectElectronicAppliance(0,5);
        assertEquals(flat.getElectricalAppliance(0).getSocket(),flat.getSocket(5));
    }

    @Test
    public void whenConnectApplianceAndDisconnectCheckConnection(){
        flat.connectElectronicAppliance(2,5);
        flat.disconnectElectronicAppliance(2);
        assertNotEquals(flat.getElectricalAppliance(2).getSocket(),flat.getSocket(5));
    }

    @Test
    public void whenConnectApplianceAndSortCheckConnection(){
        flat.connectElectronicAppliance(2,3);
        flat.sortAppliances();
        assertEquals(flat.getElectricalAppliance(0).getSocket(),flat.getSocket(3));
    }

    @Test
    public void whenConnectApplianceAndTryConnectOther() throws Exception{
        thrown.expect(IllegalStateException.class);
        flat.connectElectronicAppliance(2,5);
        flat.connectElectronicAppliance(1,5);
    }

    @Test
    public void countElectricalAppliance(){
        assertThat(flat.countAppliances(), is(3));
    }

    @Test
    public void whenRemoveSocketCountSocket(){
        flat.removeSocket(4);
        assertThat(flat.countSockets(), is(6));
    }
}
