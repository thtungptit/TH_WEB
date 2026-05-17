package model;

public class House {
    private String id;
    private String address;
    private int area;
    private String type;
    private int sold;

    public House() {}

    public House(String id, String address, int area, String type, int sold) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.type = type;
        this.sold = sold;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getSold() { return sold; }
    public void setSold(int sold) { this.sold = sold; }
}