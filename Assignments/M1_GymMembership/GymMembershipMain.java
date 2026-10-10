class GymMember {
 protected String memberId; protected int monthlyFee; private int sessions; private int[] fees=new int[10]; private int feeCount;
 public GymMember(String id,int fee){if(id==null||id.trim().length()<4)throw new IllegalArgumentException("Invalid member ID");if(fee<=0)throw new IllegalArgumentException("Fee must be positive");memberId=id;monthlyFee=fee;}
 public void attendSession(){sessions++;} public int getSessionsAttended(){return sessions;}
 public void displayInfo(){System.out.print("Standard Member | Sessions: "+sessions);}
 protected void chargeLateFee(int amount){if(feeCount==10)throw new IllegalStateException("History full");fees[feeCount++]=amount;}
 public int[] getLateFeeHistory(){return java.util.Arrays.copyOf(fees,feeCount);}
 public int getTotalLateFees(){int t=0;for(int i=0;i<feeCount;i++)t+=fees[i];return t;}
}
class PremiumMember extends GymMember {
 private String trainerName;
 public PremiumMember(String id,int fee,String trainer){super(id,fee);trainerName=trainer;}
 public String getTrainerName(){return trainerName;}
 @Override public void displayInfo(){System.out.print("Premium Member | Trainer: "+trainerName+" | Sessions: "+getSessionsAttended());}
 @Override protected void chargeLateFee(int amount){super.chargeLateFee(amount/2);}
}
class EliteMember extends PremiumMember {
 private String lockerNumber;
 public EliteMember(String id,int fee,String trainer,String locker){super(id,fee,trainer);lockerNumber=locker;}
 @Override public void displayInfo(){System.out.print("Elite Member | Trainer: "+getTrainerName()+" | Locker: "+lockerNumber+" | Sessions: "+getSessionsAttended());}
}
class GroupClassMember extends GymMember {
 private String className;
 public GroupClassMember(String id,int fee,String name){super(id,fee);className=name;}
 @Override public void displayInfo(){System.out.print("Group Class Member | Class: "+className+" | Sessions: "+getSessionsAttended());}
}
public class GymMembershipMain {
 public static String signUpBatch(String[] ids,int fee){int ok=0,bad=0;for(String id:ids)try{new GymMember(id,fee);ok++;}catch(IllegalArgumentException e){bad++;}return "Signed Up: "+ok+" | Rejected: "+bad;}
 public static void main(String[] args){System.out.println(signUpBatch(new String[]{"MEM1","GM1","MEM2"," ","MEM3"},1000));PremiumMember p=new PremiumMember("MEM01",2000,"Coach Riya");p.attendSession();p.attendSession();p.chargeLateFee(200);System.out.println(p.getSessionsAttended()+" sessions; late fees="+p.getTotalLateFees());}
}
