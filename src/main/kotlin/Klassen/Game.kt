package Klassen

import kotlin.system.exitProcess

var dinoListe = mutableListOf<Charakter>()
var heroListe = mutableListOf<Charakter>()
var reihenfolgeListe = mutableListOf<Charakter>()
var gameLvl = 1
var runden = 0

class Game {
    fun gegnerPlus() {
        when (gameLvl) {
            1 -> {
                repeat(2) { charakterePLUS(Dino().randomDino()) }
            }

            2 -> {
                repeat(3) { charakterePLUS(Dino().randomDino()) }
            }

            3 -> {
                repeat(4) { charakterePLUS(Dino().randomDino()) }
            }

            4 -> {
                println("GEWONNEN GUT GEMACHT!")
                exitProcess(69)
            }
        }
    }

    fun spielStarten() {
        println("Wie viele Helfer sollen dich unterstützen")
        println("--1-- oder --2-- oder --3--")
        var eingabe = readln()
        when (eingabe) {
            "1" -> {
                charakterePLUS(Held().heldErstellen())
                charakterePLUS(Held().heldenWahl())
                gameLvl = 1
            }

            "2" -> {
                charakterePLUS(Held().heldErstellen())
                charakterePLUS(Held().heldenWahl())
                charakterePLUS(Held().heldenWahl())
                gameLvl = 2
            }

            "3" -> {
                charakterePLUS(Held().heldErstellen())
                charakterePLUS(Held().heldenWahl())
                charakterePLUS(Held().heldenWahl())
                gameLvl = 3
            }
        }
        gegnerPlus()
    }

    fun charakterePLUS(charakter: Charakter) {
        when (charakter) {
            is Held -> heroListe.add(charakter)
            else -> dinoListe.add(charakter)
        }
    }

    fun kampfUnfaehig() {

        var i = 0
        siegOderLose()
        while (i <= reihenfolgeListe.lastIndex) {
            if (reihenfolgeListe[i].lp <= 0) {
                println("${reihenfolgeListe[i].name} ist kampfunfähig.")
                reihenfolgeListe.removeAt(i)
                Thread.sleep(1000)
                i++
            } else break
        }


    }

    fun siegOderLose(): Boolean {
        when {
            reihenfolgeListe.filterIsInstance<Dino>().isEmpty() -> {
                println("Gewonnen")
                return false
            }

            reihenfolgeListe.filterIsInstance<Held>().isEmpty() -> {
                println("Verloren")
                return false
            }
        }
        return true
    }

    fun runde(): Int {
        runden += 1
        return runden
    }

    fun zurueckSetzen(boolean: Boolean) {
        when (boolean) {
            false -> for (x in reihenfolgeListe) {
                x.resetWerte()
            }

            true -> println()
        }
    }

    fun gegnerWahl(): Charakter {
        var i = 1
        println("Gegner auswählen:")
        for (gegner in reihenfolgeListe.filterIsInstance<Dino>()) {
            println("--${i}--${gegner.name}")
            i++
        }
        var help = 0
        var eingabe = readln()
        when {
            eingabe == "1" -> {
                help = eingabe.toInt() - 1
            }

            eingabe == "2" -> {
                help = eingabe.toInt() - 1
            }

            eingabe == "3" -> {
                help = eingabe.toInt() - 1
            }

            else -> {
                println("Falsche Eingabe!")

            }
        }
        return reihenfolgeListe.filterIsInstance<Dino>()[help]
    }

    fun kampf() {
        reihenfolge()

        while (siegOderLose()) {

            for (char in reihenfolgeListe) {
                char.showLebenPunkte()
                println()
                Thread.sleep(1000)

            }
            var i= 0
            while (i <= reihenfolgeListe.lastIndex) {
                kampfUnfaehig()
                reihenfolgeListe[i].aktion()
                kampfUnfaehig()
                i++
            }
            reihenfolge()
            runde()
        }
    }

    fun reihenfolge() {
        var i = 0
        var list1 = dinoListe
        list1.shuffle()
        var list2 = heroListe
        list2.shuffle()
        do {


            when (i) {
                0 -> {
                    i++
                    if (list2.isEmpty() && list1.isEmpty()) {
                        break
                    }
                    if (list1.isEmpty() && list2.isNotEmpty()) {
                        continue
                    }
                    reihenfolgeListe.add(list1.first())
                    list1.remove(list1.first())


                }

                1 -> {
                    i++
                    if (list2.isEmpty() && list1.isEmpty()) {
                        break
                    }
                    if (list2.isEmpty()) {
                        continue
                    }
                    reihenfolgeListe.add(list2.first())
                    list2.remove(list2.first())

                }

                2 -> {
                    i -= 2
                }
            }

        } while (true)

    }
}