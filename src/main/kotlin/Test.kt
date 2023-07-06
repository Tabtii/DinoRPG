import Klassen.*

fun main(){
    var charakter1=Held().heldenWahl()
    var charakter2=Held().heldenWahl()
    var charakter3=Held().heldenWahl()
    var game = Game()
    game.charakterePLUS(charakter1)
    game.charakterePLUS(charakter2)
    game.charakterePLUS(charakter3)
}