package myboardtutorial.common.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* 
	* 이 클래스는 HandlerMethodArgumentResolver가 컨트롤러의 파라미터가 Map형이면
	* 동작하지 않기 때문에 만든 Map을 대신할 클래스. 
	* (구체적으론 스프링 <mvc:annotation-driven>을 사용할 경우에 위와 같은 문제 발생)
*/

/* 
* This class is custom 'Map' class for using 'HandlerMethodArgumentResolver'
* It's because HandlerMethod~ doesn't work when Controller's parameter is 'Map'
* (Especially, in case of using <mvc:annotation-driven>)
*/

public class CommandMap {
	Map<String, Object> map = new HashMap<String, Object>();

	public Object get(String key) {
		return map.get(key);
	}

	public void put(String key, Object value) {
		map.put(key, value);
	}

	public Object remove(String key) {
		return map.remove(key);
	}

	public boolean containsKey(String key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public void clear() {
		map.clear();
	}

	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}

	public Set<String> keySet() {
		return map.keySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
	}

	public Map<String, Object> getMap() {
		return map;
	}
}
