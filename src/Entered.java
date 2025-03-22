import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entered implements IEntered {

    Scanner input = new Scanner(System.in);
    List<Entities> entitiesList = new ArrayList<>();
    Id id = new Id();
    Saver saver = new Saver();

    @Override
    public Entities registerHuman() {


        System.out.println("-------------------------------");
        System.out.println("--------REGISTER SYSTEM--------");
        System.out.println("-------------------------------");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("DO YOU WANT TO REGİSTER?('Y' FOR ENTER)/('PRESS ANY KEY FOR QUIT')");
        String asker = input.nextLine();

        while (asker.equalsIgnoreCase("y")) {
            Entities entities = new Entities();
            System.out.println("ENTER THE STAYERS FİRST NAME:");
            String firstName = input.nextLine();

            System.out.println("ENTER THE STAYERS LAST NAME:");
            String lastName = input.nextLine();
            if (lastName.isEmpty()) {
                entities.setLastName(null);
            }
            System.out.println("ENTER THE STAYERS SURNAME:");
            String surname = input.nextLine();

            System.out.println("ENTER THE STAYERS PHONE NUMBER:");
            String phoneNum = input.nextLine();

            if (phoneNum.length() != 10) {
                JOptionPane.showInputDialog(null,"MUST BE 10 DIGIT TRY AGAIN");
                continue;
            }


            System.out.println("ENTER THE STAYERS CUSTODIAN NAME:");
            String custodianName = input.nextLine();
            if (custodianName.isEmpty()) {
                JOptionPane.showInputDialog(null,"THAT CAN NOT BE NULL TRY AGAIN");
                continue;
            }


            System.out.println("ENTER THE STAYERS CUSTODIAN PHONE NUMBER:");
            String custodianNumber = input.nextLine();

            if (custodianNumber.length() != 10) {
                JOptionPane.showInputDialog(null,"MUST BE 10 DIGIT TRY AGAIN");
                continue;
            }


            Id id = new Id();

            entities.setFirstName(firstName);
            entities.setLastName(lastName);
            entities.setSurname(surname);
            entities.setPhoneNumber(phoneNum);
            entities.setCustodianName(custodianName);
            entities.setCustodianNumber(custodianNumber);

            entitiesList.add(entities);

            entities.setId(id.idDefiner(entitiesList));
            saver.entitiesSaver(entities);


            System.out.println("DO YOU WANT TO REGISTER ANOTHER? ('Y' FOR YES) / ('PRESS ANY KEY FOR QUIT')");
            asker = input.nextLine();
        }
        return null;
    }



    @Override
    public List<Entities> getAll() {
        System.out.println("--------------------------------");
        System.out.println("----------ALL ENTITIES----------");
        System.out.println("--------------------------------");

        List<Entities> entitiesList = saver.entitiesGetter();

        for (Entities entities : entitiesList) {
            System.out.println("NAME: " + entities.getFirstName() + " " + entities.getLastName());
            System.out.println("SURNAME: " + entities.getSurname());
            System.out.println("PHONE NUMBER: " + entities.getPhoneNumber());
            System.out.println("CUSTODIAN: " + entities.getCustodianName() + " " + entities.getCustodianNumber());
            System.out.println("ID: " + entities.getId());
            System.out.println("NOTE: " + entities.getNotes());
            System.out.println("----------------");
            System.out.println(" ");
        }
        return entitiesList;
    }
}

