import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

@Throws(IOException::class)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val inputs = br.readLine().split(" ")
    val girls: Int = Integer.parseInt(inputs[0])
    val boys: Int = Integer.parseInt(inputs[1])
    val internship: Int = Integer.parseInt(inputs[2]);

    println(getMaximumTeam(girls, boys, internship))
}

fun getMaximumTeam(girls: Int, boys: Int, internship: Int) : Int{
    var maxTeam = Math.min(girls / 2, boys)
    while (maxTeam * 2 + maxTeam + internship > girls + boys) {
        maxTeam -= 1
    }
    return maxTeam
}
