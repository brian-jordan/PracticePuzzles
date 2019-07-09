public class BoundCircle {

    /**
     *On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
     *
     * "G": go straight 1 unit;
     * "L": turn 90 degrees to the left;
     * "R": turn 90 degress to the right.
     * The robot performs the instructions given in order, and repeats them forever.
     *
     * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
     *
     * Hint 1: Calculate the final vector of how the robot travels after executing all instructions once - it consists
     * of a change in position plus a change in direction.
     *
     * Hint 2: The robot stays in the circle iff (looking at the final vector) it changes direction (ie. doesn't stay
     * pointing north), or it moves 0.
     *
     * @author - Brian Jordan
     * @param instructions - String made up of only capital G, L, and R characters
     * @return - boolean value of whether path makes a circle
     */
    public boolean isRobotBounded(String instructions) {
        int head = 90;
        int xPos = 0;
        int yPos = 0;

        char[] myChars = instructions.toCharArray();

        for (int i = 0; i < myChars.length; i++){
            if (myChars[i] == 'G'){
                if (head == 90){
                    yPos += 1;
                }
                else if (head == 180){
                    xPos -= 1;
                }
                else if (head == 270){
                    yPos -= 1;
                }
                else{
                    xPos += 1;
                }
            }
            else if (myChars[i] == 'L'){
                head += 90;
            }
            else {
                head -= 90;
            }
            head = head % 360;
        }

        if (head != 90 || (xPos == 0 && yPos == 0)){
            return true;
        }
        else return false;

    }

}
