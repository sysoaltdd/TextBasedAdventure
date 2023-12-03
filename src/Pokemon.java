import java.util.ArrayList;
import java.util.List;

/**
 * 精灵类，名字、属性、攻击力...
 * 使用技能，互相pk
 */

class Pokemon {  
	Nature nature; 				//属性类
	private String name;  
	private int health;  		//当前生命值
	private int healthmax;		//最大生命值，考虑有治疗技能
	private int attack; 		//基础攻击力
	private List<Skill> skilllist = new ArrayList<>();; //自身技能列表
	private int numskill = 2;	//除去技能0外的随机技能个数 


	public Pokemon(Nature nature, List<Skill> skilllist, String name, int healthmax, int attack, int numskill) {  

		this.nature = nature;
		this.name = name;  
		this.healthmax = healthmax; 
		this.health = healthmax;
		this.attack = attack;
		this.numskill = numskill;

		this.skilllist.add(skilllist.get(0));//技能0

		//随机生成剩余技能
		for (int s : randomArray.numChoose(1, skilllist.size() - 1, this.numskill) ) {
			this.skilllist.add(skilllist.get(s));
		}


	}  

	public Pokemon(List<Skill> skilllist, String name, int healthmax, int attack, int numskill) {  

		//随机属性
		this(new Nature(), skilllist, name, healthmax, attack, numskill);

	}

	public String getNature() {
		return nature.getNature();
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
	public double getHealthmax() {  
		return healthmax;  
	} 


	//治愈
	public void doHeal() {  

		this.health = healthmax;

		System.out.println(name + " 受到治疗，满血啦~ ");

	}

	public double getAttack() {  
		return attack;  
	}  

	public List<Skill> getSkills(){

		return skilllist;

	}

	// 显示技能列表
	public void showSkills() {

		System.out.println(name + " 的技能：");
		for (Skill s : skilllist) {
			System.out.println(skilllist.indexOf(s)+1 + " - " + s.getSkillname() + "  伤害：" + attack * s.getCoef() + "  命中率：" + s.getAccuracy()*100 + "%");
		}

	}


	public int attack(Pokemon enemy, int ord) {  						//新增参数，表示调用不同技能

		System.out.println(this.name + " 使用了" + skilllist.get(ord).getSkillname()); 
		
		int damage = (int)Math.round(attack * this.nature.outcom(enemy.nature) * skilllist.get(ord).getSkillcoef());  //小数四舍五入取整

		if(damage == 0) {

			System.out.println("未命中！");

		}else {
			
			System.out.println(" 造成 " + damage + " 点伤害！");  

		}

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
