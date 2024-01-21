package org.com.sk.i2i.isbu.mth501.update;

import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;

import java.io.IOException;

public class UpdateBalanceSMSProcedure {

    public static void execute(Client client, int smsAmount, int subscId) throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("UPDATE_BALANCE_SMS", smsAmount, subscId);
        printResults(response);
    }

    private static void printResults(ClientResponse response) {
        if (response.getStatus() == ClientResponse.SUCCESS) {
            System.out.println("UPDATE_BALANCE_SMS stored procedure başarıyla çağrıldı.");
        } else {
            System.err.println("Stored procedure çağrısında hata: " + response.getStatusString());
        }
    }
}
