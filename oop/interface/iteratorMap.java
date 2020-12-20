/**遍历map */
Set<Map.Entry<Integer,String>> entry = map.entrySet();
Iterator<Map.Entry<Integer,String>> it = entry.iterator();
while(it.hasNext()) {
    Map.Entry<Integer,String> me = it.next();
    Integer key = me.getKey();
    String value = me.getValue();
    System.out.println(key+":"+value);
}