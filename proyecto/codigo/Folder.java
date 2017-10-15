import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Class Folder, which is a File, this can contain any other Files/Folders
 * inside and make operations with them: add, search, removeFile. Remember, a
 * file are just data, and the interaction of the user with it is determined
 * only by it's name.
 *
 * @author anietog1, ditrefftzr
 */
public class Folder extends File {

    private final TreeMap<String, File> files;
    private final TreeMap<String, Folder> folders;

    /**
     * Builds a new empty Folder with name <code>name</code>.
     *
     * @param name The name of the folder to be made.
     */
    public Folder(String name) {
        super(name);
        this.files = new TreeMap<>();
        this.folders = new TreeMap<>();
    }

    /**
     * Searchs for a File with name <code>name</code> in this Folder and,
     * returns it if found. Remember the file can be a Folder or just a File.
     *
     * @param name The name of the searched File.
     * @return null if File doesn't exists, the found File otherwise.
     */
    public File get(String name) {
        File ret = this.files.get(name);

        if (ret == null) {
            ret = this.folders.get(name);
        }

        return ret;
    }

    /**
     * Searches for file with name <code>name</code> in the current Folder, and
     * if found returns true, else false.
     *
     * @param name The name of the searched file.
     * @return true if found, else false.
     */
    public boolean contains(String name) {
        return this.get(name) != null;
    }

    /**
     * Adds a File/Folder <code>file</code> if and only if there's no any other
     * File with the same name in this Folder.
     *
     * @param file The file to be added.
     * @return true if added, false otherwise.
     */
    public boolean add(File file) {
        if (!this.contains(file.getName())) {
            if (file instanceof Folder) {
                this.folders.put(file.getName(), (Folder) file);
            } else {
                this.files.put(file.getName(), file);
            }

            return true;
        }

        return false;
    }

    /**
     * Removes the File/Folder with name <code>name</code> from this Folder and
     * returns it.
     *
     * @param name The name of the Folder to be removed.
     * @return null if didn't exist, true if remove succeed.
     */
    public File remove(String name) {
        File rem = this.files.remove(name);

        if (rem == null) {
            rem = this.folders.remove(name);
        }

        return rem;
    }

    /**
     * Searches recursively for a File/Folder with name <code>name</code>, and
     * prints its location for each File found.
     *
     * @param name The name of the searched File.
     */
    public void find(String name) {
        findAux(name, this, this.getName() + "->");
    }

    private void findAux(String name, Folder fold, String path) {
        File local = fold.get(name);

        if (local != null) {
            System.out.println(path + local.toString());
        }

        fold.folders.values().forEach((f) -> {
            findAux(name, f, path + f.getName() + "/");
        });
    }

    /**
     * Returns all the Files in this Folder.
     *
     * @return All the Files/Folders contained in this Folder.
     */
    public LinkedList<File> getAll() {
        LinkedList<File> all = new LinkedList<>();
        all.addAll(this.folders.values());
        all.addAll(this.files.values());

        return all;
    }

    /**
     * Renames a File with name <code>name</code> to name <code>newName</code>,
     * only if a File with name <code>newName</code> doesn't exist.
     *
     * @param name The name of the File to be changed.
     * @param newName The new name the File is going to have.
     * @return true if rename succeed, else false.
     *
     * Reasons would be file with name <code>name</code> doesn't exist, file
     * with name <code>newName</code> already exists.
     */
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
