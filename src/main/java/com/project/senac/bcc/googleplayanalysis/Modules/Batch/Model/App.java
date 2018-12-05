package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class App {

    public App() {
    }

    public App(String name, Double rating, Category category, Integer reviewsQty, String size, String installsQty, Type type, Double price, String contentRating, List<Genry> genry, Date lastUpdate, String version, AndroidVersion androidVersion) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer reviewsQty;

    private String size;

    private String installsQty;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private Type type;

    private Double price;

    private String contentRating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "app_genry", joinColumns = { @JoinColumn(name = "app_id") }, inverseJoinColumns = { @JoinColumn(name = "genry_id") })
    private List<Genry> genry;

    @org.hibernate.annotations.Type(type="date")
    private Date lastUpdate;

    private String version;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "android_version_id")
    private AndroidVersion androidVersion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getReviewsQty() {
        return reviewsQty;
    }

    public void setReviewsQty(Integer reviewsQty) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public List<Genry> getGenry() {
        return genry;
    }

    public void setGenry(List<Genry> genry) {
        this.genry = genry;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AndroidVersion getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(AndroidVersion androidVersion) {
        this.androidVersion = androidVersion;
    }


    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", category=" + category.toString() +
                ", reviewsQty=" + reviewsQty +
                ", size='" + size + '\'' +
                ", installsQty='" + installsQty + '\'' +
                ", type=" + type.toString() +
                ", price='" + price + '\'' +
                ", contentRating='" + contentRating + '\'' +
                ", genry=" + genry.toString() +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", version='" + version + '\'' +
                ", androidVersion=" + androidVersion.toString() +
                "}\n";
    }
}
