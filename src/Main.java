public class Main {
    public static void main(String[] args){
        Course course = new Course("1", 1600);
        Team team = new Team("team");
        team.showInfo();
        team.doIt(course);
    }
}
