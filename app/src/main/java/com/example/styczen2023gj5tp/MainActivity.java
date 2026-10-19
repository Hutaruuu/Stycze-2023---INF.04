package com.example.styczen2023gj5tp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends Activity {

    EditText imie, nazwisko, ile;
    Spinner stanowisko;
    CheckBox litery, cyfry, specjalne;
    Button generuj, zatwierdz;
    String haslo = "";
    Random los = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);
        ile = findViewById(R.id.ile);
        stanowisko = findViewById(R.id.stanowisko);
        litery = findViewById(R.id.litery);
        cyfry = findViewById(R.id.cyfry);
        specjalne = findViewById(R.id.specjalne);
        generuj = findViewById(R.id.generuj);
        zatwierdz = findViewById(R.id.zatwierdz);

        generuj.setOnClickListener(v -> {
            String male = "abcdefghijklmnopqrstuvwxyz";
            String duze = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String liczby = "0123456789";
            String znaki = "!@#$%^&*()_+-=";

            if (ile.getText().toString().isEmpty()) {
                Toast.makeText(this, "Podaj liczbę znaków", Toast.LENGTH_SHORT).show();
                return;
            }

            int dlugosc = Integer.parseInt(ile.getText().toString());
            if (dlugosc < 1 || dlugosc > 1000) {
                Toast.makeText(this, "Podaj liczbę od 1 do 1000", Toast.LENGTH_SHORT).show();
                return;
            }

            haslo = "";
            for (int i = 0; i < dlugosc; i++) {
                haslo += male.charAt(los.nextInt(male.length()));
            }

            int pozycja = 0;

            if (litery.isChecked() && pozycja < dlugosc) {
                char znak = duze.charAt(los.nextInt(duze.length()));
                haslo = haslo.substring(0, pozycja) + znak + haslo.substring(pozycja + 1);
                pozycja++;
            }

            if (cyfry.isChecked() && pozycja < dlugosc) {
                char znak = liczby.charAt(los.nextInt(liczby.length()));
                haslo = haslo.substring(0, pozycja) + znak + haslo.substring(pozycja + 1);
                pozycja++;
            }

            if (specjalne.isChecked() && pozycja < dlugosc) {
                char znak = znaki.charAt(los.nextInt(znaki.length()));
                haslo = haslo.substring(0, pozycja) + znak + haslo.substring(pozycja + 1);
            }

            new AlertDialog.Builder(this)
                    .setMessage(haslo)
                    .setPositiveButton("OK", null)
                    .show();
        });

        zatwierdz.setOnClickListener(v -> {
            String dane = "Dane pracownika: " + imie.getText().toString() + " "
                    + nazwisko.getText().toString() + " "
                    + stanowisko.getSelectedItem().toString() + " Hasło: " + haslo;

            new AlertDialog.Builder(this)
                    .setMessage(dane)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}
