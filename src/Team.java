import java.util.Arrays;

public class Team {

    String nameTeam;
    Members[] Team1;

    public Team(String nameTeam){
        this.nameTeam = nameTeam;
        Team1 = new Members[4];
        Team1[0] = new Members("Иван",19,200);
        Team1[1] = new Members("Игорь",18,270);
        Team1[2] = new Members("Николай",32,210);
        Team1[3] = new Members("Сергей",25,180);
    }

    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Team{" +
                "nameTeam='" + nameTeam + '\'' +
                ", Team1=" + Arrays.toString(Team1) +
                '}';
    }

    public void doIt(Course course) {
        int sum = 0;
        for(int i = 0; i < Team1.length; i++) {
            sum+=Team1[i].time;
        }
        if (course.timeCourse < sum) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}
