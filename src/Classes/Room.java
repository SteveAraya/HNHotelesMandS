
package Classes;

/**
 *
 * @author Steve and Marcos
 */
public class Room {
    
    private int number;
    private String type;
    private int floorNumber;
    private int capacity;
    private String roomSize;
    private String bedType;
    private String description;
    private String roomAttractive;

    public Room(int number, String type, int floorNumber, int capacity, String roomSize, String bedType, String description, String roomAttractive) {
        this.number = number;
        this.type = type;
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.roomSize = roomSize;
        this.bedType = bedType;
        this.description = description;
        this.roomAttractive = roomAttractive;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoomAttractive() {
        return roomAttractive;
    }

    public void setRoomAttractive(String roomAttractive) {
        this.roomAttractive = roomAttractive;
    }

   
}