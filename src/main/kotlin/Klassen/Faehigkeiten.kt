package Klassen

class Faehigkeiten {
    fun heilen() {
        for (held in heroListe) {
            if (held.lp <= 0) {
                println("${held.name} kann nicht geheilt werden!")
                continue
            } else if (held.lp == held.maxLP) {
                println("${held.name} muss nicht geheilt werden")
                continue
            } else {
                held.lp += 25
                if (held.lp > held.maxLP) {
                    held.lp = held.maxLP
                }
                continue
            }
        }
    }
}