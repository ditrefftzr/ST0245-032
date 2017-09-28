import java.util.HashMap;
import java.util.Set;

/**
 * @author anietog1, ditrefftzr
 */
public class Folder extends File{
    private final HashMap<String, File> files;
    private final Folder parent;
    
    public Folder(String name, Folder parent){
        super(name, 0);
        this.parent = parent;
        this.files = new HashMap<>();
    }
    
    public void addFile(String name, int size){
        this.files.put(name, new File(name, size));
        this.setSize(this.getSize() + size);
    }
    
    public void makeFolder(String name){
        this.files.put(name, new Folder(name, this));
    }
    
    public void remove(String name){
        File removed = this.files.remove(name);
        this.setSize(this.getSize() - removed.getSize());
    }
    
    public File getFile(String name){
        return this.files.get(name);
    }
    
    public void rename(String name, String newName){
        this.getFile(name).setName(newName);
    }
    
    public Folder getParent(){
        return this.parent;
    }
    
    public Set<String> list(){
        return this.files.keySet();
    }
}
