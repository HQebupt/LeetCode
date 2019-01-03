import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendar {

    TreeSet<int[]> books = new TreeSet<int[]>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        int[] cur = new int[]{start, end};
        int[] floor = books.floor(cur);
        int[] ceiling = books.ceiling(cur);
        if (floor != null && (start < floor[1])) {
            return false;
        }
        if (ceiling != null && (ceiling[0] < end)) {
            return false;
        }
        books.add(cur);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */