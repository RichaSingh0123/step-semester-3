class GymMember { protected String memberId; protected int monthlyFee; private int sessions;
 public GymMember(String id,int fee){if(id==null||id.trim().length()<4)throw new IllegalArgumentException("Invalid ID");if(fee<=0)throw new IllegalArgumentException("Fee must be positive");memberId=id;monthlyFee=fee;}
 public void attendSession(){sessions++;} public int getSessionsAttended(){return sessions;}
 public void displayInfo(){System.out.print("Standard Member | Sessions: "+sessions);}
}
class PremiumMember extends GymMember {protected String trainerName;public PremiumMember(String id,int fee,String t){super(id,fee);trainerName=t;}public String getTrainerName(){return trainerName;}@Override public void displayInfo(){System.out.print("Premium Member | Trainer: "+trainerName+" | Sessions: "+getSessionsAttended());}}
class EliteMember extends PremiumMember {private String locker;public EliteMember(String id,int fee,String t,String l){super(id,fee,t);locker=l;}@Override public void displayInfo(){System.out.print("Elite Member | Trainer: "+trainerName+" | Locker: "+locker+" | Sessions: "+getSessionsAttended());}}
class GroupClassMember extends GymMember {private String className;public GroupClassMember(String id,int fee,String c){super(id,fee);className=c;}@Override public void displayInfo(){System.out.print("Group Class Member | Class: "+className+" | Sessions: "+getSessionsAttended());}}
public class ThreeTiersGymMembershipMain {
 public static String classifyGeneration(GymMember m){if(m instanceof EliteMember)return "Multilevel descendant (3 generations deep)";if(m instanceof GroupClassMember)return "Hierarchical sibling (independent branch)";if(m instanceof PremiumMember)return "Premium generation";return "Base generation";}
 public static int getTotalSessionsAttended(GymMember[] ms){int n=0;for(GymMember m:ms)n+=m.getSessionsAttended();return n;}
 public static void main(String[] args){PremiumMember p=new PremiumMember("MEM2",2000,"Coach Riya");EliteMember e=new EliteMember("MEM3",3000,"Coach Arjun","L12");GroupClassMember g=new GroupClassMember("MEM4",1500,"Zumba");p.attendSession();p.attendSession();p.attendSession();e.attendSession();e.attendSession();for(int i=0;i<4;i++)g.attendSession();System.out.println(classifyGeneration(e));System.out.println(classifyGeneration(g));System.out.println(getTotalSessionsAttended(new GymMember[]{p,e,g}));}
}
