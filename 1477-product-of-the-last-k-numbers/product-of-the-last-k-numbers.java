import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixProd;
    private int lastZeroIndex;

    public ProductOfNumbers() {
        prefixProd = new ArrayList<>();
        prefixProd.add(1); // Initialize with 1 for easy multiplication
        lastZeroIndex = -1; // Track the last zero occurrence
    }

    public void add(int num) {
        if (num == 0) {
            prefixProd.clear();
            prefixProd.add(1); // Reset with 1 to handle future multiplications
            lastZeroIndex = prefixProd.size() - 1;
        } else {
            int lastProduct = prefixProd.get(prefixProd.size() - 1);
            prefixProd.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProd.size();
        if (size - k - 1 < lastZeroIndex) {
            return 0; // If a zero was within the last k elements, return 0
        }
        return prefixProd.get(size - 1) / prefixProd.get(size - k - 1);
    }

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        
        productOfNumbers.add(0);        
        productOfNumbers.add(2);        
        productOfNumbers.add(5);        
        productOfNumbers.add(4);        
        System.out.println(productOfNumbers.getProduct(2)); // 20
        System.out.println(productOfNumbers.getProduct(3)); // 40
        System.out.println(productOfNumbers.getProduct(4)); // 0
        productOfNumbers.add(8);        
        System.out.println(productOfNumbers.getProduct(2)); // 32
    }
}
