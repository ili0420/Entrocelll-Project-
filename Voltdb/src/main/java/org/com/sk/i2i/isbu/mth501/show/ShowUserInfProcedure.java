package org.com.sk.i2i.isbu.mth501.show;

import org.voltdb.VoltTable;
import org.voltdb.client.*;

import java.io.IOException;

public class ShowUserInfProcedure {

    public static void execute(Client client, String msisdn) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("SHOW_USER_INFORMATION", msisdn);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            // Yanıtın içeriğini alın
            VoltTable[] results = response.getResults();

            // VoltTable'ı işleyin ve ekrana yazdırın
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    System.out.println(result.toString());
                }
            }
        } else {
            System.err.println("Stored procedure çağrısında hata: " + response.getStatusString());
        }
    }
}
