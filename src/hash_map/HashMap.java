package hash_map;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
    ArrayList<LinkedList<Entity>> list;

    private int size = 0;
    private float lf = 0.5f;
    public HashMap(){
        this.list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            this.list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % this.list.size());

        LinkedList<Entity> entities = this.list.get(hash);

        for(Entity entity: entities){
            if(entity.key.equals(key)){
                entity.value = (String) value;
                return;
            }
        }

        if((float)(this.size) / this.list.size() > lf){
            this.reHash();
        }

        entities.add(new Entity((String) key,(String) value));

        this.size++;
    }

    private void reHash(){
        System.out.println("We are now rehashing!");

        ArrayList<LinkedList<Entity>> old = this.list;
        this.list = new ArrayList<>();

        this.size = 0;

        for(int i = 0; i < old.size() * 2; i++){
            this.list.add(new LinkedList<>());
        }

        for(LinkedList<Entity> entries: old){
            for(Entity entry: entries){
                this.put((K) entry.key, (V) entry.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % this.list.size());
        LinkedList<Entity> entities = this.list.get(hash);

        for(Entity entity: entities){
            if(entity.key.equals(key)){
                return (V) entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash = Math.abs(key.hashCode() % this.list.size());
        LinkedList<Entity> entities = this.list.get(hash);

        Entity target = null;
        for(Entity entity: entities){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }

        entities.remove(target);
        this.size--;
    }

    public boolean containsKey(K key){
        return this.get(key) != null;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(LinkedList<Entity> entities: this.list){
            for(Entity entity: entities){
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append(" , ");
            }
        }
        builder.append("}");

        return builder.toString();
    }

    private class Entity {
        String key;
        String value;

        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("Santi", "Hola");
        hashMap.put("b", "chau");
        hashMap.put("a", "b");
        hashMap.remove("b");
        hashMap.reHash();


        System.out.println(hashMap);
        System.out.println(hashMap.get("Santi"));
    }


}
