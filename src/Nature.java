
/**
 * 属性类，三种属性克制关系
 */

public class Nature {
	
	private int cod;    			//1 2 3
	private String notes;  			//水火草
	private float coef = 0.1f;   	//不同属性之间伤害浮动 10%
	
	
	//指定属性 new 数字
	public Nature(int num) {
		
		if (num < 1 || num >3)	this.cod = (int)(Math.random() * 3 + 1);
		else this.cod = num;
		
	}
	
	//不指定，就随机，可用于生成野外精灵 或怪物
	public Nature() {
		
		this((int)(Math.random() * 3 + 1));
		
	}
	
	
    public String getNature() {
    	
    	if(this.cod == 1) notes = "水";
    	else if(this.cod == 2) notes = "火";
    	else  notes = "草";
    	
    	return notes;
    	
    }
    
    public float outcom(Nature enemy) {
    	
    	int relation = this.cod - enemy.cod;
    	
    	float outcom;
    	
		if  (relation == -1 || relation == 2 ) {
    		
   		 	System.out.println("（属性克制！伤害增加）");
   		 	
   		 	outcom = 1 + coef;
    		
    	}else if(relation == 1 || relation == -2){
    		
    		System.out.println("（属性被克！伤害减少）");
    		
    		outcom = 1 - coef;
    		
    	}else {
    		outcom = 1;
    	}
    	return 	outcom;
    }

}
