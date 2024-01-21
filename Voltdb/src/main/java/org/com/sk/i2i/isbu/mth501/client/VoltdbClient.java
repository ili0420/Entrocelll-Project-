package org.com.sk.i2i.isbu.mth501.client;

import org.voltdb.client.Client;
import org.voltdb.client.ClientConfig;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;

import java.io.IOException;
public class VoltdbClient {

    private String id;
    private int port;
    private ClientResponse response = null;
    private Client client;

    public VoltdbClient() {
        this.id = "34.18.69.164";
        this.port = 32804;

        try {
            this.client = getClientVoltDB();
        } catch (IOException | ProcCallException e) {
            e.printStackTrace();
        }
    }

    public Client getClientVoltDB() throws IOException, ProcCallException {
        ClientConfig config = new ClientConfig();
        Client client = ClientFactory.createClient(config);
        client.createConnection(id, port);
        return client;
    }

    public void closeClient() throws InterruptedException {
        if (client != null) {
            client.close();
        }
    }

    // getClientVoltDB metodunu getClient olarak değiştirdim
    public Client getClient() {
        return client;
    }
}
