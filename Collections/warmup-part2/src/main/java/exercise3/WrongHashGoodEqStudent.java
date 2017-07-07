package exercise3;

/**
 * Created by Milan.Stojiljkovic on 7/7/2017.
 */
public class WrongHashGoodEqStudent extends Student {

    public WrongHashGoodEqStudent(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public int hashCode() {
        return super.getFirstName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        WrongHashGoodEqStudent other = (WrongHashGoodEqStudent) obj;

        if (this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName()))
            return true;

        return false;
    }
}
