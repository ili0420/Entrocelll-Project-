package org.example.hazelcast_operations;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import org.example.utils.configurations.Configuration;
import org.example.utils.constants.StringConstants;

/**
 * Bu sınıf, Hazelcast'ta belirli bir anahtarın değerini getirmek için kullanılır.
 * Sınıf, harita (map) kullanımını içerir ve harita üzerinde belirli bir anahtarın varlığını kontrol eder.
 * Eğer anahtar bulunursa, karşılık gelen değeri döndürür; aksi takdirde "Not found key" mesajını döndürür.
 * Hata durumunda, istisna mesajını döndürür.
 */
public class HazelcastDGWOperation {
    // Hazelcast istemcisini yapılandırmak için kullanılan ClientConfig nesnesi
    private static final ClientConfig config = Configuration.getConfig();

    // Hazelcast istemcisini başlatmak için kullanılan HazelcastInstance nesnesi
    private static final HazelcastInstance hazelcast = HazelcastClient.newHazelcastClient(config);

    /**
     * Belirli bir anahtara karşılık gelen değeri getirir.
     *
     * @param key Harita üzerinde aranan anahtar
     * @return Anahtarın değeri veya "Not found key" mesajı
     */
    public static String getPartitionIdByKey(String key) {
        try {
            // StringConstants.mapName adındaki haritayı alır
            IMap<Object, Object> map = hazelcast.getMap(StringConstants.mapName);

            // Haritada anahtar var mı diye kontrol eder
            if (map.containsKey(key)) {
                // Anahtar varsa, karşılık gelen değeri alır ve döndürür
                String value = map.get(key).toString();
                return value;
            } else {
                // Anahtar bulunamazsa "Not found key" mesajını döndürür
                return "Not found key";
            }
        } catch (Exception e) {
            // Hata durumunda istisna mesajını döndürür
            return e.toString();
        } finally {
            // Hazelcast istemcisini kapatır
            hazelcast.shutdown();
        }
    }
}
