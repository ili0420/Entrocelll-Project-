package org.com.sk.i2i.isbu.mth501.show;

import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.VoltTable;
import org.voltdb.client.ProcCallException;

import java.io.IOException;

public class GetPackageProcedure {

    public static void execute_print(Client client, String msisdn) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("GET_PACKAGE", msisdn);
        printResults(response);
    }
    public static void execute(Client client, String msisdn) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("GET_PACKAGE", msisdn);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            // Yanıtın içeriğini alın
            VoltTable[] results = response.getResults();

            // VoltTable'ı işleyin ve ekrana yazdırın
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    // İlgili sütunlardan değerleri alın
                    long packageId = result.getLong("PACKAGE_ID");
                    String packageName = result.getString("PACKAGE_NAME");
                    // Diğer sütunlardan da değerleri alarak kullanabilirsiniz

                    // Sonuçları ekrana yazdır
                    System.out.println("PACKAGE_ID: " + packageId);
                    System.out.println("PACKAGE_NAME: " + packageName);
                    // Diğer sütunları da ekrana yazdırmaya devam edebilirsiniz
                }
            }
        } else {
            System.err.println("Stored procedure çağrısında hata: " + response.getStatusString());
        }
    }
}
