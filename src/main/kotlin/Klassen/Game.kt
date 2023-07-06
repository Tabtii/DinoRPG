package Klassen
var dinoListe = mutableListOf<Charakter>()
var heroListe = mutableListOf<Charakter>()
var reihenfolgeListe = mutableListOf<Charakter>()
var gameLvl = 1
class Game {

    fun charakterePLUS(charakter: Charakter) {
        when {

            charakter is YourHero -> heroListe.add(charakter)
            else -> dinoListe.add(charakter)
        }
    }

    fun gegnerWahl(): Charakter {
        var i = 1
        println("Gegner auswählen:")
        for (gegner in dinoListe) {
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
        return dinoListe[help]
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