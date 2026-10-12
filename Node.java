// Menyimpan data satu buku dan referensi ke node berikutnya
class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next;

    // Membuat node baru untuk menyimpan data buku
    Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}