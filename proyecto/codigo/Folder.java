import java.util.*;

/**
 *
 * @author anietog1, ditrefftzr
 */
public class Folder extends File{
    private HashMap<String, File> files;
    
    public Folder(String name){
        super(name, 0);
        this.files = new HashMap<>();
    }
    
    public void addFile(String name, int size){
        this.files.put(name, new File(name, size));
    }
    
    public void makeFolder(String name){
        this.files.put(name, new Folder(name));
    }
    
    public void remove(String name){
        this.files.remove(name);
    }
    
    public File getFile(String name){
        return this.files.get(name);
    }
    
    public void rename(String name, String newName){
        this.getFile(name).setName(newName);
    }
}
