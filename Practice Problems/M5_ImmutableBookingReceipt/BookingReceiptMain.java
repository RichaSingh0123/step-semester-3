import java.util.Arrays;
public class BookingReceiptMain {
    // The prompt requires both final BookingReceipt and a subclass, impossible in Java.
    // This compilable version keeps the base class non-final.
    static class BookingReceipt{private final String bookingId;private final String[] seatNumbers;public BookingReceipt(String id,String[] s){bookingId=id;seatNumbers=s==null?new String[0]:s.clone();}public String getBookingId(){return bookingId;}public String[] getSeatNumbers(){return seatNumbers.clone();}public BookingReceipt withUpdatedSeat(int i,String s){if(i<0||i>=seatNumbers.length)throw new IndexOutOfBoundsException();String[] x=seatNumbers.clone();x[i]=s;return new BookingReceipt(bookingId,x);}}
    static class GroupBookingReceipt extends BookingReceipt{private final int groupSize;public GroupBookingReceipt(String id,String[] s,int n){super(id,s);if(n<=0)throw new IllegalArgumentException("groupSize must be positive");groupSize=n;}}
    static String processNightlySettlement(BookingReceipt[] a){int p=0,n=0,g=0,i=0;if(a!=null)for(BookingReceipt x:a){if(x==null){n++;continue;}p++;if(x instanceof GroupBookingReceipt)g++;else i++;}return p+" processed | "+n+" null skipped | "+g+" group | "+i+" individual";}
    public static void main(String[] args){BookingReceipt b=new BookingReceipt("CH-1001",new String[]{"A1","A2"});String[] s=b.getSeatNumbers();s[0]="X";System.out.println(b.getSeatNumbers()[0]);BookingReceipt u=b.withUpdatedSeat(1,"A3");System.out.println(Arrays.toString(b.getSeatNumbers()));System.out.println(Arrays.toString(u.getSeatNumbers()));System.out.println(processNightlySettlement(new BookingReceipt[]{new GroupBookingReceipt("CH-2002",new String[]{"B1","B2"},2),null,new BookingReceipt("CH-3003",new String[]{"C1"})}));}
}
