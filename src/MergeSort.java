import java.util.Scanner;

public class MergeSort {
    // Method Fungsi Merge Sort
    public static void sort(int[] a, int awal, int akhir) {
        int N = akhir - awal;
        int tengah = awal + N / 2; // pemisahan menjadi 2 sub array
        // jika data sudah menjadi satuan
        if (N <= 1)
            // langsung kembalikan arraynya
            return;

        // Pengurutan secara rekursif
        sort(a, awal, tengah); // Pengurutan bagian pertama (kiri)
        sort(a, tengah, akhir); // Pengurutan bagian kedua (kanan)

        // memisahkan 2 sub array yang berurutan
        // temp array untuk menyimpan data yang disorting
        int[] temp = new int[N];
        int i = awal;
        int j = tengah;
        // isi array sisi kiri dan kanan
        for (int k = 0; k < N; k++) {
            if (i == tengah)
                temp[k] = a[j++];
            else if (j == akhir)
                temp[k] = a[i++];
            else if (a[j] < a[i])
                temp[k] = a[j++];
            else
                temp[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[awal + k] = temp[k];
    }

    // Main method
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("\n=====PROGRAM SORTING MERGE SORT=====\n");
            int n, i;

            // Memasukan jumlah data array yang diinginkan
            System.out.println("Masukan jumlah element array : ");
            n = scan.nextInt();
            // Membuat integer array di data n
            int arr[] = new int[n];
            // Menerima data (nilai-nilai dalam array)
            System.out.println("\nMasukan nilai " + n + " element integer");
            for (i = 0; i < n; i++)
                arr[i] = scan.nextInt();

            // Memanggil metode sorting (Merge Sort)
            sort(arr, 0, n);

            // Menampilkan data array yang sudah diurutkan
            System.out.println("\nElement array setelah diurutkan : ");
            for (i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();

            System.out.println("=====TERIMAKASIH=====");
        }
    }
}