public class Members {
    String name;
    int age;
    int time;

    public Members(String name, int age, int time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Members{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", time=" + time +
                '}';
    }
}
