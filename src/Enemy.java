
/**
 * 怪物类，不同于精灵，用于收集进化瓶...
 * 
 */
class Enemy {  
	Nature nature; 				//属性
    private String name = "怪物1";  
    private double health;  	//生命
    private int attack; 		//攻击力
  
    public Enemy(Nature nature, String name, double health, int attack) {  
    	
    	this.nature = nature;
        this.name = name;  
        this.health = health;  
        this.attack = attack;  
    }  
    
    public Enemy(String name, double health, int attack) {  
    	
    	//随机属性
    	this(new Nature(), name, health, attack);
    	
    }
    
    public String getNature() {
    	return nature.getNature();
    }
  
    public String getName() {  
        return name;  
    } 
  
    public double getHealth() {  
        return health;  
    }  
    
    public double attack(Player enemy) {  
    	
    	System.out.print(this.name + " 攻击了" + enemy.getName() +"，");  
    	
        double damage = attack * this.nature.outcom(enemy.nature);
        
        System.out.println(" 造成 " + damage + " 点伤害！");  
        
        return damage;  
    }  
  
	/*
	 * public double useSkill(Player enemy) {
	 * 
	 * System.out.print(this.name + " 使用技能，");
	 * 
	 * double damage = attack * 2 * this.nature.outcom(enemy.nature);
	 * 
	 * System.out.println(" 造成 " + damage + " 点伤害！");
	 * 
	 * return damage; }
	 */
  
    public void decreaseHealth(double damage) {  
        health -= damage;  
        if(health > 0)
        	System.out.println(this.name + " 剩余生命值：" + health);  
        else
        	System.out.println(this.name + " 阵亡 "); 
    }

}