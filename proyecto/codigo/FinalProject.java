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
public class FinalProject {

    static void showTree(Folder folder, int spaces) {
        folder.getFiles().forEach((file) -> {
            StringBuilder outputLine = new StringBuilder();
            for (int i = 0; i < spaces; ++i) {
                outputLine.append("|");
            }
            outputLine.append(file.toString());
            System.out.println(outputLine);
            if (file instanceof Folder) {
                showTree((Folder) file, spaces + 1);
            }
        });
    }

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
                    if (sc.hasNextInt()) {
                        size = sc.nextInt();
                        try {
                            if (home.addFile(new File(name, size)) != null) {
                                System.out.println("File with name " + name + " already exists.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else{
                        if(home.addFile(new File(name)) != null){
                            System.out.println("File with name " + name + " already exists.");
                        }
                    }
                    break;
                case "mkdir":
                    name = sc.next();
                    if (home.addFile(new Folder(name, home)) != null) {
                        System.out.println("File with name " + name + " already exists.");
                    }
                    break;
                case "rm":
                    name = sc.next();
                    if (home.removeFile(name) != null) {
                        System.out.println("File with name: " + name + " removed.");
                    } else {
                        System.out.println("File with name: " + name + " not found.");
                    }
                    break;
                case "ls":
                    Collection<File> files = home.getFiles();
                    files.forEach((file) -> {
                        System.out.println(file.toString());
                    });

                    break;
                case "tree":
                    System.out.println(home.toString());
                    showTree(home, 1);
                    break;
                case "see":
                    name = sc.next();
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
                    break;
                default:
                    System.out.println(op + ": command not found.");
                    break;
            }
        }
    }
}
