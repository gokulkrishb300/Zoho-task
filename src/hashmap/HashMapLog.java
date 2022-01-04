package hashmap;

import java.util.*;

import customexception .CustomException ;

import string.BeginnerProgrammingString;

import utility.Utility;

public class HashMapLog {

Utility util = new Utility();

public Map<Object,Object> createHashMap() {

Map<Object,Object> map = new HashMap<Object,Object>();

return map;

}

//1
public int sizeOfHashMap(Map<Object,Object> map) throws CustomException  {

util.utilityNullHashMap(map);

int getLength = map.size();

return getLength;

}

//2 3 4 5 6 7

public Map<Object,Object> addHashMap(Map<Object,Object> map,Object key, Object value) throws CustomException {

util.utilityNullHashMap(map);

map.put(key,value);

return map;

}

//8

public boolean checkKeyMap(Map<Object,Object> map,Object key) throws CustomException {

util.utilityNullHashMap(map);

boolean find = map.containsKey(key);

return find;

}

//9 

public boolean checkValueMap(Map<Object,Object> map, Object value) throws CustomException  {

util.utilityNullHashMap(map);

boolean find = map.containsValue(value);

return find;

}


//11

public Object getValueOfKeyMap(Map<Object,Object> map, Object key) throws CustomException  {

util.utilityNullHashMap(map);

Object gettingKey = map.get(key);

return gettingKey;

}

//12

public Object getValueOfNonKeyMap (Map<Object,Object> map ,Object key, Object setValue) throws CustomException  {

util.utilityNullHashMap(map);

Object gettingNonKey = map.getOrDefault(key,setValue);

return gettingNonKey;
}

//13

public Map<Object,Object>  getNonKeyValueMap(Map<Object,Object> map,Object key, Object value) throws CustomException  {

util.utilityNullHashMap(map);

map.putIfAbsent(key, value);

return map;

}

//14

public Map<Object,Object> doRemoveMap(Map<Object,Object> map, Object key) throws CustomException  {

util.utilityNullHashMap(map);

map.remove(key);

return map;
}


//15

public Map doRemoveMatchMap(Map<Object,Object> map, Object key, Object value) throws CustomException  {

util.utilityNullHashMap(map);

map.remove(key, value);

return map;

}

//16

public Map<Object,Object> doReplaceMap(Map<Object,Object> map, Object key ,Object setValue) throws CustomException  {

util.utilityNullHashMap(map);

map.replace(key, setValue);

return map;

}

//17

public Map doSameReplaceMap (Map<Object,Object> map, Object key , Object oldValue, Object setValue) throws CustomException  {

util.utilityNullHashMap(map);

map.replace(key, oldValue, setValue) ;

return map;

}

//18

public Map<Object,Object> putAllHashMap(Map<Object,Object> mapOne, Map<Object,Object> mapTwo) throws CustomException  {

util.utilityNullHashMap(mapOne);

util.utilityNullHashMap(mapTwo);

mapOne.putAll(mapTwo);

return mapOne;

}

//20

public Map<Object,Object> clearMap(Map<Object,Object> map) throws CustomException  {

util.utilityNullHashMap(map);

map.clear();

return map;
}

}
