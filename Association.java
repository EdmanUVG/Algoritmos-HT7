
/**
 * 
@autor: Edman Cota
@Version: 1.0

*/



public class Association<K extends Comparable<K>,V> implements Comparable<Association<K,V>>{

    //Key = Llave
    private final K key;
    //Value = valor
    private V value;

    /**
     *
     * @param key - llave
     * @param value = valor 
     */
    public Association(final K key, final V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la llave de asociacion.
     * @return retorna la palabra en ingles,la llave
     */
    public Object getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociacion.
     * @return retorna la palabra en espanol
     */
    public Object getValue() {
        return value;
    }

    /**
     * Define un valor especifico para la asociacion. 
     * @param value: el valor de la asociacion.
     * @return el valor econtrado. 
     */
    public Object setValue(final Object value) {
        final V val = (V) value;
        return this.value = val;
    }

    @Override
    public int compareTo(final Association<K, V> o) {
        final Association ob = (Association) o;
        return key.toString().compareToIgnoreCase(ob.key.toString());
    }
}