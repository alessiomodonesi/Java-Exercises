import java.util.Scanner;

public class Es7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, n_hour = 0, n_min = 0;
        int m = 0, m_hour = 0, m_min = 0;
        int tot_hour = 0, tot_min = 0;
        String time_start = "", time_end = "";

        do {
            System.out.print("start: ");
            n = in.nextInt();
        } while ((n < 0000 || n > 2359) || n % 100 >= 60);

        do {
            System.out.print("end: ");
            m = in.nextInt();
        } while ((m < 0000 || m > 2359) || m % 100 >= 60);
        in.close();

        n_hour = n / 100;
        m_hour = m / 100;
        n_min = n % 100;
        m_min = m % 100;

        if (n >= m) {
            tot_hour = m_hour - n_hour;
            tot_min = m_min - n_min;
        } else {
            tot_hour = (24 - n_hour) + m_hour;
            tot_min = m_min - n_min;
        }

        time_start = String.format("%d:%d", n_hour, n_min);
        time_end = String.format("%d:%d", m_hour, m_min);
        System.out.println(String.format("start: %s, stop: %s, time: %dh %dmin",
                time_start, time_end, tot_hour, tot_min));
    }
}
