package Klassen

class Velociraptor() : Charakter() {

    override var name = "Raptor"
    override var lp = (70..120).random()
    override var atk = (50..90).random()
    override var ver = (30..50).random()
    override var maxLP = lp

}
