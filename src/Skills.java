/**技能类
 * 名称，伤害系数
 */
public class Skills {
	
	private String name = "技能";  //技能名称
	private double coef = 2;       //基于基础攻击力的伤害系数
	
	public Skills() {}
	
	public Skills(String name, double coef) {
		
		this.name = name;
		this.coef = coef;
		
	}
	
	public String getSkillname() {
		
		return this.name;
		
	}
	
	public double getSkillcoef() {
		
		return this.coef;
		
	}

}
