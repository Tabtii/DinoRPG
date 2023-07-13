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
    }//erzeugt entsprechend des gameLvl die Gegner

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
    }// Hier wird der "Spielcharakter" erstellt und die Helfer erzeugt und der erste gegner

    fun nextLvl() {
        Thread.sleep(1000)
        println("Achtung es kommen noch mehr!")
        Thread.sleep(1000)
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
    } //Startet das nächste Level / Kampf und fügt entsprechend zufällige Items dem Inventar hinzu

    fun charakterePLUS(charakter: Charakter) {
        when (charakter) {
            is Held -> heroListe.add(charakter)
            else -> dinoListe.add(charakter)
        }
    } // fügt alle Charaktere einer temporären Liste hinzu,
    // um später besser die Reihenfolge zu bestimmen

    fun sieg(): Boolean {
        when {
            reihenfolgeListe.filterIsInstance<Dino>().isEmpty() -> {
                return false
            }


        }
        return true
    }//Überprüft ob alle Dinos kampfunfähig sind

    fun lose(): Boolean {
        when {
            reihenfolgeListe.filterIsInstance<Held>().isEmpty() -> {
                return false
            }
        }
        return true
    } //Überprüft ob alle Helden kampfunfähig sind

    fun runde(): Int {
        runden += 1
        return runden
    } // Zählt nur die anzahl gespielter Runden

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
    }// Zeigt eine Auflistung verfügbarer Gegner an und gibt den ausgewählten zurück

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
    } // Zeigt eine Auflistung verfügbarer Helden an und gibt den ausgewählten zurück

    fun kampf() {
        reihenfolge()
        var i = 0
        for (x in reihenfolgeListe){
            x.showLebenPunkte()
        }
        Thread.sleep(1500)
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
        Thread.sleep(1000)
        println("Runden gespielt: $runden\n")
        Thread.sleep(1000)

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
            Thread.sleep(1000)
            println("Schade! Vielleicht beim nächsten Mal.")
            exitProcess(1)
        }
    } // abwechselnde Kampf aktionen bis entweder Helden oder Dinos kampfunfähig sind

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
    }// Sotiert die Helden und Gegner abwechselnd in eine Liste ein
}