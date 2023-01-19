fun main() {
    println(howManySeconds(240))
}

fun howManySeconds(seconds: Int): String {
    val timeMinutes = seconds / 60
    val timeHours = seconds / (60 * 60)
    val total: String = when (seconds) {
        in 0..60 -> return "был(а) в сети только что"
        in 61..60 * 60 -> return endingMinutes(timeMinutes)
        in 60 * 60 + 1..24 * 60 * 60 -> return endingHours(timeHours)
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети вчера"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) в сети позавчера"
        else -> "Давно"
    }
    return total
}

fun endingMinutes(time: Int) = when (time) {
    1, 21, 31, 41, 51 -> "был(а) в сети $time минуту назад"
    in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "был(а) в сети $time минуты назад"
    in 5..20, in 25..30, in 35..40, in 45..50, in 55..60 -> "был(а) в сети $time минут назад"
    else -> "Давно"
}

fun endingHours(time: Int) = when (time) {
    1, 21 -> "был(а) в сети $time час назад"
    in 2..4, in 22..24 -> "был(а) в сети $time часа назад"
    in 5..20 -> "был(а) в сети $time часов назад"
    else -> "Давно"
}