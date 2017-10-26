import java.util.LinkedList;
import java.util.TreeSet;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tests {

    static FileStructure files;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Loader loader = new Loader("C:\\Users\\agusn\\Desktop/ejemplito.txt");
        long startTime = System.currentTimeMillis(), endTime;
        files = loader.load();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        LinkedList<File> test = files.getByName("Proyecto");
        list(test);
        //tree("Proyecto/");
        
    }

    static void list(LinkedList<File> list) {
        if (list == null) {
            System.out.println("Empty list.");
        } else {

            list.forEach((File f) -> {
                System.out.println(f.getPath());
            });
        }
    }

    static void list(TreeSet<File> set) {
        if (set == null) {
            System.out.println("Empty set.");
        } else {
            set.forEach((File f) -> {
                System.out.println(f.getPath());
            });
        }
    }

    static void tree(String path) {
        treeAux("|", path);
    }

    static void treeAux(String bars, String path) {
        TreeSet<File> childs = files.getByFolder(path);
        if (childs == null) {
            System.out.println("Folder doesn't exist or is empty.");
        } else {
            childs.forEach((f) -> {
                System.out.println(bars + f.getName());

                if (f instanceof Folder) {
                    treeAux(bars + '|', f.getPath());
                }
            });
        }
    }
}

