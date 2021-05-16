package ss11_map_tree.thuc_hanh.compare_comparator;

public class SimpsonCharacter implements Comparable<SimpsonCharacter> {
    private String name;

    public SimpsonCharacter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(SimpsonCharacter simpson) {
        return this.name.compareTo(simpson.name);
    }
}

