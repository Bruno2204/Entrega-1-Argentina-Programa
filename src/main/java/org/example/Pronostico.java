package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class Pronostico {
    @CsvBindByPosition(position = 0)
    String equipo1;
    @CsvBindByPosition(position = 1)
    int ganador;
    @CsvBindByPosition(position = 2)
    String equipo2;
}
