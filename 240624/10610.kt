import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    println(getMaxNum(input))
}

fun getMaxNum(n : String) : String {
    // 30의 배수란 3의 배수이면서 10의 배수로 마지막 일의 자리 숫자가 0이 되어야한다.
    var num : String = n.toCharArray().sortedDescending().joinToString("");
    if (!num.contains("0")) {
        return "-1"
    } else {
      // 합이 3의 배수인지 확인
        var sum = 0
        for (i in 0..num.length - 1) {
            sum += num.get(i).digitToInt()
        }
        if (sum % 3 != 0) {
            return "-1"
        } else {
            return num.toString()
        }
    }
}
