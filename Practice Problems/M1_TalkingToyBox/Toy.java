public abstract class Toy {
    private static int nextId = 1001;
    private final String toyId;

    protected Toy() {
        toyId = "TOY-" + nextId++;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}
