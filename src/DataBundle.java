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
        return "\t%-9.02f  \t@ %-10.02f - \t%s days".formatted(this.bundleSize, this.bundlePrice, this.bundleDuration);
    }

    public double getBundleSize() {
        return bundleSize;
    }

    public void setBundleSize(double bundleSize) {
        this.bundleSize = bundleSize;
    }

    public double getBundlePrice() {
        return bundlePrice;
    }

    public void setBundlePrice(double bundlePrice) {
        this.bundlePrice = bundlePrice;
    }

    public int getBundleDuration() {
        return bundleDuration;
    }

    public void setBundleDuration(int bundleDuration) {
        this.bundleDuration = bundleDuration;
    }
}
