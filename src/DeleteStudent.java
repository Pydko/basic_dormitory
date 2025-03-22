import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DeleteStudent {
    private Saver saver = new Saver();
    Scanner input = new Scanner(System.in);


    public Entities deleteEntitites(List<Entities> entitiesList){

        System.out.println("------------------");
        System.out.println("------DELETE------");
        System.out.println("------------------");

        System.out.println("FOR CONTINUE ENTER('E')");
        String line = input.nextLine();

        while (line.equalsIgnoreCase("e")) {
            for (Entities entities : entitiesList) {
                System.out.println(entities.getFirstName());
                System.out.println(entities.getLastName());
                System.out.println(entities.getSurname());
                System.out.println(entities.getPhoneNumber());
                System.out.println(entities.getCustodianName());
                System.out.println(entities.getCustodianNumber());
                System.out.println(entities.getId());
                System.out.println("---------------------");
                System.out.println(" ");
            }
            System.out.println("WHICH ONE DO YOU WANT TO DELETE?");
            System.out.println("ENTER ID: ");
            int id = input.nextInt();
            input.nextLine();
            boolean found = false;
            Iterator<Entities> iterator = entitiesList.iterator();
            while (iterator.hasNext()) {
                Entities entity = iterator.next();
                if (entity.getId() == id) {
                    iterator.remove();
                    System.out.println("STUDENT WITH ID " + id + " HAS BEEN DELETED.");
                    found = true;
                    saver.entitiesListUpdater(entity);
                    break;
                }
            }

            if (!found) {
                System.out.println("ERROR: NO STUDENT FOUND WITH THAT ID. TRY AGAIN.");
            }

            System.out.println("DO YOU WANT TO DELETE ANOTHER STUDENT? ('E' TO CONTINUE, ANY OTHER KEY TO EXIT)");
            line = input.nextLine();

        }
        return null;
    }

}

