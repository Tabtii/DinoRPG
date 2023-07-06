import Klassen.*

fun main() {
    var meinHeld = Owen()
    var held2 = Ian()
    var gegner1 = Compsognathus()
    var gegner2  =Velociraptor()
    var schaden = 0
    var feld = Spielfeld()

    feld.charakterePLUS(meinHeld)
    feld.charakterePLUS(held2)
    feld.charakterePLUS(gegner1)
    feld.charakterePLUS(gegner2)
    feld.reihenfolge()

}