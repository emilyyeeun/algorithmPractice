import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m) {
        return (this.end - m.end == 0) ? this.start - m.start : this.end - m.end;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfMeeting = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[numOfMeeting];

        for (int i = 0; i < numOfMeeting; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }

        printNumOfMeetings(meetings);
    }

    private static void printNumOfMeetings(Meeting[] meetings) {
        List<Meeting> listMeetings = Arrays.stream(meetings).sorted().collect(Collectors.toList());
        int totalNum = 1;
        int totalTime = listMeetings.get(0).end;
        if (meetings.length == 1) {
            System.out.println(totalNum);
            return;
        }
        for (int i = 1; i < listMeetings.size(); i++) {
            if (listMeetings.get(i).start >= totalTime) {
                totalNum++;
                totalTime = listMeetings.get(i).end;
            }
        }
        System.out.println(totalNum);
    }
}
