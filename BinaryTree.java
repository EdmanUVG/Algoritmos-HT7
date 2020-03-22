

/**
 * @author Edman Cota
 * @version 1.0
 */

public class BinaryTree<E> {
	
	// Nodos de izquierda y derecha
	private BinaryTree<E> left, right;
	
    /**
     * Valor del the BinaryTree
     */
    private E value;
   
    

    /**
     * Constructor  con valores nulos
     */
    public BinaryTree()
    {
        value = null;
        left = right = null;
    }

    
    public BinaryTree(E value)
    {
        this.value = value;
        setLeft(new BinaryTree<>());
        setRight(new BinaryTree<>());
    }

    
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
    {
        this(value);
        if(left != null) setLeft(left);
        if(right != null) setRight(right);
    }

    public BinaryTree<E> getLeft() { return left; }
    public BinaryTree<E> getRight() { return right; }


    
    public void setLeft(BinaryTree<E> newLeft)
    {
        left = newLeft;
    }

    
    public void setRight(BinaryTree<E> newRight) {
        right = newRight;
    }

    
    public E value() { return value; }

    
    public void setValue(E newValue) { value = newValue; }

    
    protected boolean isEmpty()
    {
        return value == null;
    }
}