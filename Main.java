import java.util.Scanner;

public class Main {

    // Meminta input yang tidak boleh kosong
    static String inputWajib(Scanner sc, String pesan) {
        String hasil;

        do {
            System.out.print(pesan);
            hasil = sc.nextLine().trim();

            if (hasil.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
            }
        } while (hasil.isEmpty());

        return hasil;
    }

    // Menambahkan buku dengan validasi kode
    static void tambahBukuDenganValidasi(
            Scanner sc, LinkedList daftar) {

        String kode;

        while (true) {
            kode = inputWajib(
                sc, "Masukkan Kode Buku (maks. 5 karakter): "
            );

            if (kode.length() > 5) {
                System.out.println(
                    "Kode buku maksimal 5 karakter."
                );
            } else if (daftar.cariBuku(kode) != null) {
                System.out.println(
                    "Kode buku sudah digunakan."
                );
            } else {
                break;
            }
        }

        String judul = inputWajib(sc, "Masukkan Judul: ");
        String penulis = inputWajib(sc, "Masukkan Penulis: ");

        if (daftar.tambahBuku(kode, judul, penulis)) {
            System.out.println("Data berhasil ditambahkan!");
        } else {
            System.out.println("Data gagal ditambahkan.");
        }
    }

    // Menampilkan detail buku yang ditemukan
    static void tampilkanDetail(Node buku) {
        System.out.println("Kode   : " + buku.kodeBuku);
        System.out.println("Judul  : " + buku.judul);
        System.out.println("Penulis: " + buku.penulis);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilihan;

        // Menu utama
        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // Validasi pilihan berupa angka
            while (!sc.hasNextInt()) {
                System.out.println(
                    "Input harus berupa angka."
                );
                sc.nextLine();
                System.out.print("Pilih menu: ");
            }

            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahBukuDenganValidasi(sc, daftar);
                    break;

                case 2:
                    if (daftar.hapusBuku()) {
                        System.out.println(
                            "Buku terakhir berhasil dihapus."
                        );
                    } else {
                        System.out.println(
                            "Tidak ada data untuk dihapus."
                        );
                    }
                    break;

                case 3:
                    String kodeCari = inputWajib(
                        sc, "Masukkan Kode Buku: "
                    );

                    Node hasil = daftar.cariBuku(kodeCari);

                    if (hasil != null) {
                        System.out.println("Buku ditemukan:");
                        tampilkanDetail(hasil);
                    } else {
                        System.out.println(
                            "Buku tidak ditemukan."
                        );
                    }
                    break;

                case 4:
                    daftar.tampilkanSemua();

                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println(
                        "Menu tidak tersedia. Pilih angka 1-5."
                    );
            }

        } while (pilihan != 5);

        sc.close();
    }
}