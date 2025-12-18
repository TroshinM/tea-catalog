package com.teacatalog.tea_catalog.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tea")
public class Tea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sort;
    private String kind;
    private String additives;
    private String manufacturer;
    private Integer weight;
    private Double price;
    private String imageUrl;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
    public String getKind() { return kind; }
    public void setKind(String kind) { this.kind = kind; }
    public String getAdditives() { return additives; }
    public void setAdditives(String additives) { this.additives = additives; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
