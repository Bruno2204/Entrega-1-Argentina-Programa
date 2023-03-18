package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        List <Partido> resultados;
        List <Pronostico> pronosticos;
        int puntaje=0;
        try {
            FileReader fileResultados = new FileReader("src/main/resources/resultados.csv");
            FileReader filePronosticos = new FileReader("src/main/resources/pronosticos.csv");

            resultados = new CsvToBeanBuilder(fileResultados)
                    .withSkipLines(1)
                    .withType(Partido.class)
                    .build()
                    .parse();
            pronosticos = new CsvToBeanBuilder(filePronosticos)
                    .withSkipLines(1)
                    .withType(Pronostico.class)
                    .build()
                    .parse();

//            for (Partido partido : resultados) {
//                System.out.printf("%-15s",partido.getGanador());
//            }

            for (int i = 0; i < 2; i++) {
                if (pronosticos.get(i).ganador == resultados.get(i).getGanador()) {
                    puntaje++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Tu puntaje es: "+puntaje);
        }
    }
}