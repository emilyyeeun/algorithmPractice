import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 유저와 인덱스 매핑
        HashMap<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }
        // 동일한 유저에 대한 신고 횟수는 1회 처리 -> set으로 변환
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // 신고당한 횟수 기록
        int[] reported = new int[indexMap.size()];
        for (String pair : reportSet) {
            String reportUser = pair.split(" ")[0];
            String reportedUser = pair.split(" ")[1];
            reported[indexMap.get(reportedUser)]++;
        }
        
        // k번 이상 신고한 유저 기록
        int[] getMail = new int[indexMap.size()];
        for (String pair : reportSet) {
            String reportUser = pair.split(" ")[0];
            String reportedUser = pair.split(" ")[1];
            if (reported[indexMap.get(reportedUser)] >= k) {
                getMail[indexMap.get(reportUser)]++;
            }
        }
        return getMail;
    }
}
