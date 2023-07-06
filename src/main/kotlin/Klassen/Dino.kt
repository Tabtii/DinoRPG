package Klassen

class Dino(): Charakter() {
    override var maxLP = 0
    constructor(name:String,lp: Int,atk:Int,ver: Int, geschF :Int, geschN : Int): this()
    var compy = Dino("Compy",100,20,20,1,20)
    var raptor = Dino("Raptor",100,20,20,1,20)
    var rex = Dino("Rex",100,20,20,1,20)

    fun randomDino():Charakter{
        var i = (0..100).random()
        var char = Charakter()
        when(gameLvl){
            1 -> when (i) {
                in 0..70 -> {
                    char = compy
                }
                in 71..90 -> {
                    char = raptor
                }
                in 91..100 -> {
                    char = rex
                }

            }
            2 -> when (i) {
                in 0..50 -> {
                    char = compy
                }
                in 51..75 -> {
                    char = raptor
                }
                in 76..100 -> {
                    char = rex
                }

            }
            3 -> when (i) {
                in 0..10 -> {
                    char = compy
                }
                in 11..50 -> {
                    char = raptor
                }
                in 50..100 -> {
                    char = rex
                }

            }
        }
        return char
    }
}