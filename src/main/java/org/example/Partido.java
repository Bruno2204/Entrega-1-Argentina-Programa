package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class Partido {
//    @CsvBindByPosition(position = 0)
    Equipo equipo1;
//    @CsvBindByPosition(position = 1)
    int goles1;
//    @CsvBindByPosition(position = 2)
    int goles2;

//    @CsvBindByPosition(position = 3)
    Equipo equipo2;
    int ganador=0;


    public int getGanador() {
        if (goles1>goles2){
            this.ganador=1;
        } else if (goles2>goles1) {
            this.ganador=2;
        }
        return this.ganador;
    }

    public Partido(Equipo equipo1, int goles1, int goles2, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.goles1 = goles1;
        this.goles2 = goles2;
        this.equipo2 = equipo2;

    }
}
