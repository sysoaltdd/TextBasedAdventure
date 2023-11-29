import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;  

public class test {  
    public static void main(String[] args) throws InterruptedException {  
        	Scanner scanner = new Scanner(System.in);
        	
        	// 创建精灵和敌人角色  
			Player player0 = new Player(1, "pika", 100, 20);
			Player player1 = new Player(2, "b", 110, 15);
			
			//放入列表
			List<Player> mylist = new ArrayList<>();  
			mylist.add(player0);
			mylist.add(player1);
			
			//System.out.print("取个新名字吧:");
			//String name = scanner.nextLine();  
			//player.setName(name);	//重命名
			      
			Player enemy = new Player(3,"敌人", 80, 15);  
			
			
			//展示所有精灵
			System.out.println("你的所有精灵：");
			for (Player s : mylist ) {
			    System.out.println(mylist.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature2());
			}
			
			//选择初始精灵
			int n = 0;
			String order;
			
			while (1==1) {
			System.out.print("请选择出战精灵（号码）:");
			order = scanner.nextLine();
			
			//CustomMethod abc = new CustomMethod();
			if (CustomMethod.isDigit(order)) {
				n = Integer.parseInt(order) - 1;
				if (n < mylist.size())
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
  
			
			while (mylist.get(n).getHealth() > 0 && enemy.getHealth() > 0) {
				
			    System.out.println("回合：" + playerTurn);  
			    System.out.print("请输入命令（1：攻击/2：技能/3：切换精灵/4：捕捉/5：逃跑）:");  
			    order = scanner.nextLine();
			    if(mylist.get(n).getHealth() > 0) {
			        if (order.equals("1")) {  
			             
			            Thread.sleep(2000);
			            
			            enemy.decreaseHealth(mylist.get(n).attack(enemy));  
			            
			            Thread.sleep(2000);
					    
					    if(enemy.getHealth() > 0) {
					    	
					    	mylist.get(n).decreaseHealth(enemy.attack(mylist.get(n)));  
					        playerTurn++;
					        
					    }
			            
			        } else if (order.equals("2")) {  

			            Thread.sleep(2000);
			            
			            enemy.decreaseHealth(mylist.get(n).useSkill(enemy));  
			            
			            Thread.sleep(2000);
					    
					    if(enemy.getHealth() > 0) {
					    	
					    	mylist.get(n).decreaseHealth(enemy.attack(mylist.get(n)));  
					        playerTurn++;
					        
					    }
			            
			            
			        } else if(order.equals("3")) {
			        	
			        	Thread.sleep(2000);
			        	//展示所有精灵
			            System.out.println("你的所有精灵：");
			            for (Player s : mylist ) {
			                System.out.println(mylist.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature2());
			            }
			            //选择出战精灵
			            while (1==1) {
			    			System.out.print("请选择出战精灵（号码）:");
			    			order = scanner.nextLine();
			    			//CustomMethod abc = new CustomMethod();
			    			if (CustomMethod.isDigit(order)) {
			    				n = Integer.parseInt(order) - 1;
			    				if (n < mylist.size())
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
		                    System.out.println(mylist.indexOf(s)+1 + " - " + s.getName() + "  血量：" + s.getHealth() + "  属性：" + s.getNature2());
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

			if (mylist.get(n).getHealth() <= 0) {  
			    System.out.println("GameOver！");
			} else {  
			    System.out.println("结束战斗！");  
			}
		
    	}
    
}