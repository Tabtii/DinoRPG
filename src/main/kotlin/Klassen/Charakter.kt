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
        return 25 + ((atk + geschN) / 2).toInt()
    }

    fun takeDamage(schaden: Int) {
        var damagePoints = schaden - ver
        if (this.lp <= 0) {
            this.lp = 0
            println("${this.name} wurde besiegt.")
        }
        if (damagePoints <= 0) {
            println("Es wurde kein schaden verursacht.")
        } else {
            println("${this.name} wurde $damagePoints schaden zugefügt.")
            this.lp -= damagePoints
        }
    }

    open fun spezialAngriff(): Int {
        println("${this.name} greift an!\n")
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

                }
            }

        }
        Thread.sleep(1000)
    }

    fun healAngriff(): Int {
        println("${this.name} greift an!")
        this.lp += 10
        return 25 + ((atk + geschN) / 2.5).toInt()
    }

    fun resetWerte() {
        this.lp = maxLP
        this.atk = maxAtk
        this.ver = maxVer
        this.geschF = maxGeschF
        this.geschN = maxGeschN
    }

    fun kampfUnfaehig(): Boolean {
        return this.lp <= 0
    }

    fun inventar() {

    }

    open fun showLebenPunkte() {
        println("${this.name} hat noch (${this.lp}/${this.maxLP}) LP.\n")
    }

    fun showStats(){
        println("Name:${this.name}")
        println("Lebenspunkte:${this.lp}/${this.maxLP}")
        println("Angriff:${this.atk}/${this.maxAtk}")
        println("Verteidigung :${this.ver}/${this.maxVer}")
        println("Geschick Nahkampf :${this.geschN}/${this.maxGeschN}")
        println("Geschick Fernkampf:${this.geschF}/${this.maxGeschF}")
        println()
    }

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
                            var i = (0..10).random()
                            when (i) {
                                in (0..3) -> multiAngriff()
                                in (4..10) -> healAngriff()
                            }
                        }
                    }
                }
                eingabe == "4" -> {
                    println("Gibbebt noch net")
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
        }
    }
}

