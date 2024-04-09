package entities;

public enum Star {
	ONE("One"),
    TWO("Two"),
    THREE("Three");

    private String label;

    private Star(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
