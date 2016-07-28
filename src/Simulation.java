import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Simulation extends JPanel{
	
	int t1score = 0;
	int t2score = 0;
	
	int gameTime = 0;
	
	int homeAdvantage = 5;
	
	double decreaseIncrementEveryGoal;
	
	double teamOneScoringRate;
	double teamTwoScoringRate;
	
	int numChances;
	
	Random r = new Random();
	
	Simulation(){
		generateGame(Teams.Bayern, Teams.Dortmund, "Leg 1");
		generateGame(Teams.Dortmund, Teams.Bayern, "Leg 2");
		System.exit(0);
	}
	
	public void resetRandomGameVars(){
		t1score = 0;
		t2score = 0;
		gameTime = 0;
	}
	
	public void generateGame(Teams home, Teams away, String s){
		
		System.out.println();
		System.out.println(s);
		System.out.println("---------------------");
		
		resetRandomGameVars();
		
		decreaseIncrementEveryGoal = ((double)(r.nextInt(10) + 5)) / 100.0;
		
		double advantage = (int)((home.getProbability() / (away.getProbability() + home.getProbability())) * 5) + homeAdvantage;
		
		//System.out.println((int)((t1.getProbability() / (t2.getProbability() + t1.getProbability())) * 7));
		
		if(advantage < 1){
			advantage = 1;
		}
		
		double odds = (home.getProbability() / (away.getProbability() + home.getProbability()));
		
		if(odds > 0.975){
			odds = 0.975;
		}
		
		System.out.println("Odds: " + odds);
		
		numChances = r.nextInt((int)(advantage * 1.5)) + 5;
		
		System.out.println("Estimated Chances: " + numChances);
		System.out.println("Advantage: " + advantage);
		
		teamOneScoringRate = ((double)((r.nextInt(50) + 30)) + (advantage * 3)) / 100.0;
		teamTwoScoringRate = ((double)((r.nextInt(50) + 30)) - advantage) / 100.0;
	
		//System.out.println(teamOneScoringRate);
		//System.out.println(teamTwoScoringRate);
		
		int startTime = (int)System.currentTimeMillis();
		
		while(gameTime < 90){
			
			int initialTime = (int)System.currentTimeMillis();
			
			while(true){
			
				if((int)System.currentTimeMillis() - initialTime > 1000){
					
					gameTime++;
					
					if(gameTime % 5 == 0){
						System.out.println("(" + gameTime + "')");
					}
					
					if(r.nextInt(90) < numChances){
						generateChance(home, away, odds);
					}
					
					break;
				}
			}
		}
		
		System.out.println();
		System.out.println(home.toString() + ": " + t1score + " - " + t2score + " :" + away.toString());
	}
	
	public void generateChance(Teams t1, Teams t2, double odds){
		if(r.nextDouble() <= odds){
			if(r.nextDouble() < teamOneScoringRate){
				if(teamTwoScoringRate > decreaseIncrementEveryGoal + 0.1){
					teamOneScoringRate -= decreaseIncrementEveryGoal;
				}
				t1score++;
				System.out.println(t1.toString() + " scored!");
			}else{
				System.out.println(t1.toString() + " missed?!");
			}
		}else{
			if(r.nextDouble() < teamOneScoringRate){
				if(teamTwoScoringRate > decreaseIncrementEveryGoal + 0.1){
						teamTwoScoringRate -= decreaseIncrementEveryGoal;
				}
				
				t2score++;
				System.out.println(t2.toString() + " scored!");
			}else{
				System.out.println(t2.toString() + " missed?!");
			}
		}
	}
}
