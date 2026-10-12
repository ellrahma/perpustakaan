// Mengelola daftar buku menggunakan Single Linked List
class LinkedList {
    private Node head;
    private int jumlah;

    // Menambahkan buku di akhir daftar
    public boolean tambahBuku(String kode, String judul, String penulis) {
        // Mencegah kode buku yang sama
        if (cariBuku(kode) != null) {
            return false;
        }

        Node baru = new Node(kode, judul, penulis);

        if (head == null) {
            head = baru;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = baru;
        }

        jumlah++;
        return true;
    }

    // Menghapus buku terakhir
    public boolean hapusBuku() {
        if (head == null) {
            return false;
        }

        // Jika hanya ada satu buku
        if (head.next == null) {
            head = null;
        } else {
            Node current = head;

            // Berhenti di node sebelum node terakhir
            while (current.next.next != null) {
                current = current.next;
            }

            current.next = null;
        }

        jumlah--;
        return true;
    }

    // Mencari buku berdasarkan kode
    public Node cariBuku(String kode) {
        Node current = head;

        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kode)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // Menampilkan buku sesuai urutan input dan jumlahnya
    public void tampilkanSemua() {
        System.out.println("\n===== DAFTAR BUKU =====");

        if (head == null) {
            System.out.println("Daftar buku kosong.");
            System.out.println("Total Buku: 0");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(
                "Kode: " + current.kodeBuku
                + " | Judul: " + current.judul
                + " | Penulis: " + current.penulis
            );

            current = current.next;
        }

        System.out.println("Total Buku: " + jumlah);
    }

    // Mengembalikan jumlah buku saat ini
    public int getJumlah() {
        return jumlah;
    }
}