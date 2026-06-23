public class DataBundle {
    double bundleSize;
    double bundlePrice;
    int bundleDuration;

    public DataBundle(double bundleSize, double bundlePrice, int bundleDuration) {
        this.bundleSize = bundleSize;
        this.bundlePrice = bundlePrice;
        this.bundleDuration = bundleDuration;
    }
    public String describe(){
        return "%.02fGB @ %.02f - %s days".formatted(this.bundleSize, this.bundlePrice, this.bundleDuration);
    }
}
