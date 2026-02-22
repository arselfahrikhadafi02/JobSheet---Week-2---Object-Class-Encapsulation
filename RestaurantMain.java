public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);
        menu.tampilMenuMakanan();

        System.out.println("");
        menu.setStok(1, 10);
        System.out.println("Stok Spaghetti: " + menu.getStok(1));           // stok Spaghetti diubah menjadi 10
        menu.setStok(2, -1);
        System.out.println("Stok Tenderloin Steak: " + menu.getStok(2));    // tetap 30 karena stok tidak boleh negatif

        menu.pesanMakanan(1, 5);    // memesan 5 Spaghetti, stok Spaghetti menjadi 5
        menu.pesanMakanan(2, 40);   // memesan 40 Tenderloin Steak, stok tidak cukup, pesan gagal
    }
}