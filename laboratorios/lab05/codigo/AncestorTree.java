/**
 * Class which allows to build a family tree.
 *
 * @author anietog1, ditrefftzr
 */
public class AncestorTree {

    public static class Person {

        Person mother, father;
        String name;

        Person(String name) {
            this.name = name;
        }
    }

    private final Person root;

    /**
     * Builds a new AncestorTree for a person with the given name.
     *
     * @param name The name of the person this Tree is about.
     */
    public AncestorTree(String name) {
        root = new Person(name);
    }

    /**
     * Searches for a person with the given name in this tree, and returns it if
     * found.
     *
     * @param name The name of the person searched.
     * @return null if not found, else the person in this tree with the given
     * name.
     */
    public Person get(String name) {
        return get(root, name);
    }

    private Person get(Person curr, String name) {
        if (curr == null) {
            return null;
        }

        if (curr.name.equals(name)) {
            return curr;
        }

        Person person = get(curr.father, name);

        if (person == null) {
            person = get(curr.mother, name);
        }

        return person;
    }

    /**
     * Calculates the maximum height of this family tree, it is the same as the
     * max grade of consanguinity found.
     *
     * @return The max height of this family tree.
     */
    public int height() {
        return height(root);
    }

    private int height(Person curr) {
        if (curr == null) {
            return 0;
        }

        return Math.max(height(curr.father) + 1, height(curr.mother) + 1);
    }

    /**
     * Prints this tree recursively with format (person(mother)(father)).
     */
    public void print() {
        printAux(root);
        System.out.println();
    }

    private void printAux(Person curr) {
        if (curr == null) {
            return;
        }

        System.out.print('(' + curr.name);
        printAux(curr.mother);
        printAux(curr.father);
        System.out.print(')');
    }

    /**
     * Counts the number of people in this tree.
     *
     * @return The number of people in the family.
     */
    public int size() {
        return size(root);
    }

    private int size(Person curr) {
        if (curr == null) {
            return 0;
        }

        return size(curr.father) + size(curr.mother) + 1;
    }

    /**
     * Returns the maternal grandmother's name of the person in this tree with
     * the given name.
     *
     * @param name The name of the person we want to know it's grandmother's
     * name.
     * @return Grandmother's name of the person with the given name in this
     * tree. Null if not found the person | the mother | the grandmother.
     */
    public String getGrandMothersName(String name) {
        Person person = this.get(name);
        if (person != null) {
            if (person.mother != null) {
                person = person.mother;//Ahora vamos en la mamá
                if (person.mother != null) {
                    person = person.mother;//Ahora en la abuela materna
                    return person.name;
                }
            }
        }

        return null;
    }

    /**
     * Tests the Class.
     *
     * @param args Nothing.
     */
    public static void main(String[] args) {
        //ARBOL DE AGUSTIN
        AncestorTree nietogarcia = new AncestorTree("agustin");
        nietogarcia.get("agustin").mother = new Person("doris");
        nietogarcia.get("agustin").father = new Person("hernan");

        nietogarcia.get("doris").mother = new Person("nery");
        nietogarcia.get("doris").father = new Person("leonel");

        nietogarcia.get("hernan").mother = new Person("mariela");
        nietogarcia.get("hernan").father = new Person("agustin");

        System.out.println(nietogarcia.size());
        System.out.println(nietogarcia.height());
        System.out.println(nietogarcia.getGrandMothersName("agustin"));
        nietogarcia.print();
        
        //ARBOL DE DAVID
        AncestorTree trestrepo = new AncestorTree("david");
        trestrepo.get("david").mother = new Person("gloria");
        trestrepo.get("david").father = new Person("helmuth");

        trestrepo.get("gloria").mother = new Person("yolanda");
        trestrepo.get("gloria").father = new Person("ricardo");

        trestrepo.get("helmuth").mother = new Person("olga");
        trestrepo.get("helmuth").father = new Person("helmuth");
        
        System.out.println(trestrepo.size());
        System.out.println(trestrepo.height());
        System.out.println(trestrepo.getGrandMothersName("david"));
        trestrepo.print();
    }
}
