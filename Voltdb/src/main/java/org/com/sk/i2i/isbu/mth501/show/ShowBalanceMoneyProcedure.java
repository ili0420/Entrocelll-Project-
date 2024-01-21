package org.com.sk.i2i.isbu.mth501.show;


import org.voltdb.VoltTable;
import org.voltdb.client.Client;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;

import java.io.IOException;
import java.math.BigDecimal;

public class ShowBalanceMoneyProcedure {

    private final Client client;

    public ShowBalanceMoneyProcedure(Client client) {
        this.client = client;
    }

    public BigDecimal showBalanceMoney(int subscId) {
        ClientResponse response;

        try {
            response = client.callProcedure("SHOW_BALANCE_MONEY", subscId);
        } catch (IOException | ProcCallException e) {
            throw new RuntimeException(e);
        }

        VoltTable table = response.getResults()[0];
        table.advanceRow();
        return table.getDecimalAsBigDecimal(0);
    }
}
