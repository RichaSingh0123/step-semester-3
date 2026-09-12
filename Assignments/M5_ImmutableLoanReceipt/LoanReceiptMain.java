import java.util.Arrays;
public class LoanReceiptMain {
    // The prompt requires both final LoanReceipt and a subclass, which Java forbids.
    // This compilable version keeps the base class non-final.
    static class LoanReceipt {
        private final String memberId; private final String[] bookIds;
        public LoanReceipt(String id,String[] ids){memberId=id;bookIds=ids==null?new String[0]:ids.clone();}
        public String getMemberId(){return memberId;} public String[] getBookIds(){return bookIds.clone();}
        public LoanReceipt withCorrectedBookId(int i,String id){if(i<0||i>=bookIds.length)throw new IndexOutOfBoundsException();String[] x=bookIds.clone();x[i]=id;return new LoanReceipt(memberId,x);}
    }
    static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        private final String roomNumber;
        public ReferenceOnlyLoanReceipt(String id,String[] ids,String room){super(id,ids);roomNumber=room;}
    }
    static class CirculationLedger {
        static String branchCode; static{branchCode="PT-BRANCH-01";}
        static String processNightlyCirculation(LoanReceipt[] a){int p=0,n=0,r=0,o=0;if(a!=null)for(LoanReceipt x:a){if(x==null){n++;continue;}p++;if(x instanceof ReferenceOnlyLoanReceipt)r++;else o++;}return p+" processed | "+n+" null skipped | "+r+" reference-only | "+o+" regular";}
    }
    public static void main(String[] args){LoanReceipt r=new LoanReceipt("LIB-8841",new String[]{"BK-100","BK-101"});String[] x=r.getBookIds();x[0]="HACKED";System.out.println(r.getBookIds()[0]);LoanReceipt c=r.withCorrectedBookId(1,"BK-102");System.out.println(Arrays.toString(r.getBookIds()));System.out.println(Arrays.toString(c.getBookIds()));System.out.println(CirculationLedger.processNightlyCirculation(new LoanReceipt[]{new ReferenceOnlyLoanReceipt("LIB-001",new String[]{"BK-200"},"Reading Room 3"),null,new LoanReceipt("LIB-002",new String[]{"BK-201"})}));}
}
