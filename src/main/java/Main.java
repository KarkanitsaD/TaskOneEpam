import Models.*;
import Models.Views.FlatView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

    private static Flat flat;

    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("flat.dat")))
        {
            flat =(Flat)ois.readObject();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        FlatView flatView = new FlatView(flat);

        flatView.menu();
    }
}
