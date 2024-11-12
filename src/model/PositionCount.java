// src/model/PositionCount.java

package model;

public class PositionCount {
    private String position;
    private int count;

    public PositionCount() {}

    public PositionCount(String position, int count) {
        this.position = position;
        this.count = count;
    }

    // Getters and Setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
