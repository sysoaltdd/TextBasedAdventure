import java.util.ArrayList;
import java.util.List;

/**
 * 怪物类，不同于精灵，用于收集进化瓶...
 * 
 */
class Monster {  
	Nature nature = new Nature(); 	//属性随机
    private String name = "怪物";  
    private int health;  			//生命
    private int attack; 			//攻击力
    private List<Skill> skilllist = new ArrayList<>();
    private int numskill = 2;
  
    public Monster(List<Skill> skilllist, String name, int health, int attack) {  
    	
        this.name = name;  
        this.health = health;  
        this.attack = attack; 
        
        this.skilllist.add(skilllist.get(0));

		//随机生成剩余技能
		for (int s : randomArray.numChoose(1, skilllist.size() - 1, this.numskill) ) {
			this.skilllist.add(skilllist.get(s));
		}
        
    }  
    
	public double getHealth() {  
		return health;  
	} 

    public int auto_attack(Pokemon enemy) {
    	
    	int ord = (int)(Math.random() * skilllist.size());

		System.out.println(this.name + " 使用了" + skilllist.get(ord).getSkillname()); 
		
		int damage = (int)Math.round(attack * this.nature.outcom(enemy.nature) * skilllist.get(ord).getSkillcoef());  //小数四舍五入取整

		if(damage == 0) {

			System.out.println("未命中！");

		}else {
			
			System.out.println(" 造成 " + damage + " 点伤害！");  

		}

		return damage;  
	}  
  
    public int bedefeated(int damage) {  
        health -= damage;  
        if(health > 0) {
        	System.out.println(this.name + " 剩余生命值：" + health); 
        	return 0;
        }
        else {
        	System.out.println(this.name + " 被击败，好像有掉落战利品~ "); 
        	return 1;
        }
    }

}