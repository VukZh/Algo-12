
package hashtableapp;


public class HashTableApp {


    public static void main(String[] args) {
        
        HashTable ht1 = new HashTable(31);
        
        ht1.insertItem(new DataItem(1)); // вставка
        ht1.insertItem(new DataItem(41)); // вставка
        ht1.insertItem(new DataItem(2)); // вставка
        ht1.displayHashTable(); // вывод
        
        ht1.insertItem(new DataItem(10));ht1.displayHashTable(); // вставка на занятое место + вывод 2-х хэшей
        ht1.insertItem(new DataItem(72));ht1.displayHashTable(); // вставка на занятое место + вывод 2-х хэшей - 1 вариант
        
        ht1.insertItem(new DataItem(15));ht1.displayHashTable(); // вставка и вывод
        ht1.insertItem(new DataItem(46));ht1.displayHashTable(); // вставка на занятое место + вывод 2-х хэшей - 2 вариант
        
   
        ht1.deleteItem(10);ht1.displayHashTable(); // удаление и проверка пометки удаления
        ht1.insertItem(new DataItem(20));ht1.displayHashTable(); // проверка вставки на удаленное место
   
        System.out.println("Find: " + ht1.findItem(20).getKey()); // проверки поиска
        System.out.println("Find: " + ht1.findItem(3).getKey()); // проверки поиска
        
        
    }
    
}
