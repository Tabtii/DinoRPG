package Klassen

class Faehigkeiten {
    fun heilen() {
        println("Medic nutzt seine Fähigkeit.\n")
        for (held in reihenfolgeListe) {
            when (held) {
                is Held -> {
                    if (held.lp <= 0) {
                        println("${held.name} kann nicht geheilt werden!\n")
                        Thread.sleep(500)
                        continue
                    } else if (held.lp == held.maxLP) {
                        println("${held.name} muss nicht geheilt werden.\n")
                        Thread.sleep(500)
                        continue
                    } else {
                        held.lp += 25
                        println("${held.name} wurde geheilt.\n")
                        Thread.sleep(500)
                        if (held.lp > held.maxLP) {
                            held.lp = held.maxLP

                        }
                        continue
                    }
                }
            }
        }
        println()
    }

    fun angrPlus() {
        println("Hunter nutzt seine Fähigkeit.\n")
        for (held in reihenfolgeListe) {
            when (held) {
                is Held -> {
                    held.atk += 10
                    println("${held.name}s Angriff wurde erhöht. Atk:${held.atk}/${held.maxAtk}.")
                    Thread.sleep(500)
                }
            }
        }
        println()
    }

    fun vertPlus() {
        println("Mercenary nutzt seine Fähigkeit.\n")
        for (held in reihenfolgeListe) {
            when (held) {
                is Held -> {
                    held.ver += 10
                    println("${held.name}s Verteidigung wurde erhöht. Ver:${held.ver}/${held.maxVer}.")
                    Thread.sleep(500)
                }
            }
        }
        println()
    }

    fun geschickPlus() {
        println("Ranger nutzt seine Fähigkeit.\n")
        for (held in reihenfolgeListe) {
            when (held) {
                is Held -> {
                    held.geschF += 10
                    held.geschN += 10
                    println(
                        "${held.name}s Verteidigung wurde erhöht.\nGeschickN:${held.geschN}/${held.maxGeschN}\n" +
                                "GeschickF:${held.geschF}/${held.maxGeschF}."
                    )
                    Thread.sleep(500)
                }
            }
        }
        println()
    }


    fun dinoAngrPlus() {
        println("Raptor nutzt seine Fähigkeit.\n")
        for (held in reihenfolgeListe) {
            when (held) {
                is Dino -> {
                    held.atk += 15
                    println("${held.name}s Angriff wurde erhöht. Atk:${held.atk}/${held.maxAtk}.")
                    Thread.sleep(500)
                }
            }
        }
        println()
    }

    fun dinoHeilen() {
        println("Compy nutzt seine Fähigkeit.\n")
        for (held in reihenfolgeListe) {
            when (held) {
                is Dino -> {
                    if (held.lp <= 0) {
                        println("${held.name} kann nicht geheilt werden!")
                        Thread.sleep(500)
                        continue
                    } else if (held.lp == held.maxLP) {
                        println("${held.name} muss nicht geheilt werden.")
                        Thread.sleep(500)
                        continue
                    } else {
                        held.lp += 20
                        println("${held.name} wurde geheilt.")
                        Thread.sleep(500)
                        if (held.lp > held.maxLP) {
                            held.lp = held.maxLP

                        }
                        continue
                    }
                }
            }
        }
        println()
    }

    fun dinoRufen() {
        println("Rex nutzt seine Fähigkeit.\n")
        var help = Dino().randomDino()
        dinoListe.add(help)
        println("Rex hat ${help.name} gerufen!\n")
        Thread.sleep(500)
    }
}