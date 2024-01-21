package org.com.sk.i2i.isbu.mth501.voltdb;

import org.com.sk.i2i.isbu.mth501.client.VoltdbClient;
import org.voltdb.VoltTable;
import org.voltdb.client.*;

import java.io.IOException;

public class VoltDb {
    VoltdbClient voltdbClient = new VoltdbClient();
    Client client = voltdbClient.getClient();
    private ClientResponse response = null;



    public String getPackageName(String MSISDN){

        try {

            response = client.callProcedure("GET_PACKAGE", MSISDN);

        } catch (IOException | ProcCallException e) {

            e.printStackTrace();
        }

        VoltTable table2 =response.getResults()[0];
        table2.advanceRow();
        return table2.getString(1);
    }

    public long getUidByMSISDN(String MSISDN){

        try {

            response = client.callProcedure("GET_MSISDN_WITHID",MSISDN);

        } catch (IOException | ProcCallException e) {
            e.printStackTrace();
        }

        VoltTable table = response.getResults()[0];
        table.advanceRow();
        return table.getLong(0);
    }


    public int getVoiceBalance(String MSISDN){

        int uid= (int) getUidByMSISDN(MSISDN);


        try {
            response = client.callProcedure("SHOW_PACKAGE_AMOUNT_VOICE",uid);

        } catch (IOException | ProcCallException e) {

            throw new RuntimeException(e);
        }
        VoltTable table = response.getResults()[0];
        table.advanceRow();
        table.advanceRow();
        return (int) table.getLong(0);
    }


    public int getSMSBalance(String MSISDN){


        try {
            long uid= getUidByMSISDN(MSISDN);

            response = client.callProcedure("SHOW_PACKAGE_AMOUNT_SMS",uid);

        } catch (IOException | ProcCallException e) {

            throw new RuntimeException(e);
        }
        VoltTable table = response.getResults()[0];
        table.advanceRow();
        table.advanceRow();
        return (int) table.getLong(0);
    }


    public int getDataBalance(String MSISDN){


        try {
            long uid= (int) getUidByMSISDN(MSISDN);

            response = client.callProcedure("SHOW_PACKAGE_AMOUNT_DATA",uid);

        } catch (IOException | ProcCallException e) {

            throw new RuntimeException(e);
        }
        VoltTable table = response.getResults()[0];
        table.advanceRow();
        table.advanceRow();
        return (int) table.getLong(0);
    }


    public int getSubscriberBalance(String MSISDN){

        try {
            int uid= (int) getUidByMSISDN(MSISDN);

            response = client.callProcedure("SHOW_BALANCE_MONEY",uid);

        } catch (IOException | ProcCallException e) {

            throw new RuntimeException(e);
        }
        VoltTable table = response.getResults()[0];
        table.advanceRow();
        table.advanceRow();
        return (int) table.getLong(0);
    }


    public void sendSubscriberBalance(String MSISDN, int balance){

        try {
            int uid= (int) getUidByMSISDN(MSISDN);

            client.callProcedure("UPDATE_BALANCE_MONEY",uid, balance);

        } catch (IOException | ProcCallException e) {

            throw new RuntimeException(e);
        }
    }

//MINUTES
    public void sendVoiceAmount(String MSISDN, int usedAmount){

        try {
            int uid= (int) getUidByMSISDN(MSISDN);

            client.callProcedure("UPDATE_BALANCE_VOICE",uid, usedAmount);

        } catch (IOException | ProcCallException e) {
            e.printStackTrace();
        }
    }

//SMS
    public void sendSmsAmount(String MSISDN, int usedAmount){

        try {
            int uid= (int) getUidByMSISDN(MSISDN);

            client.callProcedure("UPDATE_BALANCE_SMS",uid, usedAmount);

        } catch (IOException | ProcCallException e) {
            e.printStackTrace();
        }
    }

// INTERNET- MB || GB
    public void sendGbAmount(String MSISDN, int usedAmount){

        try {
            int uid= (int) getUidByMSISDN(MSISDN);

            client.callProcedure("UPDATE_BALANCE_DATA",uid, usedAmount );

        } catch (IOException | ProcCallException e) {
            e.printStackTrace();
        }
    }


}
