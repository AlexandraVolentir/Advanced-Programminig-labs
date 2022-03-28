

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ReportCommand{
    public void execute(Catalog catalog, String stringGiven) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        Template template = cfg.getTemplate("test.ftlh");

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("msg", "Today is a beautiful day");

        try (StringWriter out = new StringWriter()) {

            template.process(templateData, out);
            System.out.println(out.getBuffer().toString());
            out.flush();
        }
    }
}


//    public void execute(Catalog catalog, String stringGiven) throws IOException {
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
//        cfg.setDirectoryForTemplateLoading(new File(stringGiven));
//        Template temp = cfg.getTemplate("resources/templateFile.ftlh");
//        Writer out = new OutputStreamWriter(new FileOutputStream("resources/templateFile.html"));
//        try {
//            temp.process(catalog, out);
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//        File u = new File(stringGiven+"resources/templateFile.html");
//        Desktop d = Desktop.getDesktop();
//        d.open(u);
//    }
