package leetCode;

public class EveningPrayerCountdown {
    public static String eveningPrayerCountdown(int startNumber, int endNumber) {
        // Write code here
       // int index= endNumber;
        while (endNumber<=startNumber){
            if(startNumber%3==0){
                System.out.println("Peace");
                startNumber--;
            }if(startNumber%3!=0 && startNumber%5!=0){
                System.out.println(startNumber);
                startNumber--;
            }
            if(startNumber%5==0){
                startNumber--;
            }

        }
        return "Amen";
    }

    public static void main(String[] args) {

        System.out.println( eveningPrayerCountdown(5,1));;
    }
}
