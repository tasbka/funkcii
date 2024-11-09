fun main() {
    val map = mapOf(
        1 to 'А', 2 to 'Б', 3 to 'В', 4 to 'Г', 5 to 'Д', 6 to 'Е', 7 to 'Ж', 8 to 'З', 9 to 'И', 10 to 'К',
        11 to 'Л', 12 to 'М', 13 to 'Н', 14 to 'О', 15 to 'П', 16 to 'Р', 17 to 'С', 18 to 'Т', 19 to 'У', 20 to 'Ф',
        21 to 'Х', 22 to 'Ц', 23 to 'Ч', 24 to 'Ш', 25 to 'Щ', 26 to 'Ь', 27 to 'Ы', 28 to 'Ъ', 29 to 'Э', 30 to 'Ю', 31 to 'Я'
    )

    val array = Array(31) { Array(31) { "" } }
    var a = 1
    for (i in 0..30) {
        for (j in 0..30) {
            array[i][j] = if (a < 10) {
                "00$a"
            } else if (a < 100) {
                "0$a"
            } else {
                "$a"
            }
            a++
        }
    }
    println("Введите сообщение для шифрования:")
    val sourse = readLine()!!.toCharArray()

    var finalSource = sourse
    if (sourse.size % 2 != 0) {
        finalSource = sourse + 'Я'
    }
    println()

    val Message = encrypt(finalSource, map, array)
    println("Зашифрованное сообщение: $Message")

    println("Введите зашифрованное сообщение для расшифровки:")
    val encryptedInput = readLine()?.split(" ")!!.toTypedArray()
    val MessageOutput = decrypt(encryptedInput, map, array)
    println("Расшифрованное сообщение: $MessageOutput")
}
fun encrypt(finalSource: CharArray, map: Map<Int, Char>, array: Array<Array<String>>): String {
    var result = ""
    var firstIndex = -1
    var secondIndex = -1
    for (i in finalSource.indices step 2) {
        val firstChar = finalSource[i]
        val secondChar = finalSource[i+1]

        for (v in map) {
            if (v.value == firstChar) {
                firstIndex = v.key-1
                break
            }
        }

        for (v in map) {
            if (v.value == secondChar) {
                secondIndex = v.key-1
                break
            }
        }
        result += "${array[firstIndex][secondIndex]} "
    }
    return result
}
fun decrypt(Message: Array<String>, map: Map<Int, Char>, array: Array<Array<String>>): String {
    var result = ""

    for (code in Message) {
        for (i in 0..30) {

            for (j in 0..30) {
                if (array[i][j] == code) {
                    val firstChar = map[i+1]
                    val secondChar = map[j+1]
                    result += "$firstChar$secondChar"
                    break
                }

            }
        }
    }

    return result
}