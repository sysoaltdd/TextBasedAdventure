
/**
 * 指定范围 生成n个不重复的数
 */
public class randomArray {
	
	public static int[] numChoose(int min,int max,int n){  
		
	    int len = max-min+1;  
	      
	    if(max < min || n > len){  
	        return null;  
	    }  
	      
	    //初始化给定范围的待选数组  
	    int[] source = new int[len];  
	       for (int i = min; i <= max; i++){  
	        source[i-min] = i;  
	       }  
	         
	    int[] result = new int[n];   
	    
	    for (int i = 0; i < result.length; i++) {  
	        //待选数组随机一个下标  
	           int index = (int)(Math.random() * len--);  
	           //将随机到的数放入结果集  
	           result[i] = source[index];  
	           //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换  
	           source[index] = source[len];
	    }
	    
	    return result;  
	    
	}

}