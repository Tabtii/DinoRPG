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
                    char.atk = (70..90).random()
                    char.ver = (20..75).random()
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
                    char.atk = (85..120).random()
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
                    char.lp = (190..255).random()
                    char.atk = (120..150).random()
                    char.ver = (80..100).random()
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
                    char.atk = (70..90).random()
                    char.ver = (20..75).random()
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
                    char.atk = (85..120).random()
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
                    char.lp = (190..255).random()
                    char.atk = (120..150).random()
                    char.ver = (80..100).random()
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
                    char.atk = (70..90).random()
                    char.ver = (20..75).random()
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
                    char.atk = (85..120).random()
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
                    char.lp = (190..255).random()
                    char.atk = (120..150).random()
                    char.ver = (80..100).random()
                    char.geschF = (1..55).random()
                    char.geschN = (60..85).random()
                    char.maxLP = char.lp
                    char.maxAtk = char.atk
                    char.maxVer = char.ver
                    char.maxGeschF = char.geschF
                    char.maxGeschN = char.geschN
                }

            }

            4 -> {
                char.name = "Giga"
                char.lp = (300..450).random()
                char.atk = (100..150).random()
                char.ver = (80..95).random()
                char.geschF = (1..50).random()
                char.geschN = (70..100).random()
                char.maxLP = char.lp
                char.maxAtk = char.atk
                char.maxVer = char.ver
                char.maxGeschF = char.geschF
                char.maxGeschN = char.geschN
            }
        }
        return char
    }


    override fun aktion() {

        if (!kampfUnfaehig()) {
            var i = (0..100).random()
            var random = (1..99).random()
            var schaden = 0
            when (i) {
                in (0..80) -> {
                    schaden = attack()
                    var ziel = Held()

                    ziel = reihenfolgeListe.filterIsInstance<Held>().random()
                    ziel.takeDamage(schaden)
                    println()

                    println()
                }

                in (81..100) -> {
                    when (this.name) {
                        "Compy" -> {
                            println(
                                "    println(\"                                                    -- __\\n\" +\n" +
                                        "            \"                                                  ~ (@)  ~~~---_\\n\" +\n" +
                                        "            \"                                                {     `-_~=======)\\n\" +\n" +
                                        "            \"                                                {    (_  ',\\n\" +\n" +
                                        "            \"                                                 ~    . = _',\\n\" +\n" +
                                        "            \"                                                  ~    '.  =-'\\n\" +\n" +
                                        "            \"                                                    ~     :\\n\" +\n" +
                                        "            \".                                                -~     (\\\"\\\");\\n\" +\n" +
                                        "            \" '.                                         --~        \\\\  \\\\ ;\\n\" +\n" +
                                        "            \"   \\\".-_                                   -~            \\\\  \\\\;      _-====\\n\" +\n" +
                                        "            \"      -~- _                          -~                 {  \\\"---- _'-====\\n\" +\n" +
                                        "            \"        ~- _~-  _              _ -~                     ~---------==.=`\\n\" +\n" +
                                        "            \"             ~-  ~~-----~~~~~~       .+++~~~~~~~~-__   /\\n\" +\n" +
                                        "            \"                 ~-   __            {   -     +   }   /\\n\" +\n" +
                                        "            \"                          ~- ______{_    _ -=\\\\ / /_ ~\\n\" +\n" +
                                        "            \"                              :      ~--~    // /         ..-\\n\" +\n" +
                                        "            \"                              :   / /      // /         ((\\n\" +\n" +
                                        "            \"                              :  / /      {   `-------=. ))\\n\" +\n" +
                                        "            \"                              :   /        '\\\"=--------. }o\\n\" +\n" +
                                        "            \"                 .=._________,'  )                     ))\\n\" +\n" +
                                        "            \"                 )  _________ -''                     ~~\\n\" +\n" +
                                        "            \"                / /  _ _                   =\\n\" +\n" +
                                        "            \"               (_.-.'O'-'.\")"
                            )
                            Thread.sleep(1000)
                            Faehigkeiten().dinoHeilen()
                        }

                        "Raptor" -> {
                            println(
                                "                                                     ___._\n" +
                                        "                                                   .'  <0>'-.._\n" +
                                        "                                                  /  /.--.____\")\n" +
                                        "                                                 |   \\   __.-'~\n" +
                                        "                                                 |  :  -'/\n" +
                                        "                                                /:.  :.-'\n" +
                                        "__________                                     | : '. |\n" +
                                        "'--.____  '--------.______       _.----.-----./      :/\n" +
                                        "        '--.__            `'----/       '-.      __ :/\n" +
                                        "              '-.___           :           \\   .'  )/\n" +
                                        "                    '---._           _.-'   ] /  _/\n" +
                                        "                         '-._      _/     _/ / _/\n" +
                                        "                             \\_ .-'____.-'__< |  \\___\n" +
                                        "                               <_______.\\    \\_\\_---.7\n" +
                                        "                              |   /'=r_.-'     _\\\\ =/\n" +
                                        "                          .--'   /            ._/'>\n" +
                                        "                        .'   _.-'\n" +
                                        "   snd                 / .--'\n" +
                                        "                      /,/\n" +
                                        "                      |/`)\n" +
                                        "                      'c=,"
                            )
                            Thread.sleep(1000)
                            Faehigkeiten().dinoAngrPlus()
                        }

                        "Rex" -> {
                            println(
                                "                                              ____\n" +
                                        "  ___                                      .-~. /_\"-._\n" +
                                        "`-._~-.                                  / /_ \"~o\\  :Y\n" +
                                        "      \\  \\                                / : \\~x.  ` ')\n" +
                                        "      ]  Y                              /  |  Y< ~-.__j\n" +
                                        "     /   !                        _.--~T : l  l<  /.-~\n" +
                                        "    /   /                 ____.--~ .   ` l /~\\ \\<|Y\n" +
                                        "   /   /             .-~~\"        /| .    ',-~\\ \\L|\n" +
                                        "  /   /             /     .^   \\ Y~Y \\.^>/l_   \"--'\n" +
                                        " /   Y           .-\"(  .  l__  j_j l_/ /~_.-~    .\n" +
                                        "Y    l          /    \\  )    ~~~.\" / `/\"~ / \\.__/l_\n" +
                                        "|     \\     _.-\"      ~-{__     l  :  l._Z~-.___.--~\n" +
                                        "|      ~---~           /   ~~\"---\\_  ' __[>\n" +
                                        "l  .                _.^   ___     _>-y~\n" +
                                        " \\  \\     .      .-~   .-~   ~>--\"  /\n" +
                                        "  \\  ~---\"            /     ./  _.-'\n" +
                                        "   \"-.,_____.,_  _.--~\\     _.-~\n" +
                                        "               ~~     (   _}       -Row\n" +
                                        "                      `. ~(\n" +
                                        "                        )  \\\n" +
                                        "                  /,`--'~\\--'~\\\n" +
                                        "                  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                            )
                            Thread.sleep(1000)
                            Faehigkeiten().dinoRufen()
                        }

                        else -> when (random) {
                            in (1..33) -> Faehigkeiten().dinoAngrPlus()
                            in (34..66) -> Faehigkeiten().dinoHeilen()
                            in (67..99) -> Faehigkeiten().dinoRufen()
                        }
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


