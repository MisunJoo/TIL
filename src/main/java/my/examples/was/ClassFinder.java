package my.examples.was;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassFinder {
    private String baseDir;
    public ClassFinder(String baseDir){
        this.baseDir = baseDir;
    }
    public List<String> findAllClass(){
        List<String> list = new ArrayList<>();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> resources =
                    contextClassLoader.getResources("");
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                File root = new File(url.getPath());
                if (root.isDirectory()) {
                    scanDirectory(list, root);
                } else {
                    addClassName(list, root);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    private void scanDirectory(List<String> list, File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                scanDirectory(list, f);
            }else{
                addClassName(list, f);
            }
        }
    }
    private void addClassName(List<String> list , File file){
//        System.out.println(file.getPath());
        String className = getClassName(file.getPath());
        list.add(className);
    }
    private String getClassName(String path){
        path = path.substring(baseDir.length());
        path = path.replace('/', '.');
        int lastIndex = path.lastIndexOf('.');
        path = path.substring(0, lastIndex);
        return path;
    }
}
