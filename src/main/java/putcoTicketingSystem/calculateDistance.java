package putcoTicketingSystem;

public class calculateDistance
{
    public double calculateDistanceBetweenPoints(double x1, double y1, double x2, double y2) {
        //create a hashmap,that has e.g "Midrand : x1=4,y1=9" and its corresponding location variable "x,y"
        //the calculateDistanceBetweenPoints will calculate the distance.
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}