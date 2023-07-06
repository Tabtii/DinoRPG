package Klassen

import kotlin.random.Random

class YourHero : Charakter() {
    override var name = ""
    override var lp = 0
    override var atk = 0
    override var ver = 0
    override var maxLP = 0


    fun heldErstellen(): Charakter {
        println("Wie willst du genannt werden?")
        this.name = readlnOrNull() ?: ""

        println("Was ist deine Stärke?")
        println("--1-- Angreiffen")
        println("--2-- Verteidigen")
        println("--3-- Unterstützen")
        println("Wähle mit Sorgfalt, es bestimmt deine Werte.")

        var eingabe: Int
        do {
            eingabe = readlnOrNull()?.toIntOrNull() ?: 0

            when (eingabe) {
                1 -> {
                    this.lp = Random.nextInt(70, 101)
                    this.atk = Random.nextInt(100, 121)
                    this.ver = Random.nextInt(20, 51)
                    this.maxLP = lp
                }
                2 -> {
                    this.lp = Random.nextInt(70, 101)
                    this.atk = Random.nextInt(20, 51)
                    this.ver = Random.nextInt(100, 121)
                    this.maxLP = lp
                }
                3 -> {
                    this.lp = Random.nextInt(100, 151)
                    this.atk = Random.nextInt(20, 61)
                    this.ver = Random.nextInt(70, 101)
                    this.maxLP = lp
                }
                else -> {
                    println("Falsche Eingabe. Bitte versuche es erneut.")
                }
            }
        } while (eingabe !in 1..3)

        return this
    }
}

