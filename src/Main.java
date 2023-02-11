import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<Taxi> taxi_drivers = new ArrayList<>();
    static List<Transaksi> transaksiList = new ArrayList<>();

    public static void main(String[] args){

        int pilihan =0;

        // Hard code insert data driver
        taxi_drivers.add(new Taxi("DRI-1234","B 1234 OK", "Tono"));
        taxi_drivers.add(new Taxi("DRI-1235","B 4321 OK", "Toni"));

        // Memanggil method menu
        menu();

        // Looping selama program dijalankan
        do{
            System.out.println();
            System.out.print("Masukkan pilihan: ");
            pilihan = sc.nextInt();
            while(pilihan<1 || pilihan>5){
                System.out.print("Masukkan pilihan: ");
                pilihan = sc.nextInt();
            }

            sc.nextLine();

            if(pilihan == 1)
                driver();           // Memanggil method driver
            else if(pilihan == 2)
                register_taxi();    // Memanggil method register_taxi
            else if(pilihan == 3)
                listDriver();       // Memanggil method listDriver
            else if(pilihan == 4)
                laporanTransaksi(); // Memanggil method laporan transaksi

        }while (pilihan!=5);        // program berhenti
    }

    // Menampilkan menu dalam program
    static void menu(){
        System.out.println("Selamat datang di CabCab!");
        System.out.println("=============================");
        System.out.println("1. Login sebagai Driver");
        System.out.println("2. Registrasi Taxi");
        System.out.println("3. List Daftar Driver");
        System.out.println("4. Laporan Transaksi");
        System.out.println("5. Keluar");
    }

    // Method driver
    // digunakan untuk menambahkan transaksi
    static void driver(){
        String lokasiAsal, lokasiTujuan;
        double kmDitempuh, waktuPerjalanan;
        System.out.println();

        System.out.print("Masukkan ID kendaraan: ");
        String idTaxi= sc.next();
        if(!check_registered(taxi_drivers, idTaxi)){
            System.out.println("Taxi tidak terdaftar.");
        }
        sc.nextLine();
        while (check_registered(taxi_drivers, idTaxi)){

            System.out.print("Ambil penumpang? [y/n]: ");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("y")){

                System.out.print("Lokasi Asal                   : ");
                lokasiAsal = sc.nextLine();

                System.out.print("Lokasi Tujuan                 : ");
                lokasiTujuan= sc.nextLine();

                System.out.print("Km yang Ditempuh              : ");
                kmDitempuh = sc.nextDouble();

                System.out.print("Lama Perjalanan (dalam jam)   : ");
                waktuPerjalanan = sc.nextDouble();

                sc.nextLine();
                transaksiList.add(new Transaksi(idTaxi,lokasiAsal,lokasiTujuan,kmDitempuh,waktuPerjalanan));
            }
            else{
                break;
            }
        }
    }

    // Digunakan untuk menampilkan list semua driver yang terdaftar
    static void listDriver(){
        int j=1;
        for(int i=0; i<taxi_drivers.size(); i++){
            System.out.println(j + ". Nama Driver: "+taxi_drivers.get(i).namaDriver);
            System.out.println("Plat kendaraan : "+taxi_drivers.get(i).platNomor);
            j++;
        }
    }

    // Digunakan untuk menambahkan driver baru
    static void register_taxi(){
        String plat, nama;
        System.out.print("Masukkan plat kendaraan   : ");
        plat = sc.nextLine();
        System.out.print("Masukkan nama Driver    : ");
        nama = sc.nextLine();

        Taxi taxi= new Taxi(plat,nama);
        taxi_drivers.add(taxi);
        System.out.println("Driver berhasil didaftarkan dengan ID "+ taxi.idTaxi);
    }

    // Menampilkan laporan transaksi yang berisi semua transaksi
    // Dan juga total pendapatan yang diperoleh
    static void laporanTransaksi(){
        int j =1;
        if(transaksiList.isEmpty()){
            System.out.println("Belum ada transaksi!");
        }else{
            for(int i=0; i<transaksiList.size(); i++){
                System.out.println(j + ". Nama Driver: "+searchDriverName(transaksiList.get(i).idTaxi));
                System.out.println("Lokasi Awal : "+transaksiList.get(i).lokasiAsal);
                System.out.println("Lokasi Tujuan : "+transaksiList.get(i).lokasiTujuan);
                System.out.println("Tarif : "+transaksiList.get(i).totalbiayaDibayar);
                System.out.println();
                j++;
            }
            System.out.println("Total Pendapatan : "+totalPendapatan());
        }
    }

    // Mencari total pendapatan
    static double totalPendapatan(){
        double totalPendapatan=0;
        for(int i=0; i<transaksiList.size(); i++){
            totalPendapatan += transaksiList.get(i).totalbiayaDibayar; // total pendapatan diperoleh dengan menambahkan semua tarif transaksi
        }
        return totalPendapatan;
    }

    static String searchDriverName(String idTaxi){
        String nama="";
        for(int i=0; i<taxi_drivers.size(); i++){
            if(taxi_drivers.get(i).idTaxi.equalsIgnoreCase(idTaxi))
                nama = taxi_drivers.get(i).namaDriver;
        }
        return nama;
    }

    static boolean check_registered(List<Taxi> data_taxi, String idTaxi){
        boolean registered=false;

        for (int i=0; i<data_taxi.size(); i++){
            if (data_taxi.get(i).idTaxi.equalsIgnoreCase(idTaxi))
                registered = true;
        }
        return registered;
    }
}
