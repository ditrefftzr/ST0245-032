/**
 * Implementacion de un BST, no autobalanceable.
 * Fuentes principales: Referenciados en el código.
 * 
 * Para el metodo borrar()
 * http://www.algolist.net/Data_structures/Binary_search_tree/Removal
 *
 * Para casos de prueba y otros:
 * https://github.com/mauriciotoro/ST0245-Eafit/blob/master/talleres/taller11/java/Laboratorio5/src/BinaryTree.java
 *
 * @author anietog1
 */
public class BinaryTree {

    private static class Node {

        Node parent, left, right;
        int data;

        public Node(int data, Node parent) {
            this.data = data;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public boolean buscar(int n) {
        return buscar(root, n);
    }

    private boolean buscar(Node node, int n) {
        if (node == null) {
            return false;
        }

        if (n < node.data) {
            return buscar(node.left, n);
        }

        if (n > node.data) {
            return buscar(node.right, n);
        }

        return true;
    }

    public boolean insertar(int n) {
        if (root == null) {
            root = new Node(n, null);
            return true;
        } else {
            Node temp = root;
            while (temp.data != n) {
                if (n < temp.data) {
                    if (temp.left == null) {
                        temp.left = new Node(n, temp);
                        return true;
                    }

                    temp = temp.left;
                } else if (n > temp.data) {
                    if (temp.right == null) {
                        temp.right = new Node(n, temp);
                        return true;
                    }

                    temp = temp.right;
                }
            }
        }

        return false;
    }

    /***********************************************************
     * Método borrar y otros tomados de:
 http://www.algolist.net/Data_structures/Binary_search_tree/Removal

 Editado por anietog1, aunque es prácticamente el mismo, sólo se cambió
 para que fuera compatible con la implementación propia.
     *
     * Aprendido: -Incluso la clase que actúa solo como contenedor puede llevar
     * métodos de utilidades, en el código original se implementó de tal manera,
     * y no se me ocurrio, aunque de tal manera la implementacion era bastante
     * más simple. 
     **********************************************************/
    public boolean borrar(int value) {
        if (root == null) {
            return false;
        } else {
            if (root.data == value) {//caso especial
                Node auxRoot = new Node(0, null);
                auxRoot.left = root;
                //es interesante el porque no asocia root.parent = auxRoot, se tira el removal desde aqui 
                //y asi se balancea solo, ya que tiene padre :o
                boolean result = borrar(value, root, auxRoot);
                //por eso se vuelve a poner como raiz xd.
                root = auxRoot.left;
                return result;
            } else {
                return borrar(value, root, null);
            }
        }
    }

    private boolean borrar(int value, Node curr, Node parent) {
        //Primero se va hasta el nodo que se eliminara.
        if (value < curr.data) {
            if (curr.left != null) {
                return borrar(value, curr.left, curr);
            } else {
                return false;
            }
        } else if (value > curr.data) {
            if (curr.right != null) {
                return borrar(value, curr.right, curr);
            } else {
                return false;
            }
        } else {//Finalmente, se elimina asi: (leer desde el ultimo caso hacia arriba
            if (curr.left != null && curr.right != null) {
                //Se reemplaza el dato actual con el menor a la derecha, 
                // es algo como el menor mayor... así seguirá balanceado,
                // porque lo menor va a la izq y lo mayor a la der.
                curr.data = min(curr.right);
                //Luego se remueve del lado derecho el numero que se tiene. 
                //Como se sabe que es una hoja, la remoción es fácil
                borrar(curr.data, curr.right, curr);
                //LOS DOS POSTERIORES SE BASAN EN EL SIGUIENTE PRINCIPIO:
                //SI ALGUNO DE LOS DOS ES NULO, SOLO DEBO SUBIR EL QUE NO LO ES
                //SI LOS DOS LO SON, PUEDO "SUBIR" CUALQUIERA :)
                //Y PARA ESO ES EL PADRE
            } else if (parent.left == curr) {
                parent.left = (curr.left != null) ? curr.left : curr.right;
            } else if (parent.right == curr) {
                parent.right = (curr.left != null) ? curr.left : curr.right;
            }
            
            return true;
        }
    }

    private int min(Node start) {
        //Este es particularmente simple, solo se toma un nodo y se va 
        //a fondo pa la izquierda, asi se halla el menor, es mas, 
        //ya lo habia implementado igual :v
        if (start.left == null) {
            return start.data;
        } else {
            return min(start.left);
        }
    }

    /******************************************************************
     * Otorgado por el docente, en:
     *
     * https://github.com/mauriciotoro/ST0245-Eafit/blob/master/talleres/taller11/java/Laboratorio5/src/BinaryTree.java
     ******************************************************************/
    private int max2(int i, int j) {
        if (i > j) {
            return i;
        }
        return j;
    }

    private int maxheightAUX(Node node) {
        if (node == null) {
            return 0;
        } else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right)) + 1;
        }
    }

    public int maxheight() {
        return maxheightAUX(root);
    }

    private void recursivePrintAUX(Node node) {
        if (node != null) {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }
    }

    public void recursivePrint() {
        recursivePrintAUX(root);
    }
}
