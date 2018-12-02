package com.project.senac.bcc.googleplayanalysis.Modules.Batch.vo;

public class AppVO {

    public AppVO() {
    }

    public AppVO(String name, String rating, String category, String reviewsQty, String size, String installsQty, String type, String price, String contentRating, String genry, String lastUpdate, String version, String androidVersion) {
        this.name = name;
        this.rating = rating;
        this.category = category;
        this.reviewsQty = reviewsQty;
        this.size = size;
        this.installsQty = installsQty;
        this.type = type;
        this.price = price;
        this.contentRating = contentRating;
        this.genry = genry;
        this.lastUpdate = lastUpdate;
        this.version = version;
        this.androidVersion = androidVersion;
    }

    private String name;

    private String rating;

    private String category;

    private String reviewsQty;

    private String size;

    private String installsQty;

    private String type;

    private String price;

    private String contentRating;

    private String genry;

    private String lastUpdate;

    private String version;

    private String androidVersion;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReviewsQty() {
        return reviewsQty;
    }

    public void setReviewsQty(String reviewsQty) {
        this.reviewsQty = reviewsQty;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInstallsQty() {
        return installsQty;
    }

    public void setInstallsQty(String installsQty) {
        this.installsQty = installsQty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getGenry() {
        return genry;
    }

    public void setGenry(String genry) {
        this.genry = genry;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    @Override
    public String toString() {
        return "AppVO{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                ", reviewsQty=" + reviewsQty +
                ", size='" + size + '\'' +
                ", installsQty='" + installsQty + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", contentRating='" + contentRating + '\'' +
                ", genry='" + genry + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", version='" + version + '\'' +
                ", androidVersion='" + androidVersion + '\'' +
                '}';
    }
}
