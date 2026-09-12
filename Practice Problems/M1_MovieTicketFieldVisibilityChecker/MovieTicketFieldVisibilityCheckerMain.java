public class MovieTicketFieldVisibilityCheckerMain {
    static class AccessChecker {
        static String classifyAccess(String m,String c){if("public".equals(m))return"ALLOWED";if("private".equals(m))return"SAME_CLASS".equals(c)?"ALLOWED":"DENIED";if("default".equals(m)||"protected".equals(m))return("SAME_CLASS".equals(c)||"SAME_PACKAGE".equals(c))?"ALLOWED":"DENIED";return"DENIED";}
        static String summarizeBatch(String[][] a){int al=0,de=0;if(a!=null)for(String[] x:a)if(x!=null&&x.length>=2)if("ALLOWED".equals(classifyAccess(x[0],x[1])))al++;else de++;return"Allowed: "+al+" | Denied: "+de;}
    }
    static class MovieTicket{private String seatNumber;String screenId;protected double ticketPrice;public String movieTitle;MovieTicket(String s,String i,double p,String t){seatNumber=s;screenId=i;ticketPrice=p;movieTitle=t;}}
    public static void main(String[] args){String[][] a={{"default","SAME_PACKAGE"},{"default","DIFFERENT_PACKAGE"},{"public","DIFFERENT_PACKAGE"}};System.out.println(AccessChecker.classifyAccess("private","SAME_CLASS"));System.out.println(AccessChecker.classifyAccess("protected","DIFFERENT_PACKAGE"));System.out.println(AccessChecker.summarizeBatch(a));}
}
