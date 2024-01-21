package org.com.sk.i2i.isbu.mth501.show;

import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.VoltTable;
import org.voltdb.client.ProcCallException;

import java.io.IOException;

public class ShowPackageAmountVoiceProcedure {

    public static void execute(Client client, int subscId) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("SHOW_PACKAGE_AMOUNT_VOICE", subscId);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            // Yanıtın içeriğini alın
            VoltTable[] results = response.getResults();

            // VoltTable'ı işleyin ve ekrana yazdırın
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    // Sonuçları ekrana yazdır
                    long packageAmount = result.getLong(0);
                    System.out.println("SHOW_PACKAGE_AMOUNT_VOICE stored procedure başarıyla çağrıldı. Package Amount: " + packageAmount);
                }
            }
        } else {
            System.err.println("Stored procedure çağrısında hata: " + response.getStatusString());
        }
    }
}
