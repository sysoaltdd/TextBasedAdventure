
import java.util.Random;

/**
 * 属性类，三种属性克制关系
 */
public class Nature {
	
	private int cod;    			//1 2 3
	private String notes;  			//水火草
	private double coef = 0.1;   	//属性克制伤害浮动 默认10%
	
	Random r = new Random();
	
	//指定属性 new 数字
	public Nature(int num) {
		
		if (num < 1 && num >3)	this.cod = r.nextInt(1, 4);
		else this.cod = num;
		
	}
	
	//不指定，就随机
	public Nature() {
		
		this.cod = r.nextInt(1, 4);
		
	}
	
    public String getNature() {
    	
    	if(this.cod == 1) notes = "水";
    	else if(this.cod == 2) notes = "火";
    	else  notes = "草";
    	
    	return notes;
    	
    }
    
    public double outcom(Nature enemy) {
    	
    	int relation = this.cod - enemy.cod;    	
    	double outcom;
    	
		if  (relation == -1 || relation == 2 ) {
    		
   		 	System.out.print("（属性克制！伤害增加）");
   		 	
   		 	outcom = 1 + coef;
    		
    	}else if(relation == 1 || relation == -2){
    		
    		System.out.print("（属性被克！伤害减少）");
    		
    		outcom = 1 - coef;
    		
    	}else {
    		outcom = 1;
    	}
    	return 	outcom;
    }

}
