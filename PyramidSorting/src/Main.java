import java.util.Random;

public class Main {

    public static void main(String args[]) {
        Random random = new Random();
        int size = 100; // Количество элементов в массиве
        int[] arr = generateRandomArray(random, size);
        printArray("Исходный массив:", arr);
        heapSort(arr);
        printArray("Отсортированный массив:", arr);


    }

    /**
     * Метод для сортировки массива с помощью пирамидальной сортировки.
     * @param arr Массив для сортировки.
     */
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи один за другим
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    /**
     * Метод для перегруппировки поддерева с корнем в узле i.
     * @param arr Массив.
     * @param n Размер кучи.
     * @param i Индекс корневого элемента поддерева.
     */
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Если правый потомок больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно перегруппировать поддерево
            heapify(arr, n, largest);
        }
    }

    /**
     * Метод для заполнения массива случайными значениями.
     * @param random Генератор случайных чисел.
     * @param n Количество элементов в массиве.
     * @return Заполненный массив случайными значениями.
     */
    private static int[] generateRandomArray(Random random, int n) {
        int arr[] = new int[n];

        // Заполнение массива случайными значениями
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100); // Генерирует случайное число от 0 до 99
        }
        return arr;
    }

    /**
     * Выводит массив на консоль с заданной меткой.
     *
     * @param label Метка (название) для вывода массива.
     * @param arr   Массив для вывода.
     */
    private static void printArray(String label, int[] arr) {
        System.out.println(label);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(); // Печатаем пустую строку для разделения
    }
}
