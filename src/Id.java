import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Id{

    public List<Entities> entitiesList;
    protected  Entered entered;
    Scanner input = new Scanner(System.in);


    public Integer idDefiner(List<Entities> entitiesList){


        if (entitiesList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "LIST IS EMPTY");
            return null;
        }



        int id = 1;
        for(int i=0;i<entitiesList.size();i++){
            entitiesList.get(i).setId(id);
            id++;
        }
        return id - 1;
    }

}
