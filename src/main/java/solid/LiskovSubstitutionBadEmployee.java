package solid;

/*
LS - > Objects of a superclass should be replaceable with objects of its subclasses without breaking the system.
The principle ensures that the behavior of the superclass is preserved in its subclasses.
 */
public class LiskovSubstitutionBadEmployee {

    public double getSalary() {
        return 2000.0;
    }

}

class ExternalEmployee extends LiskovSubstitutionBadEmployee {

    @Override
    public double getSalary() {
        throw new UnsupportedOperationException("External employee does not have a salary");
    }
}