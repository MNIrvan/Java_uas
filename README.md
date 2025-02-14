import java.util.ArrayList; // untuk memanggil fungsi ArrayList(Framework Array), digunakan untuk menyimpan kumpulan array dan dapat menyesuaikan ukurannya secara otomatis jika di tambahkan atau dihapus
import java.util.Scanner; // untuk memanggil fungsi dari Scanner, digunakan untuk membaca input dari berbagai sumber

public class cafe2 { // deklarasi class
    public static void main(String[] args) {  // deklarasi main
        Scanner user = new Scanner(System.in); // menciptakan sebuah variable scanner(user) yang dapat membaca input dari user

        String[] menuNama = {  // variabel Array menuNama = untuk menyimpan elemen array yang ditujukan untuk menu dari cafe.
                "Nasi Goreng", "Mie Goreng", "Roti Bakar", 
                "Kentang Goreng", "Teh Tarik", "Cappucino", "Chocolate Ice"  
        }; 
        int[] menuHarga = {20000, 15000, 12000, 10000, 8000, 20000, 25000}; // variabel Array menampung array Harga

        ArrayList<String> pesananNama = new ArrayList<>(); // variabel ArrayList PesananNama = ArrayList adalah struktur data untuk menyimpan sekumpulan elemen. 
        ArrayList<Integer> pesananJumlah = new ArrayList<>(); // variabel ArrayList PesananJumlah
        ArrayList<Integer> pesananHarga = new ArrayList<>(); // variabel ArrayList PesananHarga

        boolean isRunning = true; // variabel isRunning = true untuk mengaktifkan perulangan while

        System.out.println("=== Selamat Datang di ByCafe ==="); // menampilkan pesan selamat datang di ByCafe
        System.out.println(""); // menampilkan spasi kosong
        for (int i = 0; i < menuNama.length; i++) { // perulangan for untuk menampilkan menu
            System.out.println((i + 1) + ". " + menuNama[i] + " - Rp" + menuHarga[i]); // menampilkan menu dengan harga
        }

        while (isRunning) { // perulangan while untuk meminta input user

            System.out.println(""); // menampilkan spasi kosong
            System.out.println("Pilih opsi berikut:"); // menampilkan opsi
            System.out.println("1. Tambah Pesanan"); // menampilkan opsi 1
            System.out.println("2. Lihat Daftar Pesanan"); // menampilkan opsi 2
            System.out.println("3. Hitung Total Biaya"); // menampilkan opsi 3
            System.out.println("4. Selesai"); // menampilkan opsi 4
            System.out.print("Masukkan pilihan Anda: "); // menampilkan input user

            int pilihan = user.nextInt(); // mengambil input user dan menyimpannya ke variabel pilihan
            user.nextLine(); // mengosongkan buffer input user

            if (pilihan == 1) { // jika user memilih opsi 1

                System.out.print("Masukkan nomor menu yang ingin dipesan: "); // meminta input nomor menu
                int nomorMenu = user.nextInt(); // input nomor menu
                if (nomorMenu < 1 || nomorMenu > menuNama.length) { // jika nomor menu tidak valid
                    System.out.println("Nomor menu tidak valid."); // menampilkan pesan error 
                    continue; // melanjutkan ke perulangan while berikutnya
                }

                System.out.print("Masukkan jumlah pesanan: "); // meminta input jumlah pesanan
                int jumlah = user.nextInt(); // input jumlah pesanan
                if (jumlah <= 0) { // jika jumlah pesanan tidak valid
                    System.out.println("Jumlah pesanan harus lebih dari 0."); // menampilkan pesan error
                    continue; // melanjutkan ke perulangan while
                }

                pesananNama.add(menuNama[nomorMenu - 1]); // menambahkan nama menu ke ArrayList PesananNama
                pesananJumlah.add(jumlah); // menambahkan jumlah pesanan ke ArrayList PesananJumlah
                pesananHarga.add(menuHarga[nomorMenu - 1]); // menambahkan harga menu ke ArrayList PesananHarga

                System.out.println(jumlah + " " + menuNama[nomorMenu - 1] + " berhasil ditambahkan ke pesanan."); // menampilkan pesan berhasil menambahkan pesanan, - 1 = nilai indeks array yang dimulai/dikurangi dari 0
                System.out.println(""); // menampilkan spasi kosong

            } else if (pilihan == 2) { // jika user memilih opsi 2
                System.out.println("=== Daftar Pesanan ==="); // menampilkan judul daftar pesanan
                if (pesananNama.isEmpty()) { // jika ArrayList PesananNama kosong
                    System.out.println("Belum ada pesanan."); // menampilkan pesan bahwa belum ada pesanan
                    System.out.println(""); // menampilkan spasi kosong
                } else { // jika ArrayList PesananNama tidak kosong
                    for (int i = 0; i < pesananNama.size(); i++) { // perulangan for untuk menampilkan daftar pesanan
                        System.out.println((i + 1) + ". " + pesananNama.get(i) + " x" + pesananJumlah.get(i)); // menampilkan daftar pesanan dengan jumlah. get() digunakan untuk mengakses nilai dari ArrayList. i + 1 = nilai indeks array yang dimulai/ditambah 1.
                    }
                }

            } else if (pilihan == 3) { // jika user memilih opsi 3
                int total = 0; // variabel untuk menampung total biaya
                for (int i = 0; i < pesananNama.size(); i++) { // perulangan for untuk menghitung total biaya
                    total += pesananJumlah.get(i) * pesananHarga.get(i); // menghitung total biaya dengan mengalikan jumlah pesanan dengan harga menu
                }

                System.out.println("\n=== Total Biaya ==="); // menampilkan judul total biaya
                System.out.println("Total yang harus dibayar: Rp" + total); // menampilkan total biaya yang harus dibayar
                System.out.println(""); // menampilkan spasi kosong

            } else if (pilihan == 4) { // jika user memilih opsi 4

                System.out.println("Terima kasih telah berkunjung ke kafe kami!"); // menampilkan pesan terima kasih
                isRunning = false; // menghentikan perulangan while
            } else { // jika user memilih opsi lainnya
                System.out.println("Pilihan tidak valid. Silakan coba lagi."); // menampilkan pesan error jika pilihan tidak valid
            }
        }

        user.close(); // inputan di tutup 
    }
}
