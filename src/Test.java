import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		// 创建技能池 暂未命名 伤害 命中率
		List<Skill> skillslist = List.of(
				new Skill(), 
				new Skill("技能1", 1.1, 0.97), 
				new Skill("技能2", 1.3, 0.92),
				new Skill("技能3", 1.4, 0.85), 
				new Skill("技能4", 1.5, 0.80), 
				new Skill("技能5", 2.0, 0.50));

		Scanner scanner = new Scanner(System.in);

		// 创建主角
		Person hero = new Person();
		System.out.print("...游戏开始...\n主角名:");
		String heroname = scanner.nextLine();
		hero.setName(heroname);

		// 创建初始精灵给主角 属性 技能池 名字 生命上限 基础攻击力 技能数
		Pokemon Pokemon0 = new Pokemon(new Nature(2), skillslist, "XX龙", 100, 20, 5); // 指定一个属性2
		Pokemon Pokemon1 = new Pokemon(skillslist, "XX兽", 110, 15, 1); // 随机一个属性
		hero.getPokemon(Pokemon0, 0);
		hero.getPokemon(Pokemon1, 0);

		// 展示精灵
		hero.showPokemon();

		/**
		 * 剧情待完善
		 * 
		 */

		// 第一次遭遇战斗
		
		System.out.println("\n...遭遇野外精灵~~~\n");

		Pokemon enemy = new Pokemon(skillslist, "敌人", 120, 15, 1);

		int num_p = 0; // 精灵编号
		int num_s = 0; // 技能编号
		String order; // 输入的命令

		while (1 == 1) {

			System.out.print("请选择出战精灵（号码）:");
			order = scanner.nextLine();

			if (CustomMethod.isDigit(order)) {
				num_p = Integer.parseInt(order) - 1;
				if (num_p < hero.getPokemonlist().size())
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

		// 初始化回合数
		int PokemonTurn = 1;


		while (hero.getPokemonlist().get(num_p).getHealth() > 0 && enemy.getHealth() > 0) {

			System.out.println("回合：" + PokemonTurn);
			System.out.print("请输入命令（1：攻击/2：治疗/3：切换精灵/4：捕捉/5：逃跑）:");
			order = scanner.nextLine();
			
			if (hero.getPokemonlist().get(num_p).getHealth() > 0) {
				if (order.equals("1")) {

					// 展示技能列表
					hero.getPokemonlist().get(num_p).showSkills();

					while (1 == 1) {
						System.out.print("请选择技能:");
						order = scanner.nextLine();

						if (CustomMethod.isDigit(order)) {
							num_s = Integer.parseInt(order) - 1;
							if (num_s < hero.getPokemonlist().get(num_p).getSkills().size())
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

					// 我方攻击
					enemy.decreaseHealth(hero.getPokemonlist().get(num_p).attack(enemy, num_s));

					Thread.sleep(2000);

					// 对方攻击
					if (enemy.getHealth() > 0) {

						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.attack(hero.getPokemonlist().get(num_p), 0));

						PokemonTurn++;

					}

				} else if (order.equals("2")) {

					Thread.sleep(2000);

					// 我方治疗
					hero.getPokemonlist().get(num_p).doHeal();

					Thread.sleep(2000);

					// 对方攻击
					hero.getPokemonlist().get(num_p).decreaseHealth(enemy.attack(hero.getPokemonlist().get(num_p), 0));

					PokemonTurn++;

				} else if (order.equals("3")) {

					Thread.sleep(2000);

					// 切换精灵占一回合，所以对方攻击一次
					hero.getPokemonlist().get(num_p).decreaseHealth(enemy.attack(hero.getPokemonlist().get(num_p), 0));

					// 展示所有精灵
					hero.showPokemon();

					// 选择出战精灵
					while (1 == 1) {
						System.out.print("请选择出战精灵（号码）:");
						order = scanner.nextLine();
						// CustomMethod abc = new CustomMethod();
						if (CustomMethod.isDigit(order)) {
							num_p = Integer.parseInt(order) - 1;
							if (num_p < hero.getPokemonlist().size())
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

				} else if (order.equals("4")) {

					Thread.sleep(2000);

					if (hero.getPokemon(enemy, 1) == 1) {

						// 捕捉成功 结束
						hero.showPokemon();
						break;

					} else {
						
						//捕捉失败，对方攻击，继续战斗
						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.attack(hero.getPokemonlist().get(num_p), 0));
						
						PokemonTurn++;
						
						continue;
						
					}

				} else if (order.equals("5")) {

					Thread.sleep(2000);
					
					// 1 逃跑成功
					if(hero.escapeHero() == 1) {
						break;
					}
					else {
						
						//逃跑失败，对方攻击
						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.attack(hero.getPokemonlist().get(num_p), 0));
						
						PokemonTurn++;
						
						continue;					
						
					}

					
				}

				else {

					System.out.println("无效输入！");
					continue;
				}
			}
		}

		// 结果

		if (hero.getPokemonlist().get(num_p).getHealth() <= 0) {
			System.out.println("GameOver！");
		} else {
			System.out.println("战斗结束！");
		}

	}
}
