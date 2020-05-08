package dict;

public class Entry {

  protected Object key;
  protected Object value;
  protected Entry() {
  }
  protected Entry(Object k, Object v) {
    key = k;
    value = v;
  }
  public Object key() {
    return key;
  }
  public Object value() {
    return value;
  }
}
