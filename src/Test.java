import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		// 创建精灵技能池 暂未命名 伤害 命中率
		List<Skill> skillslist_p = List.of(
				new Skill(), 
				new Skill("精灵技能1", 1.1, 0.97), 
				new Skill("精灵技能2", 1.3, 0.92),
				new Skill("精灵技能3", 1.4, 0.85), 
				new Skill("精灵技能4", 1.5, 0.80), 
				new Skill("精灵技能5", 2.0, 0.50));

		// 创建怪兽技能池，用于生成野外怪兽。 暂未命名 伤害 命中率
		List<Skill> skillslist_m = List.of(
				new Skill(), 
				new Skill("怪物技能1", 1.1, 0.97), 
				new Skill("怪物技能2", 1.3, 0.92),
				new Skill("怪物技能3", 1.4, 0.85), 
				new Skill("怪物技能4", 1.5, 0.80), 
				new Skill("怪物技能5", 2.0, 0.50));


		Scanner scanner = new Scanner(System.in);

		// 创建主角
		Person hero = new Person();
		System.out.print("...游戏开始...\n主角名:");
		String heroname = scanner.nextLine();
		hero.setName(heroname);

		// 创建初始精灵给主角 属性 技能池 名字 生命上限 基础攻击力 技能数
		Pokemon Pokemon0 = new Pokemon(new Nature(2), skillslist_p, "XX龙", 100, 20, 5); // 指定一个属性2
		Pokemon Pokemon1 = new Pokemon(skillslist_p, "XX兽", 110, 15, 1); // 随机一个属性
		hero.getPokemon(Pokemon0, 0);
		hero.getPokemon(Pokemon1, 0);


		/**
		 * 剧情待完善
		 * 
		 */

		// 第一次遭遇战斗

		System.out.println("\n...遭遇野外精灵~~~\n");
		Pokemon enemy = new Pokemon(skillslist_p, "敌人", 120, 15, 1);

		int num_p = hero.battle_start();    //选择出战精灵，开始战斗
		int num_s = 0; 						// 技能编号
		int PokemonTurn = 1; 				// 初始化回合数

		while (hero.getPokemonlist().get(num_p).getHealth() > 0 && enemy.getHealth() > 0) {
			
			int ord = hero.manu(PokemonTurn);

			if (hero.getPokemonlist().get(num_p).getHealth() > 0) {

				if (ord == 1) {

					num_s = hero.battling(num_p);

					// 我方攻击
					enemy.decreaseHealth(hero.getPokemonlist().get(num_p).manual_attack(enemy, num_s));

					// 对方攻击
					if (enemy.getHealth() > 0) {

						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

						PokemonTurn++;

					}

				} else if (ord == 2) {

					// 我方治疗
					hero.getPokemonlist().get(num_p).doHeal();

					// 对方攻击
					hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

					PokemonTurn++;

				} else if (ord == 3) {

					// 切换精灵占一回合，所以对方攻击一次
					hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

					// 选择出战精灵
					num_p = hero.battle_start();
					
					PokemonTurn++;

				} else if (ord == 4) {

					if (hero.getPokemon(enemy, 1) == 1) {

						// 捕捉成功 结束
						hero.showPokemon();
						break;

					} else {

						//捕捉失败，对方攻击，继续战斗
						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

						PokemonTurn++;

						continue;

					}

				} else if (ord == 5) {

					// 1 逃跑成功
					if(hero.escapeHero() == 1) {
						break;
					}
					else {

						//逃跑失败，对方攻击
						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

						PokemonTurn++;

						continue;					

					}


				}
			}
		}

		// 结果

		if (hero.getPokemonlist().get(num_p).getHealth() <= 0) {
			System.out.println("GameOver！");
		} else {
			System.out.println("战斗结束！");
		}
		
		

		// 遭遇怪兽
		



	}
}
