/*
#ProProgrammer
*/
package newpackage;

import java.time.LocalDate;
import java.time.LocalTime;


public class Messung {
    private LocalDate date;
    private LocalTime time;
    private String kennz;
    private Double gemessen;
    private Double erlaubt;
    private Double übertretung;

    public Messung(LocalDate date, LocalTime time, String kennz, Double gemessen, Double erlaubt) {
        this.date = date;
        this.time = time;
        this.kennz = kennz;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
        this.übertretung = gemessen-erlaubt;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getKennz() {
        return kennz;
    }

    public Double getGemessen() {
        return gemessen;
    }

    public Double getErlaubt() {
        return erlaubt;
    }

    public Double getÜbertretung() {
        return übertretung;
    }
    
    
    
}
