import Klassen.*

fun main() {
    // Das gameLvl bestimmt mit wie vielen gegnern man beginnt 1 = 1 Gegner usw. Lvl 4 ist der Boss!
    gameLvl = 1
    var game = Game()
    game.spielStarten()
    game.kampf()
}