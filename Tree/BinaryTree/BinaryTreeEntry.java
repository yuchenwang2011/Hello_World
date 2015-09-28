public class BinaryTreeEntry {
    private Object value;
    private Object key;
    
    BinaryTreeEntry(Object value, Object key) {
    	  this.value = value;
    	  this.key = key;
    }
    
    public void setKey(Object key) {this.key = key;}
    public void setValue(Object value) {this.value = value;}
    public Object getKey() {return key;}
    public Object getValue() {return value;}    
}

