package exceptions;

/**
 * exception for invalid location in the catalog db
 */
public class InvalidFileOrURLForView extends Exception {
        public InvalidFileOrURLForView(String errorMessage){
            super(errorMessage);
        }
}
