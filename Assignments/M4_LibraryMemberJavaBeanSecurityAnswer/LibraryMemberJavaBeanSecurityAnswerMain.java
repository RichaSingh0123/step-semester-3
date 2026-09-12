public class LibraryMemberJavaBeanSecurityAnswerMain {
    public static class LibraryMember {
        private String membershipId,name,securityAnswerHash; private boolean premiumMember;
        public LibraryMember(){}
        public String getMembershipId(){return membershipId;}
        public void setMembershipId(String id){if(membershipId==null)membershipId=id;}
        public String getName(){return name;} public void setName(String n){name=n;}
        public boolean isPremiumMember(){return premiumMember;} public void setPremiumMember(boolean p){premiumMember=p;}
        public void setSecurityAnswer(String answer){securityAnswerHash=answer==null?null:Integer.toHexString(answer.hashCode());}
    }
    public static void main(String[] args){LibraryMember m=new LibraryMember();m.setMembershipId("LIB-8841");m.setName("Priya Nair");m.setPremiumMember(true);m.setMembershipId("FAKE-0000");m.setSecurityAnswer("BlueMountain");System.out.println(m.getMembershipId());System.out.println(m.getName());System.out.println(m.isPremiumMember());}
}
