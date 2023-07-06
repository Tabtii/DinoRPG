package Klassen

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
            println("${this.name} wurde besiegt.\n")
        }
        if (damagePoints <= 0) {
            println("Es wurde kein schaden verursacht.\n")
        } else {
            println("${this.name} wurde $damagePoints schaden zugefügt.\n")
            this.lp -= damagePoints
        }
    }

    open fun spezialAngriff(): Int {
        println("${this.name} greift an!\n")
        return 25 + ((atk + geschF) / 2).toInt()
    }

    fun multiAngriff(){
        for (x in reihenfolgeListe){
            when (x){
                is Dino -> {
                    var schaden = 5 + ((atk + geschF + geschN) /3).toInt()
                    var ziel = x
                    println("${this.name} greift an!")
                    ziel.takeDamage(schaden)

                }
            }

        }
        Thread.sleep(1000)
    }

    fun resetWerte() {
        this.lp = maxLP
        this.atk = maxAtk
        this.ver = maxVer
        this.geschF = maxGeschF
        this.geschN = maxGeschN
    }




    open fun showLebenPunkte() {
        println("${this.name} hat noch (${this.lp}/${this.maxLP}) LP.")
    }

    open fun aktion() {

        println("Was wird ${this.name} machen.")
        println("--1--Gegner angreifen")
        println("--2--Spezial angriff")
        println("--3--Fähigkeit einsetzen")
        println("--4--Rucksack")
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
                    else -> multiAngriff()
                }
            }

            eingabe == "4" -> {
                println("Gibbebt noch net")
            }

            else -> {
                println("Falsche Eingabe!")
                aktion()
            }
        }
        Thread.sleep(1000)
    }
}

