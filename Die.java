//********************************************************************
//  Die.java       
//
//  Represents one die (singular of dice) with faces showing values
//  between 1 and 6.
//********************************************************************
import java.util.Random;

public class Die
{
    private final int MAX = 6;  // maximum face value

    private int faceValue;  // current value showing on the die

    //-----------------------------------------------------------------
    //  Constructor: Sets the initial face value.
    //-----------------------------------------------------------------
    public Die()
    {
        faceValue = 1;
    }

    //-----------------------------------------------------------------
    //  Rolls the die and returns the result.
    //-----------------------------------------------------------------
    public int roll()
    {
        Random generator = new Random();
        faceValue = generator.nextInt(MAX) + 1;

        return faceValue;
    }

    //-----------------------------------------------------------------
    //  Face value mutator.
    //-----------------------------------------------------------------
    public void setFaceValue(int value)
    {
        if((value>=1)&&(value<=MAX))
           faceValue = value;
    }

    //-----------------------------------------------------------------
    //  Face value accessor.
    //-----------------------------------------------------------------
    public int getFaceValue()
    {
        return faceValue;
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of this die.
    //-----------------------------------------------------------------
    public String toString()
    {
        String result = Integer.toString(faceValue);
        return result;
    }
}
