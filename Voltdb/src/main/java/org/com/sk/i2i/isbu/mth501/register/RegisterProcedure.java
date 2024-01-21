package org.com.sk.i2i.isbu.mth501.register;

import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;
import org.voltdb.VoltTable;

import java.io.IOException;

public class RegisterProcedure {

    public static void execute(Client client, int subscId, String msisdn, String name, String surname, String email, String password)
            throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("REGISTER", subscId, msisdn, name, surname, email, password);
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
