package springcore_day1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person2 {
	private String[] strings;
	private List<String> list;
	private Map<String, String> map;
	private Properties properties;
	
	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void printComplex() {
		System.out.println("==========Complex Bean Configuration============");
		System.out.println("String[]: " + Arrays.toString(strings));
		System.out.println("List: " + list);
		System.out.println("Map: " + map );
		System.out.println("Properties: " + properties);
	}
	
}
