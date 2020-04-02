import java.util.LinkedList;
class Cricketer
{ 
    private int matches;
    private int jerseyNumber;
    private String name;
    
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
     public Cricketer(String name,int jerseyNumber, int matches)
   { 
	   
       this.jerseyNumber=jerseyNumber;
       this.name=name;
       this.matches=matches;
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
	   super( name, jerseyNumber,  matches);
       this.noOfCenturies=noOfCenturies;
       this.iplMatches=iplMatches;
   }
   public Batsmen(String name,int jerseyNumber, int matches,int noOfCenturies, int iplMatches,boolean isKeeper)
   {
	   super( name, jerseyNumber,  matches);
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
	   super( name, jerseyNumber,  matches);
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
     LinkedList<Cricketer> Team;
     public India(LinkedList<Cricketer> Team)
     {
         this.Team=Team;
     }
     
     public void displayPlayers()
     {
         System.out.println("The batsmens are:\n");
         System.out.println("Name "+"JerseyNo "+"Matches "+"Centuries "+" Ipl Matches "+" Keeper");
         for(int i=0;i<6;i++)
         {
            System.out.println(Team.get(i).displayName()+"  "+Team.get(i).displayJersey()+
            		"     "+Team.get(i).displayMatches()+"      "+((Batsmen)Team.get(i)).getNoOfCenturies()+
            		"            "+((Batsmen)Team.get(i)).displayIplMatches()+"      "+((Batsmen)Team.get(i)).keeper());
         }
         
         System.out.println();
         
         System.out.println("The bowlers are:\n");
         System.out.println("Name "+"JerseyNo "+"Matches "+"Wickets "+" Ipl Matches ");
         for(int i=6;i<Team.size();i++)
         {
            System.out.println(Team.get(i).displayName()+"  "+Team.get(i).displayJersey()+
            		"     "+Team.get(i).displayMatches()+"      "+((Bowler)Team.get(i)).getNoOfWickets()+
            		"            "+((Bowler)Team.get(i)).displayIplMatches());
         }
     }
}

public class SOLID
{
    public static void main(String[] args)
    {
    LinkedList<Cricketer> Team=new LinkedList<Cricketer>();
    
  //restricting 6 batsmens
    Team.add(new Batsmen("Rohit",12,250,60,8));
    Team.add(new Batsmen("Dhawan",11,250,60,9));
    Team.add(new Batsmen("Virat",18,250,70,7));
    Team.add(new Batsmen("Rahul",12,250,40,8));
    Team.add(new Batsmen("Dhoni",12,330,55,9,true));
    Team.add(new Allrounder("Hardik",12,123,34,9));
    
  
   
    //restricting 5 bowlers
    Team.add(new Bowler("Chahal",23,345,123,7));
    Team.add(new Bowler("Kuldeep",24,348,456,8));
    Team.add(new Bowler("Umesh",23,345,123,9));
    Team.add(new Bowler("Bhuvi",24,348,378,7));
    Team.add(new Bowler("Bumrah",23,345,421,8));
   
           
            Country country=new India(Team);
            country.displayPlayers();
           
    }
}
