public class SeatBookingEncapsulationGuardMain {
    static class CineScreen{private final int seatsTotal;private int seatsAvailable;CineScreen(int n){if(n<=0)throw new IllegalArgumentException("seatsTotal must be positive");seatsTotal=n;seatsAvailable=n;}void bookSeat(){if(seatsAvailable>0)seatsAvailable--;}void cancelBooking(){if(seatsAvailable<seatsTotal)seatsAvailable++;}int getSeatsAvailable(){return seatsAvailable;}}
    public static void main(String[] args){CineScreen c=new CineScreen(2);for(int i=0;i<3;i++)c.bookSeat();System.out.println(c.getSeatsAvailable());for(int i=0;i<3;i++)c.cancelBooking();System.out.println(c.getSeatsAvailable());}
}
