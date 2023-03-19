package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Partido> resultados = new ArrayList<Partido>();
        List<Pronostico> pronosticos = new ArrayList<Pronostico>();

        try (BufferedReader brResultados = new BufferedReader(new FileReader("src/main/resources/resultados.csv")) ;
             BufferedReader brPronosticos = new BufferedReader(new FileReader("src/main/resources/pronosticos.csv"))) {

            List<String> fileResultados = brResultados.lines().toList();
            AddPartidos(resultados,fileResultados);

            List<String> filePronosticos = brPronosticos.lines().toList();
            AddPronosticos(pronosticos,filePronosticos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ObtenerPuntaje(pronosticos,resultados);
        }
    }

    public static void AddPartidos(List<Partido> lista,List<String> file) {
        for (int i = 1 ; i < file.size() ; i++) {
            String[] datos = file.get(i).split(",");
            Equipo equipo1 = Equipo.GetEquipo(datos[0]);
            int goles1 = Integer.parseInt(datos[1]);
            int goles2 = Integer.parseInt(datos[2]);
            Equipo equipo2 = Equipo.GetEquipo(datos[3]);
            lista.add(new Partido(equipo1,goles1,goles2,equipo2));
        }
    }

    public static void AddPronosticos(List<Pronostico> lista,List<String> file) {
        for (int i = 1 ; i < file.size() ; i++) {
            String[] datos = file.get(i).split(",");
            Equipo equipo1 = Equipo.GetEquipo(datos[0]);
            int ganador = Integer.parseInt(datos[1]);
            Equipo equipo2 = Equipo.GetEquipo(datos[2]);
            lista.add(new Pronostico(equipo1,ganador,equipo2));
        }
    }

    public static void ObtenerPuntaje(List<Pronostico> pronosticos,List<Partido> resultados) {
        int puntaje = 0;
        for (int i = 0 ; i < pronosticos.size() ; i++) {
            if (pronosticos.get(i).getGanador() == resultados.get(i).getGanador()) {
                puntaje++;
            }
        }
        System.out.println("Tu puntaje es: " + puntaje);
    }
}