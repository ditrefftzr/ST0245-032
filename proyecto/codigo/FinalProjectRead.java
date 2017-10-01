import java.io.*;

/**
 * @author anietog1, ditrefftzr
 */
public class FinalProjectRead {
    public static void main(String[] args) throws FileNotFoundException, Exception{
        java.io.File start = new java.io.File("./../../");
        FinalProjectTest.home = new Folder(start.getName(), null);
        loadFilesFromTo(start, FinalProjectTest.home);
        System.out.println("Load DONE");
        FinalProjectTest.menu();
    }
    
    public static void loadFilesFromTo(java.io.File from, Folder to) throws Exception{
        java.io.File[] contained = from.listFiles();
        
        for(int i=0; i < contained.length; ++i){
            java.io.File current = contained[i];
            if(current.isDirectory()){
                Folder nf = new Folder(current.getName(), to);
                to.addFile(nf);
                loadFilesFromTo(current, nf);
            }else{
                to.addFile(new File(current.getName(), current.length()));
            }
        }
    }
}
