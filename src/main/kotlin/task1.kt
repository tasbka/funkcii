private fun logicGame (n :Int, nbot: Int ): Boolean {
    if((n == 1 && nbot == 1) || (n == 2 && nbot == 2) || (n == 3 && nbot == 3)) {
        println("Ничья. Попробуйте ещё раз")
        return true
    }
    else
        if((n == 1 && nbot == 2) || (n == 2 && nbot == 3) || (n == 3 && nbot == 1))
        {
            print("Вы победили. Спасибо за игру")
            return false
        } else
            if ((n == 1 && nbot == 3) || (n == 2 && nbot == 1) || (n == 3 && nbot == 2)){
                print("Вы проиграли. Спасибо за игру")
                return false
            }


    return true
}

fun main(args: Array<String>) {
    println("Добро пожаловать в игру `Камень-Ножницы-Бумага`")
    println("Выберите действие:")
    println("1. Камень 2. Ножницы 3. Бумага")
    var status = true

    while(status){
        val n = readln()
        val nbot = (1..3).random()

        if(n.toInt() == 1)
            println("Ваш выбор: камень")
        else if(n.toInt() == 2)
            println("Ваш выбор: ножницы")
        else if(n.toInt() == 3)
            println("Ваш выбор: бумага")
        else println("Нет такого варианта")

        if(nbot == 1)
            println("Выбор противника: камень")
        else if(nbot== 2)
            println("Выбор противника: ножницы")
        else
            println("Вабор противкника: бумага")

        when (n) {
            "1" -> status = logicGame(n.toInt(),nbot)
            "2" -> status = logicGame(n.toInt(),nbot)
            "3" -> status = logicGame(n.toInt(),nbot)
        }
    }
}