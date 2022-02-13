package io.lian.entity;


/**
 * @author m809745357
 */
public class School {
    private int schNo;
    private String schName;
    private int schAge;

    @Override
    public String toString() {
        return "School{" +
                "schNo=" + schNo +
                ", schName='" + schName + '\'' +
                ", schAge=" + schAge +
                '}';
    }

    public int getSchNo() {
        return schNo;
    }

    public void setSchNo(int schNo) {
        this.schNo = schNo;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public void setSchAge(int schAge) {
        this.schAge = schAge;
    }
}
