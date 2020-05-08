package dict;

public interface Dictionary {
  public int size(); 
  public boolean isEmpty();
  public Entry insert(Object key, Object value);
  public Entry find(Object key);
  public Entry remove(Object key);
  public void makeEmpty();
}
