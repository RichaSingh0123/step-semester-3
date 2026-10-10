public class Membership {
    public enum Status { ACTIVE, FROZEN, EXPIRED }
    private final String memberName;
    private final MembershipPlan plan;
    private Status status = Status.ACTIVE;
    public Membership(String memberName, MembershipPlan plan) { this.memberName = memberName; this.plan = plan; }
    public Status getStatus() { return status; }
    public String getMemberName() { return memberName; }
    public void checkIn() {
        if (status == Status.ACTIVE) System.out.println(memberName + " checked in successfully.");
        else System.out.println("Check-in denied: " + memberName + "'s membership is " + status + ".");
    }
    public void freeze() {
        if (status == Status.EXPIRED) { System.out.println("Cannot freeze an Expired membership."); return; }
        if (status == Status.FROZEN) { System.out.println(memberName + "'s membership is already Frozen."); return; }
        status = Status.FROZEN;
        System.out.println(memberName + "'s membership frozen. Status: Frozen.");
    }
    public void unfreeze() {
        if (status == Status.EXPIRED) { System.out.println("Cannot unfreeze an Expired membership."); return; }
        if (status == Status.FROZEN) { status = Status.ACTIVE; System.out.println(memberName + "'s membership unfrozen. Status: Active."); }
    }
    public void expire() {
        status = Status.EXPIRED;
        System.out.println(memberName + "'s membership expired. Status: Expired.");
    }
}
