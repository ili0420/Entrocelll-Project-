package org.com.sk.i2i.isbu.mth501.update;

import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;

import java.io.IOException;

public class UpdatePriceProcedure {

    public static void execute(Client client, long priceIncrement, int subscId) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("UPDATE_PRICE", priceIncrement, subscId);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            System.out.println("Update successful");
        } else {
            System.err.println("Error in stored procedure call: " + response.getStatusString());
        }
    }
}
