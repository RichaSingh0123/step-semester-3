public class BookCopyCirculationGuardMain {
    static class BookInventory {
        private final int copiesTotal; private int copiesAvailable;
        BookInventory(int n){if(n<=0)throw new IllegalArgumentException("copiesTotal must be positive");copiesTotal=n;copiesAvailable=n;}
        void checkOut(){if(copiesAvailable>0)copiesAvailable--;}
        void checkIn(){if(copiesAvailable<copiesTotal)copiesAvailable++;}
        int getCopiesAvailable(){return copiesAvailable;}
    }
    public static void main(String[] args){BookInventory b=new BookInventory(3);for(int i=0;i<4;i++)b.checkOut();System.out.println(b.getCopiesAvailable());for(int i=0;i<4;i++)b.checkIn();System.out.println(b.getCopiesAvailable());}
}
