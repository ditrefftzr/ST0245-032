import java.util.*;

/**
 * Testing functionalities of the directories data structure.
 * touch - make a file 
 * mkdir - make a folder
 * cd - move to another folder inside the current one // use '..' to return to the parent
 * rm - removeFile a file 
 * ls - list the elements in the current folder
 * see - shows the properties of the desired file // use '.' for the current folder 
 * tree - makes a deep tree-like view from the current folder 'til the last one.
 *
 * @author anietog1, ditrefftzr
 */
public class FinalProjectTest {
    protected static Folder home;
    
    private static void cd(String to) {
        if (!to.equals("..")) {
            File file = home.getFile(to);
            if (file instanceof Folder) {
                home = (Folder) file;
            } else {
                System.out.println("File: " + to + " is not a folder.");
            }
        } else {
            Folder parent = home.getParent();
            if (parent == null) {
                System.out.println("There are no more parent folders.");
            } else {
                home = parent;
            }
        }
    }
    
    private static void touch(String name, long size){
        try {
            if (home.addFile(new File(name, size)) != null) {
                System.out.println("File with name " + name + " already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void touch(String name){
        if (home.addFile(new File(name)) != null) {
            System.out.println("File with name " + name + " already exists.");
        }
    }
    
    private static void mkdir(String name){
        if (home.addFile(new Folder(name, home)) != null) {
            System.out.println("File with name " + name + " already exists.");
        }
    }
    
    private static void rm(String name){
        if (home.removeFile(name) != null) {
            System.out.println("File with name: " + name + " removed.");
        } else {
            System.out.println("File with name: " + name + " not found.");
        }
    }
    
    static void see(String name){
        File file;
        if (!name.equals(".")) {
            file = home.getFile(name);
        } else {
            file = home;
        }

        if (file != null) {
            System.out.println(file.toString());
        } else {
            System.out.println("File with name: " + name + " doesn't exists.");
        }
    }
    
    private static void tree(Folder folder, int spaces) {
        folder.getFiles().forEach((file) -> {
            StringBuilder outputLine = new StringBuilder();
            for (int i = 0; i < spaces - 1; ++i) {
                outputLine.append(" ");
            }
            outputLine.append("|");
            outputLine.append(file.toString());
            System.out.println(outputLine);
            if (file instanceof Folder) {
                tree((Folder) file, spaces + 1);
            }
        });
    }
    
    static void ls(){
        Collection<File> files = home.getFiles();
        files.forEach((file) -> {
            System.out.println(file.toString());
        });
    }
    
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        String op;
        while (!(op = sc.next()).equals("exit")) {
            String name;
            int size;
            switch (op) {
                case "cd":
                    name = sc.next();
                    cd(name);
                    break;
                case "touch":
                    name = sc.next();
                    if (sc.hasNextInt()) {
                        size = sc.nextInt();
                        touch(name, size);
                    }else{
                        touch(name);
                    }
                    break;
                case "mkdir":
                    name = sc.next();
                    mkdir(name);
                    break;
                case "rm":
                    name = sc.next();
                    rm(name);
                    break;
                case "ls":
                    ls();
                    break;
                case "tree":
                    System.out.println(home.toString());
                    tree(home, 1);
                    break;
                case "see":
                    name = sc.next();
                    see(name);
                    break;
                default:
                    System.out.println(op + ": command not found.");
                    break;
            }
        }
    }
}
