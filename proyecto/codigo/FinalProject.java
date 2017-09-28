import java.util.Scanner;
import java.util.Set;

/**
 * Testing functionalities of the directories data structure.
 * touch -> make a file
 * mkdir -> make a folder
 * cd -> move to another folder inside the current one // use '..' to return to the parent
 * rm -> remove a file
 * ls -> list the elements in the current folder[need corrections]
 * see -> shows the properties of the desired file // use '.' for the current folder
 * Can add more functionalities -> Need our own libraries.
 * @author anietog1, ditrefftzr
 */
public class FinalProject {

    public static void main(String[] args) {
        Folder home = new Folder("$HOME", null);
        Scanner sc = new Scanner(System.in);
        String op;

        while (!(op = sc.next()).equals("exit")) {
            String name;
            int size;
            switch (op) {
                case "cd":
                    name = sc.next();
                    if (!name.equals("..")) {
                        File file = home.getFile(name);
                        if (file instanceof Folder) {
                            home = (Folder) file;
                        } else {
                            System.out.println("File: " + name + " is not a folder.");
                        }
                    } else {
                        Folder parent = home.getParent();
                        if (parent == null) {
                            System.out.println("You are in $HOME there are no more parent folders.");
                        } else {
                            home = parent;
                        }
                    }
                    break;
                case "touch":
                    name = sc.next();
                    size = sc.nextInt();
                    home.addFile(name, size);
                    break;
                case "mkdir":
                    name = sc.next();
                    home.makeFolder(name);
                    break;
                case "rm":
                    name = sc.next();
                    home.remove(name);
                    break;
                case "ls":
                    Set<String> list = home.list();
                    list.forEach((str) -> {
                        System.out.println(str);
                    });
                    break;
                case "see":
                    name = sc.next();
                    File file;
                    if(!name.equals(".")){
                        file = home.getFile(name);
                    } else {
                        file = home;
                    }
                    
                    if (file != null) {
                        System.out.println(file.toString());
                    } else {
                        System.out.println("File with name: " + name + " doesn't exists.");
                    }
                    break;
                default:
                    System.out.println(op + ": command not found.");
                    break;
            }
        }
    }
}
