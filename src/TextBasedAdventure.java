import java.util.*;  

public class TextBasedAdventure {  
    public static void main(String[] args) throws InterruptedException {  
        Scanner scanner = new Scanner(System.in);
  
        // 创建精灵和敌人角色  
        Player player0 = new Player(1, "pika", 100, 20);
        Player player1 = new Player(2, "b", 110, 15);
        Player player2 = new Player(3, "c", 105, 22);
        Player player3 = new Player(2, "d", 100, 10);
        List<Player> list = List.of(player0, player1, player2, player3);
        
        
        //System.out.print("取个新名字吧:");
        //String name = scanner.nextLine();  
        //player.setName(name);	//重命名
              
        Player enemy = new Player(2,"敌人", 80, 15);  
        
        //展示所有精灵
        System.out.println("你的所有精灵：");
        for (Player s : list ) {
            System.out.println(list.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature2());
        }
        //选择出战精灵
        System.out.print("请选择出战精灵（号码）:"); 
        String order = scanner.nextLine();
        int n = Integer.parseInt(order) - 1;
        
  
        // 初始化玩家的回合数和敌人的回合数  
        int playerTurn = 1;  
        //int enemyTurn = 1;  //改为敌我同一回合 
  
        
        while (list.get(n).getHealth() > 0 && enemy.getHealth() > 0) {
            // 玩家回合
        	
            System.out.println("回合：" + playerTurn);  
            System.out.print("请输入命令（1：攻击/2：技能/3：切换精灵/4：捕捉/5：逃跑）:");  
            String playerAction = scanner.nextLine();  //获取输入指令
            if(list.get(n).getHealth() > 0) {
	            if (playerAction.equals("1")) {  
	                 
	                Thread.sleep(2000);
	                
	                enemy.decreaseHealth(list.get(n).attack(enemy));  
	                
	            } else if (playerAction.equals("2")) {  

	                Thread.sleep(2000);
	                
	                enemy.decreaseHealth(list.get(n).useSkill(enemy));  
	                
	            } else if(playerAction.equals("3")) {
	            	
	            	Thread.sleep(2000);
	            	//展示所有精灵
	                System.out.println("你的所有精灵：");
	                for (Player s : list ) {
	                    System.out.println(list.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature2());
	                }
	                //选择出战精灵
	                System.out.print("请选择出战精灵（号码）:"); 
	                order = scanner.nextLine();
	                n = Integer.parseInt(order) - 1; //更新n
	                continue;
	            	
	            }
	            else if(playerAction.equals("4")) {
	            	
	            	System.out.print("捕捉成功，取个新名字吧:");
	            	String name = scanner.nextLine(); 
	            	enemy.setName(name);	//重命名
	            	list.add(enemy);	//加入list	            	
	            	System.out.println("你的所有精灵：");
	                for (Player s : list ) {
	                    System.out.println(list.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature2());
	                }
	            }
	            
	            else {  
	            	
	                System.out.println("无效输入！"); 
	                continue;
	            }  
            }
            //playerTurn++;  
  
            // 敌人回合  
            //System.out.println("回合：" + enemyTurn);  
            //System.out.println("敌人攻击了你，你受到了 " + enemy.attack(player) + " 点伤害！");  
            
            Thread.sleep(2000);
            
            if(enemy.getHealth() > 0) {
            	
            	list.get(n).decreaseHealth(enemy.attack(list.get(n)));  
	            playerTurn++;
	            
	            Thread.sleep(2000);
            }
        }  
  
        // 结果

        if (list.get(n).getHealth() <= 0) {  
            System.out.println("GameOver！");
        } else {  
            System.out.println("战斗胜利！");  
        }  
    }  
}