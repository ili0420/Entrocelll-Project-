package org.example.hazelcast_operations;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.example.utils.configurations.Configuration;
import org.example.utils.constants.StringConstants;

import java.util.Collection;

/**
 * HazelcastSimulatorOperation sınıfı, Hazelcast haritası üzerinde simulasyon işlemlerini gerçekleştirmek için kullanılır.
 */
public class HazelcastSimulatorOperation {
    // Hazelcast istemcisini yapılandırmak için kullanılan ClientConfig nesnesi
    private static final ClientConfig config = Configuration.getConfig();

    // Hazelcast istemcisini başlatmak için kullanılan HazelcastInstance nesnesi
    private static final HazelcastInstance hazelcast = HazelcastClient.newHazelcastClient(config);

    /**
     * Harita üzerindeki tüm değerleri alır.
     *
     * @return Harita üzerindeki tüm değerleri içeren bir Collection nesnesi veya hata durumunda null.
     */
    public static Collection<Object> getAllPartitionId() {
        try {
            // StringConstants.mapName adındaki haritayı alır
            IMap<Object, Object> map = hazelcast.getMap(StringConstants.mapName);

            // Harita üzerindeki tüm değerleri alır
            Collection<Object> allPartitionId = map.values();

            // Alınan değerleri döndürür
            return allPartitionId;
        } catch (Exception e) {
            // Hata durumunda istisna bilgisini yazdırır ve null döndürür
            e.printStackTrace();
            return null;
        } finally {
            // Hazelcast istemcisini kapatır (kapatılmış durumda bırakılmış)
            //hazelcast.shutdown();
        }
    }

    /**
     * Harita üzerindeki tüm anahtarları alır.
     *
     * @return Harita üzerindeki tüm anahtarları içeren bir Collection nesnesi veya hata durumunda null.
     */
    public static Collection<Object> getAllMsisdn() {
        try {
            // StringConstants.mapName adındaki haritayı alır
            IMap<Object, Object> map = hazelcast.getMap(StringConstants.mapName);

            // Harita üzerindeki tüm anahtarları alır
            return map.keySet();
        } catch (Exception e) {
            // Hata durumunda istisna bilgisini yazdırır ve null döndürür
            e.printStackTrace();
            return null;
        } finally {
            // Hazelcast istemcisini kapatır (kapatılmış durumda bırakılmış)
            //hazelcast.shutdown();
        }
    }
}
