import java.util.LinkedList;
class Cricketer
{ 
    public int matches;
    public int jerseyNumber;
    public String name;
    
    public String displayName()
    {
        return name;
    }

   public int displayMatches()
    {
       return matches;
    }
   public int displayJersey()
    {
        return jerseyNumber;
    }
}
interface IplPlayer
{
   public abstract int displayIplMatches();
  
}

interface GetCenturiesAndWickets
{
	public abstract int getNoOfCenturies();
    public abstract int getNoOfWickets();
}

interface CheckKeeper
{
	public abstract boolean keeper();
}

class Batsmen extends Cricketer implements GetCenturiesAndWickets ,IplPlayer, CheckKeeper
{
   private int noOfCenturies;
   private boolean isKeeper;
   private int iplMatches;
   public Batsmen(String name,int jerseyNumber, int matches,int noOfCenturies,  int iplMatches)
   {
       this.jerseyNumber=jerseyNumber;
       this.name=name;
       this.matches=matches;
       this.noOfCenturies=noOfCenturies;
       this.iplMatches=iplMatches;
   }
   public Batsmen(String name,int jerseyNumber, int matches,int noOfCenturies, int iplMatches,boolean isKeeper)
   {
       this.jerseyNumber=jerseyNumber;
       this.name=name;
       this.matches=matches;
       this.noOfCenturies=noOfCenturies;
       this.iplMatches=iplMatches;
       this.isKeeper=isKeeper;
   }
   public int getNoOfCenturies()
   {
       return this.noOfCenturies;
   }
   public int getNoOfWickets()
   {
       return 0;
   }
   public int displayIplMatches()
   {
	   return iplMatches;
   }
   public boolean keeper()
   {
	   return this.isKeeper;
   }
}
class Allrounder extends Batsmen
{
	 private int noOfCenturies;
	 private int iplMatches;
	
	   public Allrounder(String name,int jerseyNumber, int matches,int noOfCenturies,  int iplMatches)
	   {
		   super( name, jerseyNumber,  matches, noOfCenturies,  iplMatches);
	       this.jerseyNumber=jerseyNumber;
	       this.name=name;
	       this.matches=matches;
	       this.noOfCenturies=noOfCenturies;
	       this.iplMatches=iplMatches;
	   }
}
class Bowler extends Cricketer implements GetCenturiesAndWickets,IplPlayer
{
   private int noOfWickets;
   private int iplMatches;
   public Bowler(String name,int jerseyNumber, int matches,int getNoOfWickets,int iplMatches)
   {
       this.jerseyNumber=jerseyNumber;
       this.name=name;
       this.matches=matches;
       this.noOfWickets=getNoOfWickets;
       this.iplMatches=iplMatches;
   }
   
  
   public int getNoOfWickets()
   {
       return this.noOfWickets;
   }
   
    public int getNoOfCenturies()
   {
      return 0;
   }
    public int displayIplMatches()
    {
 	   return iplMatches;
    }
}

//class AllRounder extends Batsmen

interface Country
{
	public abstract void displayPlayers();
}

class India implements Country
{
     LinkedList<Batsmen> BatsMen;
      LinkedList<Bowler> BowLer;
     public India(LinkedList<Batsmen> BatsMen, LinkedList<Bowler> BowLer)
     {
         this.BatsMen=BatsMen;
         this.BowLer=BowLer;
     }
     
     public void displayPlayers()
     {
         System.out.println("The batsmens are:\n");
         System.out.println("Name "+"JerseyNo "+"Matches "+"Centuries "+" Ipl Matches "+" Keeper");
         for(int i=0;i<BatsMen.size();i++)
         {
            System.out.println(BatsMen.get(i).displayName()+"  "+BatsMen.get(i).displayJersey()+
            		"     "+BatsMen.get(i).displayMatches()+"      "+BatsMen.get(i).getNoOfCenturies()+
            		"            "+BatsMen.get(i).displayIplMatches()+"      "+BatsMen.get(i).keeper());
         }
         
         System.out.println();
         
         System.out.println("The bowlers are:\n");
         System.out.println("Name "+"JerseyNo "+"Matches "+"Wickets "+" Ipl Matches ");
         for(int i=0;i<BowLer.size();i++)
         {
            System.out.println(BowLer.get(i).displayName()+"  "+BowLer.get(i).displayJersey()+
            		"     "+BowLer.get(i).displayMatches()+"      "+BowLer.get(i).getNoOfWickets()+
            		"            "+BowLer.get(i).displayIplMatches());
         }
     }
     
}

public class SOLID
{
    public static void main(String[] args)
    {
    LinkedList<Batsmen> BatsMen=new LinkedList<Batsmen>();
    
  //restricting 6 batsmens
    BatsMen.add(new Batsmen("Rohit",12,250,60,8));
    BatsMen.add(new Batsmen("Dhawan",11,250,60,9));
    BatsMen.add(new Batsmen("Virat",18,250,70,7));
    BatsMen.add(new Batsmen("Rahul",12,250,40,8));
    BatsMen.add(new Batsmen("Dhoni",12,330,55,9,true));
    BatsMen.add(new Allrounder("Hardik",12,123,34,9));
    
    LinkedList<Bowler> BowLer=new LinkedList<Bowler>();
   
    //restricting 5 bowlers
    BowLer.add(new Bowler("Chahal",23,345,123,7));
    BowLer.add(new Bowler("Kuldeep",24,348,456,8));
    BowLer.add(new Bowler("Umesh",23,345,123,9));
    BowLer.add(new Bowler("Bhuvi",24,348,378,7));
    BowLer.add(new Bowler("Bumrah",23,345,421,8));
   
           
            Country country=new India(BatsMen,BowLer);
            country.displayPlayers();
           
    }
}