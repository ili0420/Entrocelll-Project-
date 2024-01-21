package org.com.sk.i2i.isbu.mth501.show;

import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;

import java.io.IOException;

public class ShowPriceProcedure {

    public static void execute(Client client, int subscId) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("SHOW_PRICE", subscId);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            // Get the content of the response
            VoltTable[] results = response.getResults();

            // Process the VoltTable and print to the screen
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    System.out.println("Price: " + result.getLong("PRICE")); // Assuming PRICE is of type LONG
                }
            }
        } else {
            System.err.println("Error in stored procedure call: " + response.getStatusString());
        }
    }
}
