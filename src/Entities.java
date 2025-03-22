import java.time.LocalDate;
import java.util.Date;

public class Entities {

    private String firstName;
    private String lastName;
    private String surname;
    private String phoneNumber;
    private Integer id;
    private String notes;

    private LocalDate inDate;
    private LocalDate outDate;


    private String custodianName;
    private String custodianNumber;


    public Entities(){
    }
    public Entities(String firstName,String lastName,String surname,String phoneNumber,String custodianName,String custodianNumber,Integer id,String notes,LocalDate inDate,LocalDate outDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname =surname;
        this.id = id;
        this.custodianName = custodianName;
        this.custodianNumber = custodianNumber;
        this.notes = notes;
        this.inDate = inDate;
        this.outDate = outDate;
    }

    //first name get-set
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    //last name get-set
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    //surname get-set
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    //phone number get-set
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    //custodian get-set
    public String getCustodianName(){
        return custodianName;
    }
    public void setCustodianName(String custodianName){
        this.custodianName = custodianName;
    }

    public String getCustodianNumber(){
        return custodianNumber;
    }
    public void setCustodianNumber(String custodianNumber){
        this.custodianNumber = custodianNumber;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }

    public LocalDate getInDate(){
        return inDate;
    }
    public void setInDate(LocalDate inDate){
        this.inDate = inDate;
    }

    public LocalDate getOutDate(){
        return outDate;
    }
    public void setOutDate(LocalDate outDate){
        this.outDate = outDate;
    }


}
