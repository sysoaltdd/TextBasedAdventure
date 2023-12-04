import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 训练师类
 * 精灵pk，收集精灵，打败怪物
 * 治疗、升级精灵，收集徽章，收集进化瓶
 */
class Person {
	
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
	
	//收集徽章
	public void getBadge() {
		
		System.out.println("得到一个进化瓶~~~");
		badge++;
		
	}
	
	//显示精灵列表
	public List<Pokemon> getPokemonlist(){
		
		return this.pokemonlist;
		
	}
	
	//战斗菜单 返回所选数字 （1：攻击/2：治疗/3：切换精灵/4：捕捉/5：逃跑）
	public int manu(int PokemonTurn) {
		
		int num;
		
		while (1 == 1) {
			
			System.out.println("回合：" + PokemonTurn);
			System.out.print("请输入命令（1：攻击/2：治疗/3：切换精灵/4：捕捉/5：逃跑）:");
			Scanner scanner = new Scanner(System.in);
			String order = scanner.nextLine();
			

			if (CustomMethod.isDigit(order)) {
				
				num = Integer.parseInt(order);
				
				// 目前菜单只有5项
				if (num > 5) {
					System.out.println("无效输入！");
					continue;
				}
				else {
					break;
				}
			} else {
				System.out.println("无效输入！");
				continue;
			}
		}
		return num;
		
	}
	
	//选择精灵进入战斗，判断输入，返回所选的精灵编号
	public int battle_start() {
		
		int num_p = 0;
		
		this.showPokemon();
		
		while (1 == 1) {

			System.out.print("请选择出战精灵（号码）:");
			Scanner scanner = new Scanner(System.in);
			String s = scanner.nextLine();
			

			if (CustomMethod.isDigit(s)) {
				num_p = Integer.parseInt(s) - 1;
				if (num_p < pokemonlist.size())
					break;
				else {
					System.out.println("无效输入！");
					continue;
				}
			} else {
				System.out.println("无效输入！");
				continue;
			}
		}
		return num_p;
		
	}
	
	//战斗中选择技能  判断输入，返回所选的技能编号
	public int battling(int num_p) {
		
		int num_s = 0;
		
		// 展示技能列表
		pokemonlist.get(num_p).showSkills();

		while (1 == 1) {
			System.out.print("请选择技能:");
			Scanner scanner = new Scanner(System.in);
			String order = scanner.nextLine();

			if (CustomMethod.isDigit(order)) {
				num_s = Integer.parseInt(order) - 1;
				if (num_s < pokemonlist.get(num_p).getSkills().size())
					break;
				else {
					System.out.println("无效输入！");
					continue;
				}
			} else {
				System.out.println("无效输入！");
				continue;
			}
		}
		return num_s;
		
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
