public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;
    
    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }
    
    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }
    
    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                    nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]
                );
            }
        }
    }
    
    public boolean isOutOfStock(int id) {
        return stok[id] == 0;
    }
    
    public static void nextId() {
        id++;
    }

    public int getStok(int id) {
        return this.stok[id];
    }

    public void setStok(int id, int stok) {
        if (stok>=0) {
            this.stok[id] = stok;    
        } else {
            System.out.println("Stok tidak boleh negatif");
        }
    }

    public void pesanMakanan(int id, int jumlahPesan){
        if (jumlahPesan>this.stok[id]) {
            System.out.println("Tidak memiliki Stok " + nama_makanan[id] + " Sebanyak itu!");
        } else {
            int negStok = getStok(id) - jumlahPesan;
            setStok(id, negStok);
            System.out.println("Berhasil dipesan: " + nama_makanan[id] + " Stok tersisa:" + getStok(id));
        }
    }
}