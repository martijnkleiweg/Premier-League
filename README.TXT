------------------------------------------------------------------------
Simple Java Application for recording football results and generating a league table.
------------------------------------------------------------------------

//Sample Test Code

LeagueAdmin leagueA = new LeagueAdmin();

Team chelsea = new Team("Chelsea","Premier");
leagueA.addTeam("Premier", chelsea);
Team arsenal = new Team("Arsenal","Premier");
leagueA.addTeam("Premier", arsenal);
Team manchesterUnited = new Team("Manchester United","Premier");
leagueA.addTeam("Premier", manchesterUnited);
Team wigan = new Team("Wigan Athletic","Championship");
leagueA.addTeam("Championship", wigan);
Team reading = new Team("Reading","Championship");
leagueA.addTeam("Championship", reading);
Team middlesbrough = new Team("Middlesbrough","Championship");
leagueA.addTeam("Championship",middlesbrough);

leagueA.recordResult("Premier","Arsenal","Chelsea",2,1);
leagueA.recordResult("Premier","Arsenal","Manchester United",2,2);
leagueA.recordResult("Championship","Wigan Athletic","Reading",3,2);
leagueA.recordResult("Championship","Wigan Athletic","Middlesbrough",1,1);
leagueA.recordResult("Championship","Middlesbrough","Reading",0,1);

leagueA.sortTable("Premier");
leagueA.printOutTable("Premier");

leagueA.sortTable("Championship");
leagueA.printOutTable("Championship");
