import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class PrivateNotes {
    Scanner input = new Scanner(System.in);
    private Saver saver = new Saver();


    public void noteAsker(List<Entities> entitiesList){
        System.out.println("---------------------");
        System.out.println("----PRIVATE NOTES----");
        System.out.println("---------------------");

        System.out.println("PRESS '1' FOR ADD NOTES ");
        System.out.println("PRESS '2' FOR DELETE NOTES");
        System.out.println("PRESS '3' FOR SEE ALL NOTES");
        System.out.println("PRESS '4' FOR EXİT");

        int presser = input.nextInt();
        input.nextLine();

        switch (presser){
            case 1: noteAdd(entitiesList);
            break;
            case 2: noteDelete(entitiesList);
            break;
            case 3: noteAll(entitiesList);
            break;
            case 4:
                System.out.println("EXITING...");
                return;
            default:
                System.out.println("SOMETHING WENT WRONG TRY AGAIN");
        }

    }

    public Entities noteAdd(List<Entities> entitiesList){
        System.out.println("---------------------");
        System.out.println("------NOTES ADD------");
        System.out.println("---------------------");

        System.out.println("DO YOU WANT TO ADD PRIVATE NOTE('Y' FOR ENTER/PRESS ANY KET FOR QUIT)");
        String line = input.nextLine();
        while(line.equalsIgnoreCase("y")){

            for (Entities entities : entitiesList){
                System.out.println("FIRST NAME: "+entities.getFirstName());
                System.out.println("LAST NAME: "+entities.getLastName());
                System.out.println("SURNAME: "+entities.getSurname());
                System.out.println("PHONE NUMBER: "+entities.getPhoneNumber());
                System.out.println("CUSTODIAN NAME:"+entities.getCustodianName());
                System.out.println("CUSTODIAN NUMBER: "+entities.getCustodianNumber());
                System.out.println("ID: "+entities.getId());
                System.out.println("---------------------");
                System.out.println(" ");
            }

            System.out.println("ENTER A ID FOR ADD PRIVATE NOT");
            int id = input.nextInt();

            input.nextLine();
            if(entitiesList.get(id-1) != null){
                System.out.println("ENTER NOTE: ");
                String note = input.nextLine();
                entitiesList.get(id-1).setNotes(note);
                saver.entitiesSaver(entitiesList.get(id-1));

            }
            System.out.println("DO YOU WANT TO ADD PRIVATE NOTE('Y' FOR ENTER/PRESS ANY KET FOR QUIT)");
            line = input.nextLine();

            return entitiesList.get(id-1);
        }
        return null;
    }

    public Entities noteDelete(List<Entities> entitiesList){
        System.out.println("---------------------");
        System.out.println("----NOTES DELETE-----");
        System.out.println("---------------------");

        System.out.println("DO YOU WANT TO DELETE PRIVATE NOTE('Y' FOR ENTER/PRESS ANY KET FOR QUIT)");
        String line = input.nextLine();

        while(line.equalsIgnoreCase("y")) {
            for (Entities entities : entitiesList) {
                System.out.println("NAME: "+entities.getFirstName() + " " +entities.getLastName());
                System.out.println("SURNAME: "+entities.getSurname());
                System.out.println("ID: "+entities.getId());
                System.out.println("NOTES: "+entities.getNotes());
                System.out.println("---------------------");
                System.out.println(" ");
            }

            System.out.println("ENTER A ID FOR DELETE NOTES: ");
            int id = input.nextInt();

            if(entitiesList.get(id-1) == null){
                System.out.println("ERROR MESSAGE WE DONT HAVE ANY STAYERS IN THAT ID TRY AGAIN...");
                continue;
            }else {
                entitiesList.get(id - 1).setNotes(null);
            }

            System.out.println("DO YOU WANT TO DELETE PRIVATE NOTE('Y' FOR ENTER/PRESS ANY KET FOR QUIT)");
            line = input.nextLine();

            return entitiesList.get(id-1);
        }
        return null;
    }

    public void noteAll(List<Entities> entitiesList){
        for (Entities entities : entitiesList){
            System.out.println("NAME: "+entities.getFirstName() + " " +entities.getLastName());
            System.out.println("SURNAME: "+entities.getSurname());
            System.out.println("ID: "+entities.getId());
            System.out.println("NOTES: "+entities.getNotes());
            System.out.println("---------------------");
            System.out.println(" ");
        }
    }

}
