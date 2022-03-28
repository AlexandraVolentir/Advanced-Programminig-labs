package exceptions;

public class UnsuccessfulJsonParsing extends Exception {
        public UnsuccessfulJsonParsing(String errorMessage) {
            super("The information from the JSON file couldn't be extracted. FILE name: " + errorMessage);
        }
}
