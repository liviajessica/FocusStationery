package id.ac.umn.focus_server.Model;

public class Focus {
    private String Name, Image, Description, Price, Discount, MenuId, FocusId, AvailabilityFlag;

    public Focus() {
    }

    public Focus(String name, String image, String description, String price, String discount, String menuId, String focusId, String availabilityFlag) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenuId = menuId;
        FocusId = focusId;
        AvailabilityFlag = availabilityFlag;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getFocusId() {
        return FocusId;
    }

    public void setFocusId(String focusId) {
        FocusId = focusId;
    }

    public String getAvailabilityFlag() {
        return AvailabilityFlag;
    }

    public void setAvailabilityFlag(String availabilityFlag) {
        AvailabilityFlag = availabilityFlag;
    }
}
