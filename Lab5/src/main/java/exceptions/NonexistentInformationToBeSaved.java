package exceptions;

public class NonexistentInformationToBeSaved extends Exception {
    public NonexistentInformationToBeSaved(String errorMessage){
        super(errorMessage);
    }
}
