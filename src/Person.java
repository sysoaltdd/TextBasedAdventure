import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 训练师类
 * 精灵pk，收集精灵，打败怪物
 * 治疗、升级精灵，收集徽章，收集进化瓶
 */
public class Person {
	
	private String name;
	private List<Pokemon> pokemonlist = new ArrayList<>();	//精灵		
	private int badge; 										//徽章	
	
	public Person() {}
	
	
	public Person(String name,  int badge) {
		
		this.name = name;
		this.badge = badge;
		
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	
	public int showBadge() {
		
		return badge;
		
	}
	
	public List<Pokemon> getPokemonlist(){
		
		return this.pokemonlist;
		
	}
	
	//显示拥有的精灵列表
	public void showPokemon() {
		
		 System.out.println(name + " 的精灵："); 
		 for (Pokemon s : pokemonlist ) {
			 
			 System.out.println(pokemonlist.indexOf(s)+1 + " - " + s.getName() + "  属性：" + s.getNature() + "  血量：" + s.getHealth() + "  攻击力：" + s.getAttack()); 
		
		 }
		
	}
	
	
	//方法：战斗中捕捉精灵 0表示开局初始化精灵 1表示战斗中捕捉
	public int getPokemon(Pokemon pokemon,int n) {
		
		if(n == 0) {
			this.pokemonlist.add(pokemon);
			return 0;
		}
		else {
			//对方血量低于15% 捕捉成功
			if(pokemon.getHealth() / pokemon.getHealthmax() < 0.15) {
				
				System.out.println("捕捉成功~");
				System.out.print("取个新名字吧：");
				Scanner scanner = new Scanner(System.in);
				String nextline = scanner.nextLine();
				pokemon.setName(nextline);
				this.pokemonlist.add(pokemon);
				return 1;
				
			} else {
				System.out.println("捕捉失败！");
				return 0;
			}
			
		}
		
	}
	
	//方法：战斗逃跑
	public int escapeHero() {
		
		//暂定一半几率逃跑失败
		if(Math.random() < 0.5) {
			System.out.println("逃跑失败！");
			return 0;
		}else {
			System.out.println("逃跑成功！脱离战斗~~~");
			return 1;
		}
		
	}
	
	//方法：收集对方徽章
	public void getBadge(Person person) {
		
		badge += person.showBadge();
		
	}


}
