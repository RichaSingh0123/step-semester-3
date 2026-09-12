public class ReferenceDeskSubclassReachMain {
    static class AccessChecker {
        static String classifyAccess(String m,String c) {
            if("public".equals(m))return "ALLOWED";
            if("private".equals(m))return "SAME_CLASS".equals(c)?"ALLOWED":"DENIED";
            if("default".equals(m))return ("SAME_CLASS".equals(c)||"SAME_PACKAGE".equals(c))?"ALLOWED":"DENIED";
            if("protected".equals(m))return ("SAME_CLASS".equals(c)||"SAME_PACKAGE".equals(c)||"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(c))?"ALLOWED":"DENIED";
            return "DENIED";
        }
        static String firstDeniedAttempt(String[][] a) {
            if(a!=null) for(int i=0;i<a.length;i++) if(a[i]!=null&&a[i].length>=2&&"DENIED".equals(classifyAccess(a[i][0],a[i][1])))
                return a[i][0]+" via "+a[i][1]+" (attempt #"+(i+1)+")";
            return "None Denied";
        }
    }
    static class LibraryMember { protected double finesOwed; }
    static class PremiumMember extends LibraryMember { void addFine(double x){finesOwed+=x;} }
    public static void main(String[] args) {
        String[][] a={{"public","SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},{"protected","SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},{"protected","SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}};
        System.out.println(AccessChecker.firstDeniedAttempt(a));
        PremiumMember p=new PremiumMember();p.addFine(100);System.out.println(p.finesOwed);
    }
}
