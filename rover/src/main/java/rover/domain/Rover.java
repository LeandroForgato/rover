package rover.domain;

public class Rover {

    Integer x = 0;
    Integer y = 0;
    Integer facing = 1;
    Integer px = 0;
    Integer py = 0;

    public Rover() {}

    public void setPlateau(Integer px, Integer py) {
        this.px = px;
        this.py = py;
    }

    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public void move(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            move(commands.charAt(i));
        }
    }

    private void move(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        }
    }

    private void move() {
        if (facing == 1) {
            this.y++;
        } else if (facing == 2) {
            this.x++;
        } else if (facing == 3) {
            this.y--;
        } else if (facing == 4) {
            this.x--;
        }
    }

    private void turnLeft() {
        facing = (facing - 1) < 1 ? 4 : facing - 1;
    }

    private void turnRight() {
        facing = (facing + 1) > 4 ? 1 : facing + 1;
    }


    public String printPosition() {
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }

        String resp = x + " " + y + " " + dir;

        if (x > px || x < 0 || y > py || y < 0) {
            resp = "Rover left the area of ​​the plateau";
        }
        return resp;
    }



}
