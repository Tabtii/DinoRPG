package Klassen

open class Charakter() {
    open var name = ""
    open var lp = 1
    open var atk = 1
    open var ver = 1
    open var maxLP = lp

    fun attack(): Int {
        println("${this.name} greift an!")
        return 25 + atk
    }

    fun takeDamage(schaden: Int) {
        var damagePoints = schaden - ver
        if (this.lp <= 0) {
            this.lp = 0
            println("${this.name} wurde besiegt.")
        }
        if (damagePoints <= 0) {
            this
            println("Es wurde kein schaden verursacht.")
        } else {
            println("${this.name} wurde $damagePoints schaden zugefügt.")
            this.lp -= damagePoints
        }
    }

    open fun spezialAngriff(): Int {
        return 0
    }

    open fun faehigkeit(): Int {
        return 0
    }

    fun showLebenPunkte() {
        println("${this.name} hat noch (${this.lp}/${this.maxLP}) LP.")
    }

    open fun aktion() {

        println("Was wollen sie machen.")
        println("--1--Gegner angreifen")
        println("--2--Spezial angriff")
        println("--3--Fähigkeit einsetzen")
        println("--4--Rucksack")
        var eingabe = readln()
        when {
            eingabe == "1" -> {
               attack()
            }

            eingabe == "2" -> {
                spezialAngriff()
            }

            eingabe == "3" -> {
               faehigkeit()
            }
            eingabe == "4" -> {
                println("Gibbebt noch net")
            }

            else -> {
                println("Falsche Eingabe!")
                aktion()
            }
        }
    }
}

