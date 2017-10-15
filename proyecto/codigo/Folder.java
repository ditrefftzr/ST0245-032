import java.util.LinkedList;
import java.util.TreeMap;

public class Folder extends File {

    private final TreeMap<String, File> files;
    private final TreeMap<String, Folder> folders;

    public Folder(String name) {
        super(name);
        this.files = new TreeMap<>();
        this.folders = new TreeMap<>();
    }

    public File get(String name) {
        File ret = this.files.get(name);

        if (ret == null) {
            ret = this.folders.get(name);
        }

        return ret;
    }

    public boolean contains(String name) {
        return this.get(name) != null;
    }

    public boolean add(File file) {
        if (!this.contains(file.getName())) {
            if(file instanceof Folder){
                this.folders.put(file.getName(), (Folder)file);
            }else{
                this.files.put(file.getName(), file);
            }
            
            return true;
        }
        
        return false;
    }

    public File remove(String name) {
        File rem = this.files.remove(name);

        if (rem == null) {
            rem = this.folders.remove(name);
        }

        return rem;
    }

    public void find(String name) {
        findAux(name, this, this.getName() + "/");
    }

    private void findAux(String name, Folder fold, String path) {
        File local = fold.get(name);

        if (local != null) {
            System.out.println(local.toString());
        }

        fold.folders.forEach((String n, Folder f) -> {
            findAux(name, f, path + fold.getName() + "/");
        });
    }

    public LinkedList<File> getAll() {
        LinkedList<File> all = new LinkedList<>();
        all.addAll(this.folders.values());
        all.addAll(this.files.values());

        return all;
    }

    public boolean rename(String name, String newName) {
        if (!this.contains(newName)) {
            File curr = this.remove(name);

            if (curr != null) {
                curr.setName(newName);
                return this.add(curr);//has to be true
            }
        }

        return false;
    }
}
