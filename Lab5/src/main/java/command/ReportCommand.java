package command;
import java.io.*;

import catalog.Catalog;
import freemarker.template.*;

/**
 * creates an HTML report representing the content of the catalog
 */
public class ReportCommand extends Command{
        public void execute(Catalog catalog) throws IOException {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
            Template template = cfg.getTemplate("template");
            Writer out = new OutputStreamWriter(new FileOutputStream("template.html"));
            try {
                template.process(catalog, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
//            File file = new File(System.getProperty("user.dir")+"templateFile.html");
//            Desktop desktop = Desktop.getDesktop();
//            d.open(u);
        }
}