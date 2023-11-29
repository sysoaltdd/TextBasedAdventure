/**
 * 精灵类，战斗
 */
class Player {  
	private Nature nature; 		//属性类
    private String name;  
    private double health;  
    private double attack; 		//基础攻击力
	private Skills skilllist;  	//技能类
	private int numskill = 2;	//技能个数
  
    public Player(Nature nature, String name, int health, int attack) {  
    	
    	this.nature = nature;
        this.name = name;  
        this.health = health;  
        this.attack = attack;  
    }  
    
    public Player(String name, int health, int attack) {  
    	
    	this(new Nature(), name, health, attack);
    	
    }
    
    public String getNature() {
    	return nature.getNature();
    }
    
	/*
	 * public String getNature2() { String naturech ; if(this.nature.number == 1)
	 * naturech = "水"; else if(this.nature.number == 2) naturech = "火"; else
	 * naturech = "土";
	 * 
	 * return naturech;
	 * 
	 * }
	 */
  
    public String getName() {  
        return name;  
    }  
	public void setName(String name) {
		this.name = name;
		
	}  
  
    public double getHealth() {  
        return health;  
    }  
    
	/*
	 * public double natureRelation(Player enemy) { int relation = this.nature -
	 * enemy.getNature(); double outcome; if (relation == -1 || relation == 2 ) {
	 * outcome = 1.1; }else if(relation == 1 || relation == -2){ outcome = 0.9;
	 * }else { outcome = 1.0; } return outcome; }
	 */
    	
    public double attack(Player enemy) {  
    	
    	System.out.print(this.name + " 攻击了" + enemy.getName() +"，");  
    	
        double damage = attack * this.nature.outcom(enemy.nature);
        
        System.out.println(" 造成 " + damage + " 点伤害！");  
        
        return damage;  
    }  
  
    public double useSkill(Player enemy) {  
    	
    	System.out.print(this.name + " 使用技能，");  
    	
        double damage = attack * 2 * this.nature.outcom(enemy.nature);
        
        System.out.println(" 造成 " + damage + " 点伤害！");  
        
        return damage;  
    }  
  
    public void decreaseHealth(double damage) {  
        health -= damage;  
        if(health > 0)
        	System.out.println(this.name + " 剩余生命值：" + health);  
        else
        	System.out.println(this.name + " 阵亡 "); 
    }

}  
  