class GymMember {private String id;private int fee;private int[] history=new int[10];private int count;
 public GymMember(String id,int fee){if(id==null||id.trim().length()<4)throw new IllegalArgumentException("Invalid ID");if(fee<=0)throw new IllegalArgumentException("Fee must be positive");this.id=id;this.fee=fee;}
 protected void chargeLateFee(int amount){if(count>=10)throw new IllegalStateException("History full");history[count++]=amount;}
 public int[] getLateFeeHistory(){return java.util.Arrays.copyOf(history,count);}public int getTotalLateFees(){int t=0;for(int i=0;i<count;i++)t+=history[i];return t;}
}
class PremiumMember extends GymMember {private String trainer;public PremiumMember(String id,int fee,String t){super(id,fee);trainer=t;}@Override protected void chargeLateFee(int amount){super.chargeLateFee(amount/2);}}
public class PremiumLoyaltyLateFeeLedgerMain {public static void main(String[] a){PremiumMember p=new PremiumMember("MEM5",2000,"Coach Riya");p.chargeLateFee(200);System.out.println(p.getTotalLateFees());int[] h=p.getLateFeeHistory();h[0]=999;System.out.println(java.util.Arrays.toString(p.getLateFeeHistory()));}}
