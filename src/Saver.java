import javax.swing.event.ListDataEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Saver {

    private static final String FILE_NAME = "dorm.txt";
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;


    private Entered entered;
    private Id id;
    private Update update;
    private DeleteStudent deleteStudent;
    private Room room;


    public void entitiesSaver(Entities entities) {


        //SAVER THE TXT FILE
        entered = new Entered();
        id = new Id();
        update = new Update();
        deleteStudent = new DeleteStudent();
        room = new Room();


        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            printWriter.println(
                    "NAME: " + entities.getFirstName() + " " + entities.getLastName() + "\n" +
                            "SURNAME: " + entities.getSurname() + "\n" +
                            "PHONE NUMBER: " + entities.getPhoneNumber() + "\n" +
                            "ID: " + entities.getId() + "\n\n" +
                            "CUSTODIAN NAME: " + entities.getCustodianName() + "\n" +
                            "CUSTODIAN PHONE NUMBER: " + entities.getCustodianNumber() + "\n\n" +
                            "PRIVATE NOTES: " + entities.getNotes() + "\n\n\n\n"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void entitiesListUpdater(Entities deletedEntity) {
        List<Entities> updatedList = entitiesGetter();
        updatedList.removeIf(entity -> entity.getId() == deletedEntity.getId()); // Silinen ID'yi kaldır


        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Entities entity : updatedList) {
                writer.println(
                        "NAME: " + entity.getFirstName() + " " + entity.getLastName() + "\n" +
                                "SURNAME: " + entity.getSurname() + "\n" +
                                "PHONE NUMBER: " + entity.getPhoneNumber() + "\n" +
                                "ID: " + entity.getId() + "\n\n" +
                                "CUSTODIAN NAME: " + entity.getCustodianName() + "\n" +
                                "CUSTODIAN PHONE NUMBER: " + entity.getCustodianNumber() + "\n\n" +
                                "PRIVATE NOTES: " + entity.getNotes() + "\n\n\n\n"
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("❌ WENT WRONG");
        }
    }



    public List<Entities> entitiesGetter() {
        List<Entities> entitiesList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            Entities entity = null;

            System.out.println("📂 READING...");

            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                System.out.println("📄 READED: " + line);

                if (line.startsWith("NAME:")) {
                    entity = new Entities();
                    String[] nameParts = line.substring(6).trim().split(" ");
                    entity.setFirstName(nameParts[0]);
                    if (nameParts.length > 1) entity.setLastName(nameParts[1]);
                } else if (line.startsWith("SURNAME:")) {
                    if (entity != null) entity.setSurname(line.substring(9).trim());
                } else if (line.startsWith("PHONE NUMBER:")) {
                    if (entity != null) entity.setPhoneNumber(line.substring(14).trim());
                } else if (line.startsWith("ID:")) {
                    if (entity != null) entity.setId(Integer.parseInt(line.substring(4).trim()));
                } else if (line.startsWith("CUSTODIAN NAME:")) {
                    if (entity != null) entity.setCustodianName(line.substring(16).trim());
                } else if (line.startsWith("CUSTODIAN PHONE NUMBER:")) {
                    if (entity != null) entity.setCustodianNumber(line.substring(24).trim());
                } else if (line.startsWith("PRIVATE NOTES:")) {
                    if (entity != null) {
                        entity.setNotes(line.substring(14).trim());
                        entitiesList.add(entity);
                        System.out.println("✅ Record added: " + entity.getFirstName());
                    }
                }
            }

            System.out.println("🔍 ALL " + entitiesList.size() + " RECORD FOUNDED.");

        } catch (IOException e) {
            System.err.println("❌ WENT WRONG " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("❌ ID conversion error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ UNEXPECTED ERROR: " + e.getMessage());
        }

        return entitiesList;
    }


}
