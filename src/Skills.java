/**技能类
 * 名称，伤害系数，命中率
 */
public class Skills {
	
	private String name = "普通攻击";  	//技能名称
	private double coef = 1.0;          //基于基础攻击力的伤害系数
	private double accuracy = 0.95;		//命中率
	
	public Skills() {}
	
	public Skills(String name, double coef, double accuracy) {
		
		this.name = name;
		this.coef = coef;
		this.accuracy = accuracy;
		
	}
	
	public String getSkillname() {
		
		return name;
		
	}
	

	public double getCoef() {
		
		return coef;
		
	}
	
	public double getAccuracy() {
		
		return accuracy;
		
	}
	
	public double getSkillcoef() {
		
		//命中率		
		if(Math.random() > accuracy) {
    		
			return 0;
			
		}else {
			
			return coef;
			
		}
		
	}
	
}
