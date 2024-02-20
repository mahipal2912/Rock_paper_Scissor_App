fun main() {

    val options = arrayOf("Rock", "Paper", "Scissors")

    val gameChoice = getGameChoice(options)

    val userChoice = getUserChoice(options)

    printResult(userChoice, gameChoice)
}


fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]


fun getUserChoice(optionsParam: Array<String>): String {

    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        // Ask user for their choice
        println("Please enter one of the following")
        for (item in optionsParam) print(" $item")
        println(".")

        // Read the User Input
        val userInput = readlnOrNull()

        // Validate the user input
        if (userInput != null &&  userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }

        // if Choice is invalid inform the User
        if (!isValidChoice) println("Please enter a valid Choice.")

    }
    return userChoice

}


fun printResult(userChoice: String, gameChoice: String) {

    val result: String = if (userChoice == gameChoice) {
        "Tie"

    } else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")
    ) {
        "you Win!"

    } else
        "you lose!"

    println("you chose $userChoice. Computer chose $gameChoice. $result")
}


