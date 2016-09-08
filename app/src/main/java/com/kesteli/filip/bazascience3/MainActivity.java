package com.kesteli.filip.bazascience3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addStranica(new Stranica("www.google.com", 1, 0, 0));
        db.addStranica(new Stranica("www.google.com", 0, 1, 0));
        db.addStranica(new Stranica("www.google.com", 1, 0, 1));
        db.addStranica(new Stranica("www.google.com", 1, 1, 0));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");


        /**
         * Nalazimo stranicu prema id-ju:
         * */
        Stranica str = db.getStranicaPremaID(4);
        String log2 = "Id: " + str.get_id()
                + " ,Site: " + str.get_site()
                + " ,History: "
                + str.get_history()
                + " ,Favorite: " + str.get_favorite()
                + " ,Eureka: " + str.get_eureka();
        // Writing Contacts to log
        Log.d("LALALA: ", log2);


        /**
         * Nalazimo stranicu prema site-u:
         * */
        Stranica str2 = db.getStranicaPremaSite("www.google.com");
        String log3 = "Id: " + str.get_id()
                + " ,Site: " + str.get_site()
                + " ,History: "
                + str.get_history()
                + " ,Favorite: " + str.get_favorite()
                + " ,Eureka: " + str.get_eureka();
        // Writing Contacts to log
        Log.d("LALI: ", log3);


        /**
         * Lista svih stranica za koje je history != 1:
         * */
        List<Stranica> stranice = db.getAllStranice();

        for (Stranica stranica : stranice) {
            String log = "Id: " + stranica.get_id()
                    + " ,Site: " + stranica.get_site()
                    + " ,History: "
                    + stranica.get_history()
                    + " ,Favorite: " + stranica.get_favorite()
                    + " ,Eureka: " + stranica.get_eureka();
            // Writing Contacts to log
            if (stranica.get_history() != 1) {
                Log.d("Name: ", log);
            }
        }


        /**
         * Update stranica:
         * */
        Stranica ss1 = new Stranica("www.google.com", 1, 0, 0);
        Stranica ss2 = new Stranica("www.google.com", 1, 1, 0);
        Stranica ss3 = new Stranica("www.google.com", 1, 1, 1);
        Stranica ss4 = new Stranica("www.google.com", 0, 0, 0);
        List<Stranica> stranicaList = new ArrayList<>();
        stranicaList.add(ss1);
        stranicaList.add(ss2);
        stranicaList.add(ss3);
        stranicaList.add(ss4);
        db.addStranica(ss1);
        db.addStranica(ss2);
        db.addStranica(ss3);
        db.addStranica(ss4);

        for (int i = 0; i < stranicaList.size(); i++) {
            String logg = "Id: " + stranicaList.get(i).get_id()
                    + " ,Site: " + stranicaList.get(i).get_site()
                    + " ,History: "
                    + stranicaList.get(i).get_history()
                    + " ,Favorite: " + stranicaList.get(i).get_favorite()
                    + " ,Eureka: " + stranicaList.get(i).get_eureka();
            // Writing Contacts to log
            Log.d("UP: ", logg);
        }

        int xx = db.updateStranica(ss4);
        Log.d("UP: ", xx + "");


        /**
         * DELETE stranica
         * */
        //Najprije uzmem stranicu po site-u, onda ju izbrisem:
        /**
         * Nalazimo stranicu prema site-u:
         * */
        Stranica sss = db.getStranicaPremaSite("www.google.com");
        String logsss = "Id: " + sss.get_id()
                + " ,Site: " + sss.get_site()
                + " ,History: "
                + sss.get_history()
                + " ,Favorite: " + sss.get_favorite()
                + " ,Eureka: " + sss.get_eureka();
        // Writing Contacts to log
        Log.d("LALI: ", logsss);

        /**
         * DELETE-amo:
         * */
        db.deleteStranica(sss);
        Log.d("UP: ", xx + "");
    }
}