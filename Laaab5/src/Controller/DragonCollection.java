package Controller;

import Dragon.Dragon;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

public class DragonCollection {
    private static Hashtable<Integer, Dragon> collection;
    private static LocalDate dateCreation;

    public Hashtable<Integer, Dragon> getCollection() {
        return collection;
    }

    public static void setCollection(Hashtable<Integer, Dragon> collection) {
        DragonCollection.collection = collection;
    }


    public static LocalDate getDateCreation() {
        return dateCreation;
    }

    public static void setDateCreation(LocalDate dateCreation) {
        DragonCollection.dateCreation = dateCreation;
    }

    public void clear() {
        collection.clear();
    }

    /**
     * create new dragon with set id and put it into collection
     *
     * @param ind
     * @param dragon
     */
    public void insert(Integer ind, Dragon dragon) {
        if (this.isKeyFree(ind))
            collection.put(ind, dragon);
    }

    /**
     * update info about dragon with this id
     *
     * @param ind
     * @param dragon
     */
    public void update(Integer ind, Dragon dragon) {
        if (!this.isKeyFree(ind))
            collection.put(ind, dragon);
    }

    /**
     * remove dragon from the collection using id
     *
     * @param ind
     */
    public void remove(Integer ind) {
        Enumeration keys = collection.keys();
        while (keys.hasMoreElements()) {
            Integer k = (Integer) keys.nextElement();
            Dragon v = collection.get(k);
            if (!this.isKeyFree(ind)) collection.remove(k);

        }
    }

    /**
     *
     * @param ind
     * @return false if dragon with this id exist, false otherwise
     */
    public boolean isKeyFree(Integer ind) {
        try {
            for (Map.Entry<Integer, Dragon> entry : collection.entrySet())
                if (entry.getKey() == ind) return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;

        }
    }


    public int getSize() {
        return collection.size();
    }

    /**
     *
     * @return collection size and date of creation
     */
    public String getInfo() {
        return "Тип коллекции: Hashtable;\nKоличество элементов коллекции: " + this.getSize() + ";\nДата создания кол"
                + "лекции: " + this.getDateCreation() + ".";
    }


}
