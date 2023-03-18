package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class Pronostico {
    @CsvBindByPosition(position = 0)
    private Equipo equipo1;
    @CsvBindByPosition(position = 1)
    public int ganador;
    @CsvBindByPosition(position = 2)
    private Equipo equipo2;

    public Pronostico(Equipo equipo1, int ganador,Equipo equipo2) {
        this.equipo1 = equipo1;
        this.ganador = ganador;
        this.equipo2 = equipo2;
    }
}
