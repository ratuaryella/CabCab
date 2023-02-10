public class Transaksi {

    String idTaxi;
    String lokasiAsal;
    String lokasiTujuan;
    Double biayaJam;
    Double biayaKm;
    Double km;
    Double jam;
    Double totalkm;
    Double totaljam;

    Double totalbiayaDibayar;
    Double totalTagihan;

    final Double biayaperKm = 4500.0;
    final Double biayaperJam = 45000.0;

    public Transaksi(String idTaxi, String lokasiAsal, String lokasiTujuan, Double km, Double jam) {
        Double totalbiayaJam = biayaperKm * km;
        Double totalbiayaKm = biayaperJam * jam;

        this.idTaxi = idTaxi;
        this.lokasiAsal = lokasiAsal;
        this.lokasiTujuan = lokasiTujuan;
        this.km = km;
        this.jam = jam;

        if (totalbiayaKm > totalbiayaJam)
            this.totalbiayaDibayar = totalbiayaKm;
        else
            this.totalbiayaDibayar = totalbiayaJam;
    }
}
