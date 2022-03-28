package exceptions;

public class InvalidFileOrURLForView extends Exception {
        public InvalidFileOrURLForView(String errorMessage){
            super(errorMessage);
        }
}
