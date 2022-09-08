import java.time.LocalDate;



public class ToyRobot {

    private String name;

    private LocalDate birthDate;

    private int weight;

    public ToyRobot( String aName, LocalDate birthDate, int weight ){
        name = aName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public int getWeight(){
        return weight;
    }

}
