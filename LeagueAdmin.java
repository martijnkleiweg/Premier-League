import java.util.*;


public class LeagueAdmin
{
   private Map<String, List<Team>> teams;

   /**
    * Constructor for objects of class LeagueAdmin
    */
   public LeagueAdmin()
   {
       teams = new HashMap<String, List<Team>>();
   }

   /**
    * Adds a team to an existing league or create a new league and
    * then add the team to it.
    */
   public void addTeam(String division, Team team)
   {

      if (teams.containsKey(division))
      {
         List<Team> list1 = teams.get(division);
         list1.add(team);
      }
      else
      {
         List<Team> list2 = new ArrayList<Team>();
         list2.add(team);
         teams.put(division, list2);
      }
   }

   /**
    * Increments the number of wins, losses and draws
    * of a team based on the score against another
    * team.
    */
   public void recordResult(String division, String teamA, String teamB, int teamAScore, int teamBScore)
   {
      List<Team> list3 = teams.get(division);
      int team1 = -1;
      int team2 = -1;

      for (Team t1 : list3)
      {
         if (t1.getName().equals(teamA))
         {
            team1 = list3.indexOf(t1);
         }
      }


      for (Team t2 : list3)
      {
         if (t2.getName().equals(teamB))
         {
            team2 = list3.indexOf(t2);
         }

      }

      if (!(team1 == -1)  || (team2 == -1))
      {
         Team firstTeam = list3.get(team1);
         Team secondTeam = list3.get(team2);

         if (teamAScore > teamBScore)
         {
            firstTeam.incWon();
            secondTeam.incLost();
         }
         else if (teamAScore < teamBScore)
         {
            secondTeam.incWon();
            firstTeam.incLost();
         }
         else
         {
            firstTeam.incDrew();
            secondTeam.incDrew();
         }
      }
      else
      {
         System.out.println("One or both teams do not exist. Please try again.");
      }

   }

   /**
    * Prints out the division, then a line giving the header
    * for the items being printed out, then print out the
    * statistics for each of the teams in the list for that division.
    */
   public void printOutTable(String division)
   {
      List<Team> teamlist = teams.get(division);
      System.out.println(division);
      System.out.println("");
      String header = String.format("%-20s %2s %2s %2s %2s", "Name", "W", "L", "D", "Pts");
      System.out.println(header);
      System.out.println("");
      for (Team t1 : teamlist)
      {
         String results = String.format("%-20s %2d %2d %2d %2d", t1.getName(), t1.getWon(), t1.getLost(), t1.getDrew(), t1.getPoints());
         System.out.println(results);
         System.out.println("");
      }


   }

}
