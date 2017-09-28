import java.util.Scanner;

/**
 *
 * @author anietog1, ditrefftzr
 */
public class FinalProject {
    
    public static void main(String[] args){
        Folder home = new Folder("$HOME");
        Folder current = home;
        Scanner sc = new Scanner(System.in);
        String op;
        
        while(!(op = sc.next()).equals("exit")){
            String name;
            int size;
            switch (op) {
                case "cd":
                    name = sc.next();
                    File file = current.getFile(name);
                    if(file instanceof Folder)
                        current = (Folder)file;
                    break;
                case "touch":
                    name = sc.next();
                    size = sc.nextInt();
                    current.addFile(name, size);
                    break;
                case "mkdir":
                    name = sc.next();
                    current.makeFolder(name);
                    break;
                case "rm":
                    name = sc.next();
                    current.remove(name);
                    break;
                case "ls":
                    System.out.println("Falta por implementar");
                    break;
                case "see":
                    name = sc.next();
                    System.out.println(current.getFile(name).toString());
                    break;
                default:
                    System.out.println(op + ": command not found.");
                    break;
            }
        }
    }
}
