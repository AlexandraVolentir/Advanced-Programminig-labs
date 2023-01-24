package app;

import com.Controller;

import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class LocaleExplore {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        Properties properties = new Properties();
        String path_en="src/res/Messages.properties";
        String path_ro="src/res/Messages_ro.properties";

        FileReader fr_en = new FileReader(path_en);
        FileReader fr_ro = new FileReader(path_ro);

        properties.load(fr_en);
        Locale currentLocale = Locale.getDefault();
        Locale locale_en = new Locale("en","US");
        Locale locale_ro = new Locale("ro","RO");

        Scanner keyboard = new Scanner(System.in);
        String request="";
        while(true){
            System.out.printf(properties.getProperty("prompt"));
            request=keyboard.nextLine();
            if(request.startsWith("locales")) {
                System.out.println(properties.getProperty("locales"));
                controller.displayLocales();
            }
            else if(request.startsWith("locale.set")){
                if(request.substring(11).equals("en")){
                    fr_en = new FileReader(path_en);
                    properties.load(fr_en);
                    currentLocale = controller.setLocale(locale_en);
                    System.out.println(MessageFormat.format(properties.getProperty("locale.set"), currentLocale.getDisplayCountry()));
                }else if(request.substring(11).equals("ro")){
                    fr_ro = new FileReader(path_ro);
                    properties.load(fr_ro);
                    currentLocale = controller.setLocale(locale_ro);
                    System.out.println(MessageFormat.format(properties.getProperty("locale.set"),currentLocale.getDisplayCountry()));
                }else{
                    System.out.println("Locale unknown");
                }
            }
            else if(request.startsWith("info")){
                if(request.length()>4){
                    String language=request.substring(5);
                    var localeGiven=new Locale(language,language.toUpperCase(Locale.ROOT));
                    System.out.println(MessageFormat.format(properties.getProperty("info"),localeGiven.getDisplayCountry()));
                    controller.getInfo(localeGiven,properties);
                }else{
                    System.out.println(MessageFormat.format(properties.getProperty("info"),currentLocale.getDisplayCountry()));
                    controller.getInfo(currentLocale,properties);
                }
            }
            else{
                System.out.println(properties.getProperty("invalid"));
            }
        }
    }
}
