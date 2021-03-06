import java.util.ArrayList;
import java.util.List;

/**
 * @author Edman Cota
 * @version prueba
 */
public class BinarySearchTree<E extends Comparable<E>>{

    protected BinaryTree<E> root;

    /**
     * Construye el constructor
     */
    public BinarySearchTree() {
        root = new BinaryTree<>();
    }

    /**
     * Agrega un nuevo binaryTree al BinarySearchTree
     * @param value. Recibe un valor generico
     */
    public void add(E value)
    {
        
        BinaryTree<E> newNode = new BinaryTree<>(value);
        if (root.isEmpty()) root = newNode;
        else
            
        {
            BinaryTree<E> nodeFound = searchNodeRecursive(root, value);
            nodeFound.setValue(value);
            if (nodeFound.getLeft()== null)
                nodeFound.setLeft(new BinaryTree<E>());
            if (nodeFound.getRight()== null)
                nodeFound.setRight(new BinaryTree<E>());
        }
    }

    /**
   
     * @param key la llave para buscar el valor
     * @return Retorna True si el valor es contenido o False si no en BinarySearchTree. 
     */
    public boolean contains(E key){
        return get(key) == key;
    }

    /**
     * Obtiene el valor contenida en la asociacion
     * @param key la llave a busvar
     * @return devuelve la llave. 
     */
    public E get(E key) {
        if(root.isEmpty()) return null;
        BinaryTree<E> node = searchNodeRecursive(root, key);
        if(node.isEmpty()) return null;
        return node.value();
    }

    
    public List<E> inOrder()
    {
        List<E> list = new ArrayList<>();
        inOrderRecursive(root, list);
        return list;
    }


    // Busqueda de forma recursiva
    protected BinaryTree searchNodeRecursive(BinaryTree<E> node,E key)
    {
        if(node.isEmpty()) return node;
        else
        {
            int compareResult =  node.value().compareTo(key);
            if (compareResult == 0 ) return node;
            else if (compareResult > 0)
            {
                return searchNodeRecursive(node.getLeft(), key);
            }
            else
            {
                return searchNodeRecursive(node.getRight(), key);
            }
        }
    }

    
     
    protected void inOrderRecursive(BinaryTree<E> node, List<E> list)
    {
        if(node.getLeft() != null && !node.getLeft().isEmpty()) inOrderRecursive(node.getLeft(), list);
        list.add(node.value());
        if(node.getRight() != null && !node.getRight().isEmpty()) inOrderRecursive(node.getRight(), list);
    }
}
//Referencias del codigo:
//https://www.geeksforgeeks.org/binary-search-tree-data-structure/