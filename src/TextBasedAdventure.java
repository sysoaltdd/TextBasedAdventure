import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TextBasedAdventure {

	public static void main(String[] args) {

		// 创建精灵技能池 暂未命名 伤害 命中率
		List<Skill> skillslist_p = List.of(
				new Skill(), 
				new Skill("空气切割", 1.1, 0.97), 
				new Skill("风暴攻击", 1.3, 0.92),
				new Skill("大地之力", 1.4, 0.85), 
				new Skill("金光闪烁", 1.5, 0.80), 
				new Skill("岩石爆破", 2.0, 0.50));

		Scanner scanner = new Scanner(System.in);

		// 创建主角
		Person hero = new Person();
		System.out.print("...游戏开始...\n主角名:");
		String heroname = scanner.nextLine();
		hero.setName(heroname);

		// 创建初始精灵给主角 属性 技能池 名字 生命上限 基础攻击力 技能数
		Pokemon Pokemon0 = new Pokemon(new Nature(2), skillslist_p, "XX龙", 100, 20, 3); // 指定一个属性2
		Pokemon Pokemon1 = new Pokemon(skillslist_p, "XX兽", 110, 15, 1); // 随机一个属性
		hero.getPokemon(Pokemon0, 0);
		hero.getPokemon(Pokemon1, 0);


		/**
		 * 剧情待完善
		 * 
		 */

		// 第一次遭遇战斗

		System.out.println("\n...遭遇野外精灵~~~\n");
		Pokemon enemy = new Pokemon(skillslist_p, "敌人", 120, 15, 2);

		int num_p = hero.battle_start();    // 选择出战精灵，开始战斗
		int num_s = 0; 						// 技能编号
		int PokemonTurn = 1; 				// 初始化回合数
		int pkstatus = 1;					// 战斗状态

		while (pkstatus == 1) {
				
				switch (hero.manu(PokemonTurn)) {

				case 1:

					num_s = hero.battling(num_p);

					// 我方攻击
					enemy.decreaseHealth(hero.getPokemonlist().get(num_p).manual_attack(enemy, num_s));

					// 对方攻击
					if (enemy.getHealth() > 0) {

						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

						PokemonTurn++;

					} else pkstatus = 0;
					break;

				case 2:

					// 我方治疗
					hero.getPokemonlist().get(num_p).doHeal();

					// 对方攻击
					hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

					PokemonTurn++;
					
					break;

				case 3:

					// 切换精灵占一回合，所以对方攻击一次
					hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

					// 选择出战精灵
					num_p = hero.battle_start();
					
					PokemonTurn++;
					
					break;

				case 4: 

					if (hero.getPokemon(enemy, 1) == 1) {

						// 捕捉成功 结束
						hero.showPokemon();
						
						pkstatus = 0;
						

					} else {

						//捕捉失败，对方攻击，继续战斗
						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

						PokemonTurn++;

						

					}
					break;
					

				case 5: 

					// 1 逃跑成功
					if(hero.escapeHero() == 1) {
						
						pkstatus = 0;
						
					}
					else {

						//逃跑失败，对方攻击
						hero.getPokemonlist().get(num_p).decreaseHealth(enemy.auto_attack(hero.getPokemonlist().get(num_p)));

						PokemonTurn++;

					}
					
					break;
					
				}
			
		}

		// 结果

		if (hero.getPokemonlist().get(num_p).getHealth() <= 0) {
			System.out.println("GameOver！");
		} else {
			System.out.println("战斗结束！");
		}
		
		// 遭遇怪兽
		//
		



	}
}
