import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Update implements IUpdate{

    private Entered entered;
    Scanner input = new Scanner(System.in);
    Id id = new Id();
    Saver saver = new Saver();


    @Override
    public Entities updateEntities(List<Entities> entitiesList) {

        System.out.println("-------------------");
        System.out.println("------UPDATE-------");
        System.out.println("-------------------");

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("DO YOU WANT TO UPDATE ENTITIES('Y' FOR ENTER / PRESS ANY KET FOR QUIT)");
        String asker = input.nextLine();

        while(asker.equalsIgnoreCase("y")){

            System.out.println("ENTER AN ID FOR UPDATE");
            Integer id = input.nextInt();
            input.nextLine();

            while(id != null){

                Entities entitiesUpdate = entitiesList.get(id-1);
                System.out.println("PRESS 'E' FOR CHANGE");
                String askerTwo = input.nextLine();

                if(askerTwo.equalsIgnoreCase("e")){

                    System.out.println("WHAT DO YOU WANT TO CHANGE?");
                    System.out.println("'1' press for first name");
                    System.out.println("'2' press for last name");
                    System.out.println("'3' press for surname");
                    System.out.println("'3' press for phone number");
                    System.out.println("'5' press for custodian name");
                    System.out.println("'6' press for custodian number");

                    int choice = input.nextInt();
                    input.nextLine();

                    switch (choice){

                        case 1:
                            System.out.println("ENTER FIRST NAME: "); String firstName = input.nextLine(); entitiesUpdate.setFirstName(firstName); saver.entitiesSaver(entitiesUpdate);
                            break;
                        case 2:
                            System.out.println("ENTER A LAST NAME: "); String lastName = input.nextLine(); entitiesUpdate.setLastName(lastName); saver.entitiesSaver(entitiesUpdate);
                            break;
                        case 3:
                            System.out.println("ENTER A SURNAME: "); String surname = input.nextLine(); entitiesUpdate.setSurname(surname); saver.entitiesSaver(entitiesUpdate);
                            break;
                        case 4:
                            System.out.println("ENTER A PHONE NUMBER: "); String phoneNumber = input.nextLine(); entitiesUpdate.setPhoneNumber(phoneNumber); saver.entitiesSaver(entitiesUpdate);
                            break;
                        case 5:
                            System.out.println("ENTER A CUSTODIAN NAME: "); String custodianName = input.nextLine(); entitiesUpdate.setCustodianName(custodianName); saver.entitiesSaver(entitiesUpdate);
                            break;
                        case 6:
                            System.out.println("ENTER A CUSTODIAN PHONE NUMBER: "); String custodianNumber = input.nextLine(); entitiesUpdate.setCustodianNumber(custodianNumber); saver.entitiesSaver(entitiesUpdate);
                            break;
                        default:
                            JOptionPane.showInputDialog(null,"YOU HAVE TO CHOOSE BETWEEN 1-6");


                    }
                }
                return entitiesList.get(id-1);
            }
        }
        return null;

    }
}
