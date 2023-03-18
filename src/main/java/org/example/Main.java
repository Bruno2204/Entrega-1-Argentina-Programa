package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List <Partido> resultados = new ArrayList<Partido>();
        List <Pronostico> pronosticos;
//        List <Equipo> equipos = new ArrayList<Equipo>();
//        equipos.add(new Equipo("Argentina"));
//        equipos.add(new Equipo("Arabia Saudita"));
//        equipos.add(new Equipo("Mexico"));
//        equipos.add(new Equipo("Polonia"));
        HashMap<String,Equipo> equipos = new HashMap<String,Equipo>();
        equipos.put("Argentina",new Equipo("Argentina"));
        equipos.put("Arabia Saudita",new Equipo("Arabia Saudita"));
        equipos.put("Mexico",new Equipo("Mexico"));
        equipos.put("Polonia",new Equipo("Polonia"));
        int puntaje=0;
        try {
            FileReader fileResultados = new FileReader("src/main/resources/resultados.csv");
            FileReader filePronosticos = new FileReader("src/main/resources/pronosticos.csv");

//            resultados = new CsvToBeanBuilder(fileResultados)
//                    .withSkipLines(1)
//                    .withType(Partido.class)
//                    .build()
//                    .parse();
            pronosticos = new CsvToBeanBuilder(filePronosticos)
                    .withSkipLines(1)
                    .withType(Pronostico.class)
                    .build()
                    .parse();



            BufferedReader brResultados = new BufferedReader(fileResultados);
            brResultados.readLine();
            String line;
            while ((line = brResultados.readLine()) != null){
                String[] datos = line.split(",");
                Equipo equipo1 = equipos.get(datos[0]);
                int goles1 = Integer.parseInt(datos[1]);
                int goles2 = Integer.parseInt(datos[2]);
                Equipo equipo2 = equipos.get(datos[3]);
                resultados.add(new Partido(equipo1,goles1,goles1,equipo2));
            }

            brResultados.close();

            for (int i = 0; i < resultados.size(); i++) {
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