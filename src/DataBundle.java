public class DataBundle {
    double bundleSize;
    double bundlePrice;
    int bundleDuration;

    public DataBundle(double bundleSize, double bundlePrice, int bundleDuration) {
        this.bundleSize = bundleSize;
        this.bundlePrice = bundlePrice;
        this.bundleDuration = bundleDuration;
    }
    public void describe(DataBundle bundle){
        System.out.printf("%.02fGB @ %.02f - %s days", this.bundleSize, this.bundlePrice, this.bundleDuration);
    }
}
