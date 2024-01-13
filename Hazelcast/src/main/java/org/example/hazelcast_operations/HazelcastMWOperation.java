package org.example.hazelcast_operations;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.example.utils.configurations.Configuration;
import org.example.utils.constants.StringConstants;

/**
 * HazelcastMWOperation sınıfı, Hazelcast haritası üzerinde put ve remove işlemlerini gerçekleştirmek için kullanılır.
 */
public class HazelcastMWOperation {

    // Hazelcast istemcisini yapılandırmak için kullanılan ClientConfig nesnesi
    private static ClientConfig config = Configuration.getConfig();

    // Hazelcast istemcisini başlatmak için kullanılan HazelcastInstance nesnesi
    private static HazelcastInstance hazelcast = HazelcastClient.newHazelcastClient(config);

    /**
     * Haritaya yeni bir anahtar-değer çifti ekler.
     *
     * @param key   Haritaya eklenecek anahtar
     * @param value Haritaya eklenecek değer
     * @return İşlem başarılıysa "Put operation is successful", aksi takdirde "Put operation is not successful" mesajını döndürür.
     */
    public static String put(String key, String value) {
        try {
            // StringConstants.mapName adındaki haritayı alır
            IMap<Object, Object> map = hazelcast.getMap(StringConstants.mapName);

            // Haritaya yeni bir anahtar-değer çifti ekler
            map.put(key, value);

            // İşlem başarılı mesajını döndürür
            return "Put operation is successful";
        } catch (Exception e) {
            // Hata durumunda istisna bilgisini yazdırır ve başarısız mesajını döndürür
            e.printStackTrace();
            return "Put operation is not successful";
        } finally {
            // Hazelcast istemcisini kapatır
            hazelcast.shutdown();
        }
    }

    /**
     * Haritadan belirli bir anahtarı ve karşılık gelen değeri kaldırır.
     *
     * @param key Kaldırılacak anahtar
     * @return İşlem başarılıysa "Remove operation is successful", anahtar bulunamazsa "Not found key", aksi takdirde "Remove operation is not successful" mesajını döndürür.
     */
    public static String remove(String key) {
        try {
            // StringConstants.mapName adındaki haritayı alır
            IMap<Object, Object> map = hazelcast.getMap(StringConstants.mapName);

            // Haritada belirli bir anahtar var mı diye kontrol eder
            if (map.containsKey(key)) {
                // Anahtar varsa, haritadan kaldırma işlemi gerçekleştirir
                map.remove(key);
                // İşlem başarılı mesajını döndürür
                return "Remove operation is successful";
            }
            // Anahtar bulunamazsa "Not found key" mesajını döndürür
            return "Not found key";
        } catch (Exception e) {
            // Hata durumunda istisna bilgisini yazdırır ve başarısız mesajını döndürür
            e.printStackTrace();
            return "Remove operation is not successful";
        } finally {
            // Hazelcast istemcisini kapatır
            hazelcast.shutdown();
        }
    }
}
