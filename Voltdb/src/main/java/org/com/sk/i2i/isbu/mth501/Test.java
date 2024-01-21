package org.com.sk.i2i.isbu.mth501;

import org.example.show.*;


// TEST SINIFINDA PROCEDURLERIN KULLANIMI ORNEKLENDIRILMISTIR

// RESOURCES KLASORUNDE PROCEDURES DOSYASINDA PROCEDURLERIN YAPISI MEVCUT

// PROCEDURLER VOLTDB MANAGEMENT CENTERDA resources/PROCEDURES ile verilen kodlarla OLUSTURULMUSTUR

// RESOURCES KLASORUNDE CREATE_TABLE DOSYASINDA TABLOLARIN YAPISI MEVCUT

//TEST EDILDI

/*
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // VoltdbClient sınıfını oluştur
        VoltdbClient voltdbClient = new VoltdbClient();
        int subscid = 3;
        try {
            // VoltdbClient sınıfından client'i al
            Client client = voltdbClient.getClientVoltDB();
            ////// KULLANICI EKLE////////
            RegisterProcedure.execute(client, 3, "5350643342", "name", "surname", "example@gmail.com", "password1");
            ////// BALANCE OLUSTUR (PAKET BELIRLE) //////////
            RegisterBalanceProcedure.execute(client,4,3,1,250);
            //// KULLANICIYI GOSTER (MSISDN) ILE ///////////
            ShowUserInfProcedure.execute(client, "5350643342");
            //// KULLANICIYI PAKETINI GOSTER (MSISDN) ILE ///////////
            GetPackageProcedure.execute(client, "5350643342");
            //////// KULLANICI AKTIF SMS GORUNTULE //////
            ShowPackageAmountSmsProcedure.execute(client,subscid);
            //////// KULLANICI AKTIF VOICE GORUNTULE //////
            ShowPackageAmountVoiceProcedure.execute(client,subscid);
            //////// KULLANICI AKTIF DATA GORUNTULE //////
            ShowPackageAmountVoiceProcedure.execute(client,subscid);
            //////// KULLANICI SMS BILGISI GUNCELLE ////////
            UpdateBalanceSMSProcedure.execute(client,70,3);
            //////// KULLANICI VOICE BILGISI GUNCELLE ////////
            UpdateBalanceVoiceProcedure.execute(client,206,3);
            //////// KULLANICI SMS BILGISI GUNCELLE ////////
            UpdateBalanceDataProcedure.execute(client,168,3);
            //////// GUNCEL KULLANICI AKTIF SMS GORUNTULE //////
            ShowPackageAmountSmsProcedure.execute(client,subscid);
            //////// GUNCEL KULLANICI AKTIF VOICE GORUNTULE //////
            ShowPackageAmountVoiceProcedure.execute(client,subscid);
            //////// GUNCEL KULLANICI AKTIF DATA GORUNTULE //////
            ShowPackageAmountDataProcedure.execute(client,subscid);
            ////// KULLANICI BALANCE BILGSINI GORUNTULE /////////
            GetBalanceProcedure.execute(client,3);


        } catch (IOException | ProcCallException e) {
            e.printStackTrace();
        } finally {
            // VoltdbClient sınıfındaki client'i kapat
            voltdbClient.closeClient();
        }
    }
}*/
