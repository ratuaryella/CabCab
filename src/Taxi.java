import java.util.Random;

public class Taxi {
    String idTaxi;
    String platNomor;
    String namaDriver;


    public Taxi(String idTaxi, String platNomor, String namaDriver) {
        this.idTaxi = idTaxi;
        this.platNomor = platNomor;
        this.namaDriver = namaDriver;
    }

    Random random = new Random();
    public Taxi(String platNomor, String namaDriver) {
        String id = String.format("%04d", random.nextInt(10000));
        this.idTaxi= "DR-"+id;
        this.platNomor = platNomor;
        this.namaDriver = namaDriver;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public String getNamaDriver() {
        return namaDriver;
    }

    public void setNamaDriver(String namaDriver) {
        this.namaDriver = namaDriver;
    }



}
