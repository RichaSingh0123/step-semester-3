public class MembershipFieldReachCheckerMain {
    static class AccessChecker {
        static String classifyAccess(String m, String c) {
            if ("public".equals(m)) return "ALLOWED";
            if ("private".equals(m)) return "SAME_CLASS".equals(c) ? "ALLOWED" : "DENIED";
            if ("default".equals(m) || "protected".equals(m))
                return ("SAME_CLASS".equals(c) || "SAME_PACKAGE".equals(c)) ? "ALLOWED" : "DENIED";
            return "DENIED";
        }
        static String summarizeByModifier(String[][] a) {
            String[] ms={"private","default","protected","public"}; int[] al=new int[4], de=new int[4];
            if(a!=null) for(String[] x:a) if(x!=null&&x.length>=2) {
                int i=-1; for(int j=0;j<ms.length;j++) if(ms[j].equals(x[0])) i=j;
                if(i>=0) if("ALLOWED".equals(classifyAccess(x[0],x[1]))) al[i]++; else de[i]++;
            }
            StringBuilder s=new StringBuilder();
            for(int i=0;i<ms.length;i++){if(i>0)s.append(" | ");s.append(ms[i]).append(": ").append(al[i]).append(" allowed / ").append(de[i]).append(" denied");}
            return s.toString();
        }
    }
    static class LibraryMember {
        private String membershipPin; String branchCode; protected double finesOwed; public String displayName;
        LibraryMember(String p,String b,double f,String n){membershipPin=p;branchCode=b;finesOwed=f;displayName=n;}
    }
    public static void main(String[] args) {
        String[][] a={{"private","SAME_CLASS"},{"private","SAME_PACKAGE"},{"default","SAME_PACKAGE"},{"default","DIFFERENT_PACKAGE"},{"protected","SAME_PACKAGE"},{"protected","SAME_CLASS"},{"public","DIFFERENT_PACKAGE"}};
        System.out.println(AccessChecker.classifyAccess("private","SAME_CLASS"));
        System.out.println(AccessChecker.classifyAccess("protected","DIFFERENT_PACKAGE"));
        System.out.println(AccessChecker.summarizeByModifier(a));
        System.out.println(new LibraryMember("PIN123","BR01",250,"Aarav").displayName);
    }
}
