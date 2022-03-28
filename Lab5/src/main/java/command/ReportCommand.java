package command;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import catalog.Catalog;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.*;

import item.BookItem;
import item.Item;
import java.awt.*;
import java.nio.file.Paths;

public class ReportCommand{
        public void execute(Catalog catalog) throws IOException {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
            Template template = cfg.getTemplate("templateFile.ftlh");
            Writer out = new OutputStreamWriter(new FileOutputStream("template.html"));
            try {
                template.process(catalog, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
            File file = new File(System.getProperty("user.dir")+"template.html");
            Desktop desktop = Desktop.getDesktop();
        }
}