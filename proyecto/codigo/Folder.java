import java.util.TreeMap;
import java.util.Collection;

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
    private final Folder parent;

    /**
     * Makes a folder with the given name, inside of the given parent, and with
     * an initial size of 0, the size of the Folder is the same as the sum of
     * all the Files inside it.
     *
     * @param name The name of the folder to be made.
     * @param parent The parent Folder of this Folder is the Folder in which
     * this one is created.
     */
    public Folder(String name, Folder parent) {
        super(name);
        this.parent = parent;
        this.files = new TreeMap<>();
    }

    /**
     * Adds a given File to the Folder if and only if it doesn't already exist
     * inside the Folder. It's size is added to the Folder's size.
     *
     * @param file The File to be added.
     * @return null if the File was added, else returns the File that is
     * currently in the Folder.
     */
    public File addFile(File file) {
        File added = this.files.putIfAbsent(file.getName(), file);

        if (added == null && file.getSize() > 0) {
            this.actSizes(+file.getSize());
        }

        return added;
    }

    /**
     * Actualizates the sizes of the current Folder and it's parents until the
     * HOME Folder is reached.
     *
     * @param amount The amount to be actualized.
     */
    private void actSizes(long amount) {
        this.changeSize(amount);

        if (this.parent != null) {
            this.parent.actSizes(amount);
        }
    }

    /**
     * Indicates if the folder contains a file with name <code>name</code>.
     *
     * @param name The name of the file to be searched.
     * @return true if contains, else false.
     */
    public boolean containsFile(String name) {
        return this.files.containsKey(name);
    }

    /**
     * Removes the specified File from the Folder, it's size is substracted from
     * the folder's size.
     *
     * @param name The name of the File to be removed.
     * @return The removed File, null if didn't exist.
     */
    public File removeFile(String name) {
        File removed = this.files.remove(name);

        if (removed != null && removed.getSize() > 0) {
            this.actSizes(-removed.getSize());
        }

        return removed;
    }

    /**
     * Searchs for a File with name <code>name</code> and returns it.
     *
     * @param name The name of the File to be found.
     * @return null if File doesn't exists, else the searched File.
     */
    public File getFile(String name) {
        return this.files.get(name);
    }

    /**
     * Changes the name of the File with name <code>name</code> to
     * <code>newName</code>.
     *
     * @param name The name of the File to be changed.
     * @param newName The new name the File is going to have.
     * @return true if the File exists and there's no other File with newName
     * <code>newName</code>.
     */
    public boolean rename(String name, String newName) {
        //There are no used the methods of the class for optimization, they would
        //have to actualizate the size of this Folder and it's parents
        if (this.files.get(newName) == null) {
            File file = this.files.remove(name);

            if (file != null) {
                file.setName(newName);
                this.files.put(newName, file);
                return true;
            }
        }

        return false;
    }

    /**
     * Moves the file with name <code>name</code> to the folder
     * <code>destiny</code>.
     *
     * @param name The name of the file to be moved.
     * @param destiny The destiny folder in which we want to add the file.
     * @return true if succeeded, false otherwise. Process would no succeed
     * because of moving to a null Folder, moving a non-existing File or a File
     * with the same name as the one tried to move already exists inside the
     * destiny Folder.
     */
    public boolean move(String name, Folder destiny) {
        if (destiny != null && destiny.getFile(name) == null) {
            File file = this.removeFile(name);
            if (file != null) {
                destiny.addFile(file);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the Folder parent of this file. Why? Folders -and files- do
     * always stay inside a folder, by the way, we'll consider the main folder
     * doesn't have a parent, and is the onliest folder without a parent.
     *
     * @return The Folder in which this Folder is contained.
     */
    public Folder getParent() {
        return this.parent;
    }

    /**
     * Returns a Collection of the Files contained in this Folder.
     *
     * @return An iterable Collection of Files.
     */
    public Collection<File> getFiles() {
        return this.files.values();
    }
}
