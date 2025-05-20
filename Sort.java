package sapXepp;

import java.util.Scanner;

public class Sort {

    public static int[] nhapMang(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // MERGE SORT
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // HEAP SORT
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort sorter = new Sort();

        System.out.print("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();
        int[] arr = nhapMang(n);

        System.out.println("\nChon kieu sap xep:");
        System.out.println("1. Merge Sort");
        System.out.println("2. Heap Sort");
        System.out.print("Lua chon cua ban: ");
        int choice = sc.nextInt();

        System.out.println("\nMang ban dau:");
        sorter.display(arr);

        if (choice == 1) {
            mergeSort(arr, 0, arr.length - 1);
            System.out.println("Mang sau khi sap xep (Merge Sort):");
        } else if (choice == 2) {
            heapSort(arr);
            System.out.println("Mang sau khi sap xep (Heap Sort):");
        } else {
            System.out.println("Lua chon khong hop le.");
            return;
        }

        sorter.display(arr);
        sc.close();
    }
}
