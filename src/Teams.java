
public enum Teams { //data off of eufa champions league odds... Note: some odds may be altered according to biases I may hold
	
	Dortmund(1.0/16.0), 
	BBandN(1.0/1000000.0),
	Leichester(1.0/10.0),
	Barcelona(4.0/16.0),
	Bayern(1.0/4.0),
	RealMadrid(1.0/5.0),
	Chelsea(1.0/9.0),
	ManCity(1.0/14.0),
	ManUnited(1.0/14.0),
	PSG(1.0/20.0),
	Arsenal(1.0/18.0),
	Athletico(1.0/18.0),
	Juventus(1.0/18.0),
	Valencia(1.0/20.0),
	Sevilla(1.0/18.0),
	Wolfsburg(1.0/18.0),
	Roma(1.0/25.0),
	Shakhtar(1.0/200.),
	Malmo(1.0/300.0),
	PSV(1.0/200.0),
	CSKAMoscow(1.0/100.0),
	Benfica(1.0/50.0),
	Galatasaray(1.0/75.0),
	Astana(1.0/300.0),
	Mönchengladbach(1.0/500.0),
	Leverkusen(1.0/100.0),
	Olymiacos(1.0/300.0),
	DynamoKyiv(1.0/75.0),
	Porto(1.0/50.0),
	Zenit(1.0/30.0),
	KAAGent(1.0/100.0),
	Lyon(1.0/20.0);
	
	private final double probability;
	
    Teams(double probability){ 
    	this.probability = probability; 
    }
    
    public double getProbability(){ 
    	return probability; 
    }
}


