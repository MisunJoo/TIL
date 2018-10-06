package my.examples.was;


import java.lang.annotation.Annotation;
import java.util.List;

public class ClassLoaderTest05 {
    public static void main(String[] args) throws Exception{
        String baseDir = "~/Documents/Java/miniwas/src/main/java/my/exmaples/was/ClassLoaderTEst05";
        ClassFinder classFinder = new ClassFinder(baseDir);
        List<String> allClass = classFinder.findAllClass();

             for(String className : allClass){

                 Class clazz = Class.forName(className);
                 Annotation annotation = clazz.getAnnotation(WebServlet.class);
                 if(annotation != null){
                     WebServlet webServlet = (WebServlet)annotation;
                     String[] values = webServlet.value();
                 }


            System.out.println(className);
        }
    } // main
}
