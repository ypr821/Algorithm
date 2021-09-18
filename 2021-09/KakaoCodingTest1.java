import java.util.*;

class Solution {

  private final ArrayList<ReporteeInfo> reporteeInfoList = new ArrayList<ReporteeInfo>();

  public int[] solution(String[] idList, String[] report, int k) {
    int[] answer = new int[idList.length];
    //1. HashSet사용으로 중복값 제거
    Set<String> reportSet = new HashSet<>();
    //2. HashMap reportMap - 피신고자 키 : 이름, 값 : 신고한 사람 List 인 맵
    Map<String, ArrayList<String>> reportMap = new HashMap<>();

    for (String reprotStr : report) {
      reportSet.add(reprotStr);
    }

    for (String name : idList) {
      reportMap.put(name, new ArrayList<String>());
    }

    for (String reprotSetStr : reportSet) {
      String[] reprotSetStrArray = reprotSetStr.split(" ");

      ArrayList<String> nameList = reportMap.get(reprotSetStrArray[1]);
      nameList.add(reprotSetStrArray[0]);
    }

    for (int i = 0; i < idList.length; i++) {
      ReporteeInfo reporteeInfo = new ReporteeInfo(idList[i], reportMap);
      reporteeInfoList.add(reporteeInfo);
      if (reporteeInfo.getReportCountNum() >= k) {
        List<String> reportArrayList = reporteeInfo.getReportArrayList();
        for (int j = 0; j < reportArrayList.size(); j++) {
          for (int n = 0; n < idList.length; n++) {
            if (reportArrayList.get(j).equals(idList[n])) {
              answer[n] += 1;
            }
          }
        }
      }
    }
    return answer;
  }
}

class ReporteeInfo {

  //신고당한 사람 이름
  private final String reporteeName;
  //신고당한 횟수
  private final int reportCountNum;
  //신고한 사람 이름 List
  private final List<String> reportArrayList;

  ReporteeInfo(String reporteeName, Map<String, ArrayList<String>> reportMap) {
    this.reporteeName = reporteeName;
    this.reportCountNum = reportMap.get(reporteeName).size();
    this.reportArrayList = reportMap.get(reporteeName);
  }

  public int getReportCountNum() {
    return reportCountNum;
  }

  public List<String> getReportArrayList() {
    return reportArrayList;
  }
}














