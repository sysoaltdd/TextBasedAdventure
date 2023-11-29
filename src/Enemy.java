
class Enemy {  
	private int nature; //属性 1水 2火 3土
    private String name;  
    private double health;  
    private double attack;  
  
    public Enemy(int nature, String name, int health, int attack) {  
    	this.nature = nature;
        this.name = name;  
        this.health = health;  
        this.attack = attack;  
    }  
    public int getNature() {
    	return nature;
    }
  
    public String getName() {  
        return name;  
    }  
  
    public double getHealth() {  
        return health;  
    }  
    
    public double natureRelation(Player player) {
    	int relation = this.nature - player.getNature();
    	double outcome;
    	if  (relation == -1|| relation == 2 ) {
    		 outcome = 1.1;
    	}else if(relation == 1|| relation == -2){
    		 outcome = 0.9;
    	}else {
    		 outcome = 1.0;
    	}
    	return 	outcome;
    }
    
    public double attack(Player player) {  
        double damage = attack * this.natureRelation(player) ; 
        System.out.println(this.name + " 攻击了" + player.getName() + "，" + player.getName() + "受到了 " + damage + " 点伤害！");  
        return damage;  
    }  
    public void decreaseHealth(double damage) {  
        health -= damage;  
        if(health > 0)
        	System.out.println(name + " 剩余生命值：" + health);  
        else
        	System.out.println(name + " 阵亡 ");
        	
    }  
}  
  