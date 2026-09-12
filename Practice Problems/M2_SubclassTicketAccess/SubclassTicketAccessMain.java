public class SubclassTicketAccessMain {
    static class AccessChecker{static String classifyAccess(String m,String c){if("public".equals(m))return"ALLOWED";if("private".equals(m))return"SAME_CLASS".equals(c)?"ALLOWED":"DENIED";if("default".equals(m))return("SAME_CLASS".equals(c)||"SAME_PACKAGE".equals(c))?"ALLOWED":"DENIED";if("protected".equals(m))return("SAME_CLASS".equals(c)||"SAME_PACKAGE".equals(c)||"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(c))?"ALLOWED":"DENIED";return"DENIED";}}
    static class MovieTicket{protected double ticketPrice=300;} static class PremiumMovieTicket extends MovieTicket{double readOwnPrice(){return ticketPrice;}}
    public static void main(String[] args){System.out.println(AccessChecker.classifyAccess("protected","SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));System.out.println(AccessChecker.classifyAccess("protected","SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));System.out.println(new PremiumMovieTicket().readOwnPrice());}
}
