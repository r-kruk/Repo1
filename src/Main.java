import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    int birthDay = 8;
	    int birthMonth = 2;
	    int birthYear = 1994;

	    int todayDay = LocalDate.now().getDayOfMonth();
	    int todayMonth = LocalDate.now().getMonthValue();
	    int todayYear = LocalDate.now().getYear();

	    int sum = 0;

	    int[] monthLengthInNormalYear =
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		for (int i = birthYear + 1; i < todayYear; i++) {
			sum += isLeapYear(i) ? 366 : 365;
		}

		for (int i = birthMonth + 1; i <= 12; i++) {
			if(isLeapYear(birthYear) && i == 2) {
				sum += monthLengthInNormalYear[i] + 1; //obs³ugujemy luty przestêpny
			}
			else{
				sum += monthLengthInNormalYear[i];
			}
		}

		if(birthMonth == 2 && isLeapYear(birthYear)){
			sum += (29 - birthDay);
		}
		else{
			sum += (monthLengthInNormalYear[birthMonth] - birthDay);
		}

		for (int i = 1; i < todayMonth; i++) {
			if(isLeapYear(todayYear) && i == 2) {
				sum += monthLengthInNormalYear[i] + 1; //obs³ugujemy luty przestêpny
			}
			else{
				sum += monthLengthInNormalYear[i];
			}
		}

		sum += todayDay;

		System.out.println(sum);
    }

    private static boolean isLeapYear(int year){
    	return (year % 4 == 0 && year % 100 != 0)
				|| (year % 400 == 0);
	}
}