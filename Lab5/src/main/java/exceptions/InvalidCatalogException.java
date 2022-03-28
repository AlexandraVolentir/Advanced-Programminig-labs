package exceptions;

/**
 * exception for when the catalog is invalid
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String str){
        super(str);
    }
}
