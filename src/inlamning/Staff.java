package inlamning;

public class Staff {
    private final int id;

    public Staff(int id) {
        this.id = id;
    }

    public void quit() {
        System.out.println("Staff #" + id + " has quit for the day.");
    }

    public int getId() {
        return id;
    }
}