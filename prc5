public class Prime {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100); 
        }

        int primeCount = countPrimes(arr);
        int nonPrimeCount = countNonPrimes(arr);

        System.out.println("Count of Prime Numbers: " + primeCount);
        System.out.println("Count of Non-Prime Numbers: " + nonPrimeCount);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countPrimes(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }

    private static int countNonPrimes(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (!isPrime(num)) {
                count++;
            }
        }
        return count;
    }
}
