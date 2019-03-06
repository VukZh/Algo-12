package hashtableapp;

public class HashTable {
    
    private final DataItem [] arrHash;
    private final int size;
    DataItem noItem = new DataItem (-1);// отметка для ленивого удаления
    public HashTable (int s){
        size = s;         
        arrHash  = new DataItem [size];        
    }
    
    public int hashFunction1 (int k){ // хэш функция
        return k % size;
    }
    
    public int hashFunction2 (int k){
        return k % (size - 1) + 1;
    }
    
    public boolean insertItem (DataItem i){ // вставка, при одинаковом элементе - выход без вставки
        int key = i.getKey();
        int hash = hashFunction1(key);
        int step = hashFunction1(key);
        while (arrHash [hash] != null && arrHash [hash].getKey() != -1) {            
            if (arrHash[hash].getKey() == key) // выход без вставки
                return false;
            else {
                hash = hash + step; System.out.println("s - " + step);
                hash = hash % size; // возврат на начало хэш таблицы при увеличении > size
                System.out.println("h - " + hash);
            }            
        }
        arrHash [hash] = i;
        return true;
    }
    
    public boolean deleteItem (int k){
        int hash = hashFunction1(k);
        int step = hashFunction1(k);
        while (arrHash [hash] != null) {            
            if (arrHash [hash].getKey() == k){
                arrHash [hash] = noItem;
                return true; // удалено
            }
            hash = hash + step;
            hash = hash % size;
        }
        return false; // не найдено
    }
    
    public DataItem findItem (int k){
        int hash = hashFunction1(k);
        int step = hashFunction1(k);        
        while (arrHash [hash] != null) {
            if (arrHash [hash].getKey() == k){
                return arrHash [hash]; // вывод найденного объекта
            }
            hash = hash + step;
            hash = hash % size;
        }
        return noItem; // -1 - если не найдено, тоже вывожу НетДанных
    }
    
    public void displayHashTable (){
        System.out.println("HashTable:");
        for (int i = 0; i < size; i++) {
            if (arrHash[i] != null){
                if (arrHash[i].getKey() != -1)
                    System.out.print(" " + arrHash[i].getKey() + " ");
                else
                    System.out.print(" NoD "); // нет данных после удаления
            }
            else
                System.out.print(" ___ ");
        }
        System.out.println("");
    }
}
