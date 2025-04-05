package hash_map;


public class Map {
    private Entity[] entities;

    public Map(){
        entities = new Entity[100];
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % this.entities.length);
        entities[hash] = new Entity(key, value);
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % this.entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }

        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % this.entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
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
        Map map = new Map();

        map.put("Santi", "45");
        map.put("Santia", "45");

        map.remove("Santia");
        System.out.println(map.get("Santia"));
    }
}
