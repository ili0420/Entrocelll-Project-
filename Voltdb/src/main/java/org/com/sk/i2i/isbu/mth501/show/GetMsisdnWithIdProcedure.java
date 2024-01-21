package org.com.sk.i2i.isbu.mth501.show;

import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.VoltTable;
import org.voltdb.client.ProcCallException;

import java.io.IOException;

public class GetMsisdnWithIdProcedure {

    public static void execute(Client client, String msisdn) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("GET_MSISDN_WITHID", msisdn);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            // Yanıtın içeriğini alın
            VoltTable[] results = response.getResults();

            // VoltTable'ı işleyin ve ekrana yazdırın
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    long custId = result.getLong("CUST_ID");
                    System.out.println("CUST_ID: " + custId);
                }
            }
        } else {
            System.err.println("Stored procedure çağrısında hata: " + response.getStatusString());
        }
    }
}
