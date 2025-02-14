import java.util.ArrayList;
import java.util.Scanner;

public class KafeMenu {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        String[] menuNama = {  
                "Nasi Goreng", "Mie Goreng", "Roti Bakar", 
                "Kentang Goreng", "Teh Tarik", "Cappucino", "Chocolate Ice"  
        }; 
        int[] menuHarga = {20000, 15000, 12000, 10000, 8000, 20000, 25000}; 

        ArrayList<String> pesananNama = new ArrayList<>(); 
        ArrayList<Integer> pesananJumlah = new ArrayList<>();
        ArrayList<Integer> pesananHarga = new ArrayList<>();

        boolean isRunning = true;

        System.out.println("=== Selamat Datang di ByCafe ===");
        System.out.println("");
        for (int i = 0; i < menuNama.length; i++) {
            System.out.println((i + 1) + ". " + menuNama[i] + " - Rp" + menuHarga[i]);
            // System.out.println("");
        }

        while (isRunning) {

            System.out.println("");
            System.out.println("Pilih opsi berikut:");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Lihat Daftar Pesanan");
            System.out.println("3. Hitung Total Biaya");
            System.out.println("4. Selesai");
            System.out.print("Masukkan pilihan Anda: ");

            int pilihan = user.nextInt();
            user.nextLine();

            if (pilihan == 1) {

                System.out.print("Masukkan nomor menu yang ingin dipesan: ");
                int nomorMenu = user.nextInt();
                if (nomorMenu < 1 || nomorMenu > menuNama.length) {
                    System.out.println("Nomor menu tidak valid.");
                    continue;
                }

                System.out.print("Masukkan jumlah pesanan: ");
                int jumlah = user.nextInt();
                if (jumlah <= 0) {
                    System.out.println("Jumlah pesanan harus lebih dari 0.");
                    continue;
                }

                pesananNama.add(menuNama[nomorMenu - 1]);
                pesananJumlah.add(jumlah);
                pesananHarga.add(menuHarga[nomorMenu - 1]);

                System.out.println(jumlah + " " + menuNama[nomorMenu - 1] + " berhasil ditambahkan ke pesanan.");
                System.out.println("");

            } else if (pilihan == 2) {
                System.out.println("\n=== Daftar Pesanan ===");
                if (pesananNama.isEmpty()) {
                    System.out.println("Belum ada pesanan.");
                    System.out.println("");
                } else {
                    for (int i = 0; i < pesananNama.size(); i++) {
                        System.out.println((i + 1) + ". " + pesananNama.get(i) + " x" + pesananJumlah.get(i));
                        System.out.println("");
                    }
                }

            } else if (pilihan == 3) {
                int total = 0;
                for (int i = 0; i < pesananNama.size(); i++) {
                    total += pesananJumlah.get(i) * pesananHarga.get(i);
                }

                System.out.println("\n=== Total Biaya ===");
                System.out.println("Total yang harus dibayar: Rp" + total);
                System.out.println("");

            } else if (pilihan == 4) {

                System.out.println("Terima kasih telah berkunjung ke kafe kami!");
                isRunning = false;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        user.close();
    }
}
