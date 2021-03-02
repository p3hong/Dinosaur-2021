
/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten;

    /**
     * Constructor for objects of class TRex
     */
    public TRex()
    {
        //super() --> Must be the first line of a constructor
        super("TRex"); // Calls the default constructor of the parent class
        this.numEaten = 0;
    }
    
    public boolean attack(Dinosaur other)
    {
        int myRand = (int)(Math.random()*40)+60;
        int otherRand;
        
        int myWeighting;
        int otherWeighting;
        
        double temp;
        if(other.getType().equals("TRex"))
        {
            otherRand = (int)(Math.random()*40)+55;
        }
        else if(other.getType().equals("Velo"))
        {
            otherRand = (int)(Math.random()*40)+55;
        }
        else if(other.getType().equals("Bronta"))
        {
            otherRand = (int)(Math.random()*40)+55;
        }
        else
            otherRand = (int)(Math.random()*50);
        
        temp = myRand * this.getBattleFactor(other)+0.5;
        myWeighting = (int)(temp);
        temp = otherRand * other.getBattleFactor(this)+0.5;
        otherWeighting = (int)(temp);
        
        System.out.println("\tMy weighting: "+myWeighting);
        System.out.println("\tOther weighting: "+otherWeighting);
        
        if( myWeighting - otherWeighting > -1)
        
        {
            this.update(other);
            return true;
        }
        else
        {
            other.update(this);
            return false;
        }
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        if(this.getAge() ==0)
            return super.toString();// super. calls the method of the parent class
        else
            return this.getType() +" "+this.getHealth();
    }
}
