import java.util.AbstractCollection;
import java.util.TreeSet;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tests {

    static FileStructure files;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String source = "C:\\Users\\agusn\\Desktop/ejemplito.txt";
        Loader loader = new Loader(source);
        files = loader.load();
    }

    public static void list(AbstractCollection<File> list) {
        if (list == null) {
            System.out.println("Empty list.");
        } else {
            list.forEach((File f) -> {
                System.out.println(f.getPath());
            });
        }
    }

    public static void tree(Folder start) {
        tree(start.getPath());
    }

    static void tree(String path) {
        treeAux("|", path);
    }

    private static void treeAux(String bars, String path) {
        TreeSet<File> childs = files.getByFolder(path);
        if (childs == null) {
            System.out.println("Folder doesn't exist or is empty.");
        } else {
            childs.forEach((File f) -> {
                System.out.println(bars + f.toString());

                if (f instanceof Folder) {
                    treeAux(bars + '|', f.getPath());
                }
            });
        }
    }
}
