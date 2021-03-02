
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private int g;
    private String gender;
    private int health;// a range between 0 - 100
    private int wins;
    private int battleCount;
    private static int population;
    
    
    /**
     * Default constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        this.type = "Dino";
        this.age = 0;
        // write code that will assign a gender to this dino. 
        // 50% should be male and 50% should be female. 
        if(Math.random() < 0.5)
            this.gender = "M";
        else
            this.gender = "F";
        
        this.health = 10;
    }
    
    /**
     * Explicit constructor for the Dino class.
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.health = 10;
        // write code to set gender to m/f 50%.
        if(Math.random() < 0.5)
            this.gender = "M";
        else
            this.gender = "F";
            
        this.wins = 0;
        this.battleCount = 0;
        Dinosaur.population++;
    }
    
    /*********   Getters   *****************/
    // Getters return the private instance data.
    public String getType()
    {
        return this.type;
    }
    public int getHealth()
    {
        return this.health;
    }
    public String getGender()
    {
        return this.gender;
    }
    public int getWins()
    {
        return this.wins;
    }
    public int getBattleCount()
    {
        return this.battleCount;
    }
    public int getAge()
    {
        return this.age;
    }
    public static int getPopulation()
    {
        return population;
    }
    /*********   Setters   *****************/
    public void setType(String t)
    {
        this.type = t;
    }
    public void setHealth(int h)
    {
        this.health = h;
    }
    public void setAge(int a)
    {
        this.age = a;
    }
    public void getGender(String g)
    {
        this.gender = g;
    }
    public void setWins(int w)
    {
        this.wins = 0;
    }
    public void setBattleCount(int bc)
    {
        this.battleCount = 0;
    }
    public boolean equals(Dinosaur d)
    {
        if(this.type.equals(d.getType()))
        {
            if(this.age == d.getAge())
            {
                if (this.health == d.getHealth())
                {
                    if(this.gender.equals(d.getGender()))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void ageUp()
    {
        if(this.health>0)
        {
            this.age++;
            if (this.age<10)
            {
                this.health = this.health+10;
            }
            else if (this.age>=25 && this.age <=30)
                this.health-=5;
            
            else if(this.age>30)  
                this.health-=10; 
        }
    }

    public double getBattleFactor(Dinosaur other)
    {
        double answer = 0;
        double hFactor = this.health/100.0;
        hFactor *= 0.67;
        
        double expFactor = (double)this.battleCount/(this.battleCount + other.getBattleCount());
        expFactor *=0.33;
        
        answer = hFactor + expFactor;
        
        return answer;
    }
    
    public void update (Dinosaur loser)
    {
        // reduce the health of the losing dino
        // increase the wins for "this" dino.
        // increase battleCount for both
        loser.setHealth(loser.getHealth()-20);
        if(loser.getHealth() <=0)
        {
            loser.setHealth(0);
        }
        
        this.wins++;
        this.battleCount++;
        loser.setBattleCount(loser.getBattleCount()+1);
        
    }
    
    public abstract boolean attack(Dinosaur other);
    
    /**
     * Return this Dino as a string
     */
    public String toString()
    {
        String answer = this.type + " " + this.age + " " + this.health+ " "+this.gender;
        return answer;
    }
}