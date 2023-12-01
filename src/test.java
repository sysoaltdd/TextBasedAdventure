import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;  

public class test {  
	public static void main(String[] args) throws InterruptedException {	

		Scanner scanner = new Scanner(System.in);

		//创建技能池 暂未命名 伤害，命中率
		List<Skills> skillslist = List.of(
				new Skills(),
				new Skills("技能1", 1.1, 0.97),
				new Skills("技能2", 1.3, 0.92),
				new Skills("技能3", 1.4, 0.85),
				new Skills("技能4", 1.5, 0.80),
				new Skills("技能5", 2, 0.50));

		// 创建精灵和敌人角色  属性 技能池 名字 生命上限 基础攻击力 技能数
		Player player0 = new Player(new Nature(2),skillslist, "pika", 100, 20, 5); //指定一个属性2
		Player player1 = new Player(skillslist, "b", 110, 15, 1);  //随机一个属性


		/*
		 * for (Skills s : player0.getSkills() ) { System.out.println(s.getSkillname());
		 * }
		 */



		//放入列表
		List<Player> mylist = new ArrayList<>();  
		mylist.add(player0);
		mylist.add(player1);

		//System.out.print("取个新名字吧:");
		//String name = scanner.nextLine();  
		//player.setName(name);	//重命名

		Player enemy = new Player(skillslist,"敌人", 80, 15, 1);  


		//展示所有精灵
		System.out.println("你的所有精灵：");
		for (Player s : mylist ) {
			System.out.println(mylist.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature());
		}


		int num_p = 0;  //精灵编号
		int num_s = 0;  //技能编号
		String order;  //输入的命令

		while (1==1) {
			System.out.print("请选择出战精灵（号码）:");
			order = scanner.nextLine();

			//CustomMethod abc = new CustomMethod();
			if (CustomMethod.isDigit(order)) {
				num_p = Integer.parseInt(order) - 1;
				if (num_p < mylist.size())
					break;
				else {
					System.out.println("无效输入！");
					continue;
				}
			}
			else {
				System.out.println("无效输入！");
				continue;
			}
		}

		// 初始化玩家的回合数和敌人的回合数  
		int playerTurn = 1;  
		//int enemyTurn = 1;  //改为敌我同一回合 


		while (mylist.get(num_p).getHealth() > 0 && enemy.getHealth() > 0) {

			System.out.println("回合：" + playerTurn);  
			System.out.print("请输入命令（1：攻击/2：治疗/3：切换精灵/4：捕捉/5：逃跑）:");  
			order = scanner.nextLine();
			if(mylist.get(num_p).getHealth() > 0) {
				if (order.equals("1")) {  

					Thread.sleep(2000);

					//展示技能列表
					System.out.println(mylist.get(num_p).getName() + " 的技能：");
					for (Skills s : mylist.get(num_p).getSkills()) {
						System.out.println(mylist.get(num_p).getSkills().indexOf(s)+1 + " - " + s.getSkillname() + "  伤害：" + mylist.get(num_p).getAttack() * s.getCoef() + "  命中率：" + s.getAccuracy());
					}

					while (1==1) {
						System.out.print("请选择技能:");  
						order = scanner.nextLine();

						if (CustomMethod.isDigit(order)) {
							num_s = Integer.parseInt(order) - 1;
							if (num_s < mylist.get(num_p).getSkills().size())
								break;
							else {
								System.out.println("无效输入！");
								continue;
							}
						}
						else {
							System.out.println("无效输入！");
							continue;
						}
					}


					enemy.decreaseHealth(mylist.get(num_p).attack(enemy, num_s));  

					Thread.sleep(2000);

					if(enemy.getHealth() > 0) {

						mylist.get(num_p).decreaseHealth(enemy.attack(mylist.get(num_p), 0));  
						playerTurn++;

					}

				} else if (order.equals("2")) {  

					Thread.sleep(2000);

					//TO DO

					playerTurn++;

				}else if(order.equals("3")) {

					Thread.sleep(2000);
					//展示所有精灵
					System.out.println("你的所有精灵：");
					for (Player s : mylist ) {
						System.out.println(mylist.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature());
					}
					//选择出战精灵
					while (1==1) {
						System.out.print("请选择出战精灵（号码）:");
						order = scanner.nextLine();
						//CustomMethod abc = new CustomMethod();
						if (CustomMethod.isDigit(order)) {
							num_p = Integer.parseInt(order) - 1;
							if (num_p < mylist.size())
								break;
							else {
								System.out.println("无效输入！");
								continue;
							}
						}
						else {
							System.out.println("无效输入！");
							continue;
						}
					}

				} else if(order.equals("4")) {

					Thread.sleep(2000);

					System.out.println("捕捉成功，取个新名字吧:");
					String name = scanner.nextLine(); 
					enemy.setName(name);	//重命名
					mylist.add(enemy);	//加入list	            	
					System.out.println("你的所有精灵：");
					for (Player s : mylist ) {
						System.out.println(mylist.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature());
					}
					//System.out.print("结束战斗！");

					break;
				} else if(order.equals("5")) {

					Thread.sleep(2000);

					System.out.print("逃跑！");

					break;
				}



				else {  

					System.out.println("无效输入！"); 
					continue;
				}  
			}
		}



		// 结果

		if (mylist.get(num_p).getHealth() <= 0) {  
			System.out.println("GameOver！");
		} else {  
			System.out.println("结束战斗！");  
		}



	}
}
