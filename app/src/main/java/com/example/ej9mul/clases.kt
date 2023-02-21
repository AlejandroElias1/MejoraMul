package clase

import kotlin.random.Random

class Dado() {

    private var numMin=1
    private var numMax=6

    fun tirada (): Int {
        return Random.nextInt(numMin, numMax)
    }
}


class Articulo (private var id:String, private var peso:Int, private var valor:Int){


    fun getPeso():Int{
        return peso
    }
    fun getValor():Int{
        return valor
    }
    fun getId():String{
        return id
    }
    override fun toString(): String {
        return "[ID:$id, Peso:$peso, Valor:$valor]"
    }
}


class Mochila(private var pesoMochila: Int){
    private var contenido=ArrayList<Articulo>()

    fun getPesoMochila():Int{
        return pesoMochila
    }
    fun addArticulo(articulo:Articulo){
        if (articulo.getPeso()<=pesoMochila){
            contenido.add(articulo)
            this.pesoMochila-=articulo.getPeso()
        }else{
            println("La mochila está llena, debes vender artículos")
        }
        println("Peso restante de la Mochila: "+pesoMochila)

    }
    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }
    fun findObjeto(id: String):Int{
        for((indice,item) in contenido.withIndex()){
            if (item.getId() == id) {
                return indice
            }
        }
        return -1
    }
}


class Personaje(
    private var nombre: String,
    private var raza: String,
    private var clase: String,
    private var fuerza:Int,
    private var defensa:Int,
    private var mochila: Mochila,
    private var monedero: Int,
    ) {

    fun getNombre(): String {
        return nombre
    }

    fun setNombre(aux: String) {
        nombre = aux
    }

    fun getRaza(): String {
        return raza
    }

    fun setRaza(aux: String) {
        raza = aux
    }

    fun getClase(): String {
        return clase
    }

    fun setClase(aux: String) {
        clase = aux
    }

    fun getFuerza(): Int {
        return fuerza
    }

    fun setFuerza(aux: Int) {
        fuerza = aux
    }

    fun getDefensa(): Int {
        return defensa
    }

    fun setDefensa(aux: Int) {
        defensa = aux
    }

    fun getMochila(): Mochila {
        return mochila
    }

    fun getMonedero(): Int {
        return monedero
    }

    fun setMonedero(aux: Int) {
        monedero = aux
    }


}
var mochila1 = Mochila(200)
var personaje1 = Personaje("","","",0,0,mochila1,0)