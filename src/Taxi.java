import java.util.Random;

public class Taxi {
    String idTaxi;
    String platNomor;
    String namaDriver;

    // Constructor
    // digunakan ketika menambahkan data taxi secara hardcode
    public Taxi(String idTaxi, String platNomor, String namaDriver) {
        this.idTaxi = idTaxi;
        this.platNomor = platNomor;
        this.namaDriver = namaDriver;
    }

    Random random = new Random();

    // Constructor
    // digunakan untuk menambahkan driver baru berdasarkan inputan user
    public Taxi(String platNomor, String namaDriver) {
        // id akan dibuat dengan generate 4 digit random number
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
