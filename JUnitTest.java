import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	
	
	BinarySearchTree<Association<String, String>> binarySearchTree = new BinarySearchTree<>();
	
	@Test
	public void InsertTest() {
		
		String expresion = "Ejemplo 1, valor 1";
		
		String[] diccionario = expresion.split(",");
		
		Association<String, String> a = new Association(diccionario[0], diccionario[1]);
        binarySearchTree.add(a);
		
        if(diccionario.length > 1) {
        	assertEquals(diccionario.length, 2);
        }
	}

}
