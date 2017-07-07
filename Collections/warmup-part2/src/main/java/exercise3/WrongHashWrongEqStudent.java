package exercise3;

/**
 * Created by Milan.Stojiljkovic on 7/7/2017.
 */
public class WrongHashWrongEqStudent extends Student {


    public WrongHashWrongEqStudent(String firstName, String lastName){
        super(firstName,lastName);
    }

    @Override
    public int hashCode() {
        return super.getFirstName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        WrongHashWrongEqStudent other = (WrongHashWrongEqStudent) obj;

        return super.getFirstName().equals(other.getFirstName());
    }
}
