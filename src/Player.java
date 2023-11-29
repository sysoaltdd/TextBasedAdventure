
class Player {  
	private int nature; //属性 1水 2火 3土
    private String name;  
    private double health;  
    private double attack;  
  
    public Player(int nature,String name, int health, int attack) {  
    	this.nature = nature;
        this.name = name;  
        this.health = health;  
        this.attack = attack;  
    }  
    public int getNature() {
    	return nature;
    }
    public String getNature2() {
    	String naturech ;
    	if(this.nature == 1) naturech = "水";
    	else if(this.nature == 2) naturech = "火";
    	else  naturech = "土";
    	
    	return naturech;
    	
    }
  
    public String getName() {  
        return name;  
    }  
	public void setName(String name) {
		this.name = name;
		
	}  
  
    public double getHealth() {  
        return health;  
    }  
    
    public double natureRelation(Player enemy) {
    	int relation = this.nature - enemy.getNature();
    	double outcome;
    	if  (relation == -1 || relation == 2 ) {
    		 outcome = 1.1;
    	}else if(relation == 1 || relation == -2){
    		 outcome = 0.9;
    	}else {
    		 outcome = 1.0;
    	}
    	return 	outcome;
    }
    	
    public double attack(Player enemy) {  
        double damage = attack * this.natureRelation(enemy);
        System.out.println(this.name + " 攻击了" + enemy.getName() +"，造成 " + damage + " 点伤害！");  
        return damage;  
    }  
  
    public double useSkill(Player enemy) {  
        double damage = attack * 2 * this.natureRelation(enemy);
        System.out.println(this.name + " 使用技能，造成 " + damage + " 点伤害！");  
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
  