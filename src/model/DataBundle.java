package model;

public class DataBundle {
    private double bundleSize;
    private double bundlePrice;
    private int bundleDuration;

    public DataBundle(double bundlePrice, double bundleSize, int bundleDuration) {
        this.bundlePrice = bundlePrice;
        this.bundleSize = bundleSize;
        this.bundleDuration = bundleDuration;
    }
    public String describe(){
        return "\tGHS%-7.02f\t@ %-7.02fGB -\t%s days".formatted(this.bundleSize, this.bundlePrice, this.bundleDuration);
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
