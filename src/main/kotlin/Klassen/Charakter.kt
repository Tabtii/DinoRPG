package Klassen

import kotlin.system.exitProcess

open class Charakter() {
    open var name = ""
    open var lp = 1
    open var atk = 1
    open var ver = 1
    open var geschF = 1
    open var geschN = 1
    open var maxLP = lp
    open var maxAtk = atk
    open var maxVer = ver
    open var maxGeschF = geschF
    open var maxGeschN = geschN


    fun attack(): Int {
        println("${this.name} greift an!\n")
        Thread.sleep(1000)
        return 25 + ((atk + geschN) / 2).toInt()
    }

    fun takeDamage(schaden: Int) {
        var damagePoints = schaden - ver
        if (this.lp <= 0) {
            this.lp = 0
            println("${this.name} wurde besiegt.")
            Thread.sleep(1000)
        }
        if (damagePoints <= 0) {
            println("Es wurde kein schaden verursacht.")
            Thread.sleep(1000)
        } else {
            println("${this.name} wurde $damagePoints schaden zugefügt.")
            Thread.sleep(1000)
            this.lp -= damagePoints
        }
    }

    open fun spezialAngriff(): Int {
        println("${this.name} greift an!\n")
        Thread.sleep(1000)
        return 25 + ((atk + geschF) / 2).toInt()
    }

    fun multiAngriff() {
        for (x in reihenfolgeListe) {
            when (x) {
                is Dino -> {
                    var schaden = 5 + ((atk + geschF + geschN) / 3).toInt()
                    var ziel = x
                    println("${this.name} greift an!")
                    ziel.takeDamage(schaden)
                    ziel.showLebenPunkte()
                    Thread.sleep(500)
                }
            }

        }
        Thread.sleep(1000)
    }

    fun healAngriff(): Int {
        println("${this.name} greift an!")
        if (this.lp == this.maxLP) {
            println("${this.name} muss nicht geheilt werden.\n")
            Thread.sleep(500)
        } else {
            this.lp += 15
            println("${this.name} wurde geheilt.\n")
            Thread.sleep(500)
            if (this.lp > this.maxLP) {
                this.lp = this.maxLP
            }
        }

        return 25 + ((atk + geschN) / 2.5).toInt()
    }

    fun resetWerte() {
        this.lp = maxLP
        this.atk = maxAtk
        this.ver = maxVer
        this.geschF = maxGeschF
        this.geschN = maxGeschN
    } // setzt die werte nach jedem gewonnen LVL zurück

    fun kampfUnfaehig(): Boolean {
        if (this.lp <= 0){
            reihenfolgeListe.remove(this)
        }
        return this.lp <= 0
    } // Überprüft ob der Charakter noch teilnehmen kann

    fun inventar() {
        var i = 0

        if (rucksack.isNotEmpty()) {
            for (item in rucksack) {
                println("$i: ${item.name} // ${item.beschreibung}")
                i++
            }

            println("Was willst du benutzen?")
            var eingaben = readln()
            if (eingaben.toInt() in 0..rucksack.lastIndex) {
                when (rucksack[eingaben.toInt()].name) {
                    "Medkit" -> {
                        println("Wer soll geheilt werden?")
                        var ziel = Game().heroWahl()
                        if (ziel.lp == ziel.maxLP) {
                            println("${ziel.name} muss nicht geheilt werden.\n")
                            Thread.sleep(500)
                        } else {
                            ziel.lp += rucksack[eingaben.toInt()].effekt
                            println("${ziel.name} wurde geheilt.\n")
                            Thread.sleep(500)
                            if (ziel.lp > ziel.maxLP) {
                                ziel.lp = ziel.maxLP

                            }
                        }
                        Thread.sleep(500)
                        rucksack.removeAt(eingaben.toInt())
                    }

                    "Stein" -> {
                        println("Wen willst du abwerfen?")
                        var schaden = rucksack[eingaben.toInt()].effekt
                        var ziel = Game().gegnerWahl()
                        ziel.lp -= schaden
                        ziel.showLebenPunkte()
                        Thread.sleep(500)
                        ziel.atk -= 10
                        println("${ziel.name}s Angriff wurde verringert. Atk:${ziel.atk}/${ziel.maxAtk}.")
                        rucksack.removeAt(eingaben.toInt())
                        Thread.sleep(500)

                    }

                    "Stück Fleisch" -> {
                        println("Wen willst du abwerfen?")
                        var schaden = rucksack[eingaben.toInt()].effekt
                        var ziel = Game().gegnerWahl()
                        ziel.lp += schaden
                        ziel.showLebenPunkte()
                        Thread.sleep(500)
                        ziel.ver -= schaden
                        println("${ziel.name}s Verteidigung wurde verringert. Atk:${ziel.ver}/${ziel.maxVer}.\n")
                        rucksack.removeAt(eingaben.toInt())
                        Thread.sleep(500)

                    }

                    "Granate" -> {
                        println("ACHTUNG GRANATE!")
                        for (x in reihenfolgeListe) {
                            when (x) {
                                is Dino -> {
                                    var schaden = rucksack[eingaben.toInt()].effekt
                                    var ziel = x
                                    ziel.takeDamage(schaden)
                                    ziel.showLebenPunkte()
                                    Thread.sleep(500)
                                }
                            }
                        }
                        rucksack.removeAt(eingaben.toInt())
                        Thread.sleep(500)

                    }

                }
            }
        } else {
            println("Kein Item vorhanden.")
        }
    } // auflistung der verfügbaren Items

    open fun showLebenPunkte() {
        if (this.lp <= 0){
            println("${this.name} hat noch (0/${this.maxLP}) LP.\n")
        }else {println("${this.name} hat noch (${this.lp}/${this.maxLP}) LP.\n")}

    } // zeigt nur Name und Lebenspunkte an

    fun showStats() {
        println("Name:${this.name}")
        println("Lebenspunkte:${this.lp}/${this.maxLP}")
        println("Angriff:${this.atk}/${this.maxAtk}")
        println("Verteidigung :${this.ver}/${this.maxVer}")
        println("Geschick Nahkampf :${this.geschN}/${this.maxGeschN}")
        println("Geschick Fernkampf:${this.geschF}/${this.maxGeschF}")
        println()
    }// zeigt alle Werte an

    open fun aktion() {
        if (!kampfUnfaehig()) {
            println("Was wird ${this.name} machen.")
            println("--1--Nahkampf angriff")
            println("--2--Fernkampf angriff")
            println("--3--Fähigkeit/Special einsetzen")
            println("--4--Rucksack")
            println("--5--!!SPIEL BEENDEN!!")
            var eingabe = readln()
            var spielfeld = Game()
            var ziel: Charakter
            var schaden = 0
                when {
                    eingabe == "1" -> {
                        ziel = spielfeld.gegnerWahl()
                        schaden = attack()
                        ziel.takeDamage(schaden)
                        ziel.showLebenPunkte()
                        Thread.sleep(1000)
                    }

                    eingabe == "2" -> {
                        ziel = spielfeld.gegnerWahl()
                        schaden = spezialAngriff()
                        ziel.takeDamage(schaden)
                        ziel.showLebenPunkte()
                        Thread.sleep(1000)
                    }

                    eingabe == "3" -> {
                        when {
                            this.name == "Medic" -> Faehigkeiten().heilen()
                            this.name == "Hunter" -> Faehigkeiten().angrPlus()
                            this.name == "Mercenary" -> Faehigkeiten().vertPlus()
                            this.name == "Ranger" -> Faehigkeiten().geschickPlus()
                            else -> {
                                when (hilfsWertSpezialAng) {
                                    in (0..3) -> multiAngriff()
                                    in (4..10) -> {
                                        ziel = spielfeld.gegnerWahl()
                                        schaden = healAngriff()
                                        ziel.takeDamage(schaden)
                                        ziel.showLebenPunkte()
                                        Thread.sleep(1000)
                                    }
                                }
                            }
                        }
                    }

                    eingabe == "4" -> {
                        inventar()
                    }

                    eingabe == "5" -> {
                        exitProcess(0)
                    }

                    else -> {
                        println("Falsche Eingabe!")
                        aktion()
                    }
                }

            Thread.sleep(1000)
        } else {
            reihenfolgeListe.remove(this)
            when{
                reihenfolgeListe.filterIsInstance<Dino>().isEmpty() -> {
                    gameLvl += 1
                    runden = 0
                    println("Gewonnen!")
                }
                reihenfolgeListe.filterIsInstance<Held>().isEmpty() -> {
                    println("Verloren!")
                    exitProcess(2)
                }
            }
        }
    }
}

