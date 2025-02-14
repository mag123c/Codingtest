class ProductOfNumbers {
    public List<Integer> product;

    public ProductOfNumbers() {
        product = new ArrayList<Integer>();
        product.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            product.clear();
            product.add(1);
        }
        else  {
            product.add(product.get(product.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = product.size();
        if (k >= size) {
            return 0;
        }
        return product.get(size - 1) / product.get(size - k - 1);
    }
}