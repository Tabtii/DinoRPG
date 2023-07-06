package Klassen

class Dino() : Charakter() {


    fun randomDino(): Dino {
        var i = (0..100).random()
        var char = Dino()
        when (gameLvl) {
            1 -> when (i) {
                in 0..70 -> {
                    char.name = "Compy"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 71..90 -> {
                    char.name = "Raptor"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 91..100 -> {
                    char.name = "Rex"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

            }

            2 -> when (i) {
                in 0..50 -> {
                    char.name = "Compy"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 51..75 -> {
                    char.name = "Raptor"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 76..100 -> {
                    char.name = "Rex"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

            }

            3 -> when (i) {
                in 0..10 -> {
                    char.name = "Compy"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 11..50 -> {
                    char.name = "Raptor"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 50..100 -> {
                    char.name = "Rex"
                    char.lp = 100
                    char.atk = 80
                    char.ver = 50
                    char.geschF = 100
                    char.geschN = 20
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

            }
        }
        return char
    }


    override fun aktion() {
        var i = (0..100).random()

        var schaden = 0
        when (i) {
            in (0..50) -> {
                schaden = attack()
                var ziel = reihenfolgeListe.filterIsInstance<Held>().random()
                ziel.takeDamage(schaden)
                println()
            }

            in (51..85) -> {
                schaden = spezialAngriff()
                var ziel = reihenfolgeListe.filterIsInstance<Held>().random()
                ziel.takeDamage(schaden)
                println()
            }

            in (86..100) -> {
                when (this.name) {
                    "Compy" -> Faehigkeiten().dinoHeilen()
                    "Raptor" -> Faehigkeiten().dinoAngrPlus()
                    "Rex" -> Faehigkeiten().dinoRufen()
                }
                println()
            }
        }
        Thread.sleep(1000)
    }

}