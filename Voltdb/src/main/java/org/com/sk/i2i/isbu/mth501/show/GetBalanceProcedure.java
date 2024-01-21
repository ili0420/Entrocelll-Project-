package org.com.sk.i2i.isbu.mth501.show;

import org.voltdb.VoltTable;
import org.voltdb.client.*;

import java.io.IOException;

public class GetBalanceProcedure {

    public static void execute(Client client, int subscId) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("SHOW_BALANCE_WITH_SUBSCID", subscId);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            // Get the content of the response
            VoltTable[] results = response.getResults();

            // Process the VoltTable and print to the console
            for (VoltTable result : results) {
                while (result.advanceRow()) {
                    System.out.println(result.toString());
                }
            }
        } else {
            System.err.println("Error in stored procedure call: " + response.getStatusString());
        }
    }
}
