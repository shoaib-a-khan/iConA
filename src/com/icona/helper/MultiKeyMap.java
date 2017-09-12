package com.icona.helper;

import java.util.HashMap;

import org.apache.commons.collections.keyvalue.MultiKey;

public class MultiKeyMap<V> extends HashMap<Object,V> {



	public V put(Object key1,Object key2,V value){
		MultiKey key=new MultiKey(key1, key2);
		return this.put((Object)key, value);

	}
	
	public V get(Object key1,Object key2){
		return this.get(new MultiKey(key1,key2));
	}

	
	public boolean containsKey(Object key1,Object key2) {
		// TODO Auto-generated method stub
		return super.containsKey(new MultiKey(key1,key2));
	}
	
	
	

}
