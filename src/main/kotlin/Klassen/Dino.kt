package Klassen

class Dino() : Charakter() {


    fun randomDino(): Dino {
        var i = (0..100).random()
        var char = Dino()
        when (gameLvl) {
            1 -> when (i) {
                in 0..70 -> {
                    char.name = "Compy"
                    char.lp = (75..150).random()
                    char.atk = (50..90).random()
                    char.ver = (20..750).random()
                    char.geschF = (1..50).random()
                    char.geschN = (50..80).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 71..90 -> {
                    char.name = "Raptor"
                    char.lp = (120..200).random()
                    char.atk = (75..150).random()
                    char.ver = (55..95).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 91..100 -> {
                    char.name = "Rex"
                    char.lp = (190..285).random()
                    char.atk = (120..200).random()
                    char.ver = (100..120).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

            }

            2 -> when (i) {
                in 0..60 -> {
                    char.name = "Compy"
                    char.lp = (75..150).random()
                    char.atk = (50..90).random()
                    char.ver = (20..750).random()
                    char.geschF = (1..50).random()
                    char.geschN = (50..80).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 61..85 -> {
                    char.name = "Raptor"
                    char.lp = (120..200).random()
                    char.atk = (75..150).random()
                    char.ver = (55..95).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 86..100 -> {
                    char.name = "Rex"
                    char.lp = (190..285).random()
                    char.atk = (120..200).random()
                    char.ver = (100..120).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

            }

            3 -> when (i) {
                in 0..40 -> {
                    char.name = "Compy"
                    char.lp = (75..150).random()
                    char.atk = (50..90).random()
                    char.ver = (20..750).random()
                    char.geschF = (1..50).random()
                    char.geschN = (50..80).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 41..75 -> {
                    char.name = "Raptor"
                    char.lp = (120..200).random()
                    char.atk = (75..150).random()
                    char.ver = (55..95).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

                in 76..100 -> {
                    char.name = "Rex"
                    char.lp = (190..285).random()
                    char.atk = (120..200).random()
                    char.ver = (100..120).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
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

        if (!kampfUnfaehig()) {
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
        } else {
            reihenfolgeListe.remove(this)
        }
    }
}

