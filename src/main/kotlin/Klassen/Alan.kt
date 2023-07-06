package Klassen

class Alan():Charakter() {
    override var name = "Dr. Alan Grant"
    override var lp = (90..130).random()
    override var atk = (55..90).random()
    override var ver = (30..70).random()

    override fun spezialAngriff():Int{
        println("${this.name} greift an!")
        return  atk - 10
    }

    override fun faehigkeit(): Int {
        println("${this.name} heilt sich!")
        return (lp*0.2).toInt()
    }
}