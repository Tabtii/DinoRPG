package Klassen

import kotlin.system.exitProcess

var dinoListe = mutableListOf<Charakter>()
var heroListe = mutableListOf<Charakter>()
var reihenfolgeListe = mutableListOf<Charakter>()
var gameLvl = 1
var runden = 0
var rucksack = mutableListOf<Item>(Item.zufallItem())
var hilfsWertSpezialAng = (0..10).random()

class Game {
    fun gegnerPlus() {
        when (gameLvl) {
            1 -> {
                charakterePLUS(Dino().randomDino())
            }

            2 -> {
                repeat(2) { charakterePLUS(Dino().randomDino()) }
            }

            3 -> {
                repeat(3) { charakterePLUS(Dino().randomDino()) }
            }

            4 -> {
                charakterePLUS(Dino().randomDino())

            }
        }
    }

    fun spielStarten() {
        println(
            "\n" + "\n" + " __          ___ _ _ _                                        \n" + " \\ \\        / (_) | | |                                       \n" + "  \\ \\  /\\  / / _| | | | _____  _ __ ___  _ __ ___   ___ _ __  \n" + "   \\ \\/  \\/ / | | | | |/ / _ \\| '_ ` _ \\| '_ ` _ \\ / _ \\ '_ \\ \n" + "    \\  /\\  /  | | | |   < (_) | | | | | | | | | | |  __/ | | |\n" + "     \\/  \\/   |_|_|_|_|\\_\\___/|_| |_| |_|_| |_| |_|\\___|_| |_|\n" + "                                                              \n" + "                                                              \n" + "\n"
        )
        Thread.sleep(1000)
        println("Wie viele Söldner willst du anheuern?")
        println("--1-- oder --2-- oder --3--")
        var eingabe = readln()
        when (eingabe) {
            "1" -> {
                charakterePLUS(Held().heldErstellen())
                charakterePLUS(Held().heldenWahl())

            }

            "2" -> {
                charakterePLUS(Held().heldErstellen())
                charakterePLUS(Held().heldenWahl())
                charakterePLUS(Held().heldenWahl())

            }

            "3" -> {
                charakterePLUS(Held().heldErstellen())
                charakterePLUS(Held().heldenWahl())
                charakterePLUS(Held().heldenWahl())
                charakterePLUS(Held().heldenWahl())

            }

            "4" -> {
                println("Alleine!?")
                println()
                charakterePLUS(Held().heldErstellen())
                println()
                Thread.sleep(1000)
            }
        }
        gegnerPlus()
    }

    fun nextLvl() {
        println("Achtung es kommen noch mehr!")
        when (gameLvl){
            2 -> { rucksack.add(Item.zufallItem())}
            3 -> repeat(2){ rucksack.add(Item.zufallItem())}
            4 -> repeat(3){ rucksack.add(Item.zufallItem())}
        }
        Thread.sleep(1000)
        heroListe.clear()
        dinoListe.clear()
        for (held in reihenfolgeListe.filterIsInstance<Held>()) {
            heroListe.add(held)
            held.resetWerte()
        }
        reihenfolgeListe.clear()
        gegnerPlus()
        reihenfolge()
    }

    fun charakterePLUS(charakter: Charakter) {
        when (charakter) {
            is Held -> heroListe.add(charakter)
            else -> dinoListe.add(charakter)
        }
    }

    fun sieg(): Boolean {
        when {
            reihenfolgeListe.filterIsInstance<Dino>().isEmpty() -> {
                return false
            }


        }
        return true
    }

    fun lose(): Boolean {
        when {
            reihenfolgeListe.filterIsInstance<Held>().isEmpty() -> {
                return false
            }
        }
        return true
    }

    fun runde(): Int {
        runden += 1
        return runden
    }

    fun gegnerWahl(): Charakter {
        var i = 1
        println("Gegner auswählen:")
        for (gegner in reihenfolgeListe.filterIsInstance<Dino>()) {
            println("--${i}--${gegner.name} LP: ${gegner.lp}/${gegner.maxLP}")
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

            eingabe == "4" -> {
                help = eingabe.toInt() - 1
            }

            else -> {
                println("Falsche Eingabe!")

            }
        }
        return reihenfolgeListe.filterIsInstance<Dino>()[help]
    }

    fun heroWahl(): Charakter {
        var i = 1
        println("Gegner auswählen:")
        for (held in reihenfolgeListe.filterIsInstance<Held>()) {
            println("--${i}--${held.name} LP: ${held.lp}/${held.maxLP}")
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

            eingabe == "4" -> {
                help = eingabe.toInt() - 1
            }

            else -> {
                println("Falsche Eingabe!")

            }
        }
        return reihenfolgeListe.filterIsInstance<Held>()[help]
    }

    fun kampf() {
        reihenfolge()
        var i = 0

        while (sieg() || lose()) {
            if (!sieg() || !lose()) break

            if (!sieg() || !lose()) break
            if (i > reihenfolgeListe.lastIndex) {
                i = 0
                reihenfolge()
            }
            if (reihenfolgeListe[i].kampfUnfaehig()) {
                reihenfolge()
                sieg()
                continue
            }
            reihenfolgeListe[i].kampfUnfaehig()
            sieg()
            if (!sieg() || !lose()) break

            if (reihenfolgeListe[i] is Held) {
                reihenfolge()
                reihenfolgeListe[i].showStats()
            }
            reihenfolgeListe[i].aktion()
            reihenfolge()
            reihenfolgeListe[i].kampfUnfaehig()
            if (!sieg() || !lose()) break
            reihenfolge()
            runde()
            ++i
        }
        reihenfolge()
        gameLvl += 1
        println("Runden gespielt: $runden\n")

        if (!sieg()) {
            println()
            Thread.sleep(1000)
            nextLvl()
            for (x in reihenfolgeListe){
                x.showLebenPunkte()
            }
            Thread.sleep(1000)
            println()
            kampf()
        } else {
            println("Schade! Vielleicht beim nächsten Mal.")
            exitProcess(1)
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