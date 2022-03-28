package exceptions;

/**
 * exception for trying to parse and empty catalog
 */
public class NonexistentInformationToBeSaved extends Exception {
    public NonexistentInformationToBeSaved(String errorMessage){
        super(errorMessage);
    }
}
