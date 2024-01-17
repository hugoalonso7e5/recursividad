import java.lang.Integer.parseInt
import java.lang.Integer.sum

fun main(){

    val num : Int = readln().toInt()

    //println("El factorial de $num es: ${factorial(num)}")

    //println("El doble factorial de $num es: ${dobleFactorial(num)}")

    //println("La sequencia fibonacci de $num es:")
    //fibonacci(num)

    //println("La sequencia fibonacci Recursiva de $num es:")
    //fibonacciRecursivo(iteracions = num)

    //println("La sequencia fibonacci Recursiva (bonita) de $num es:")
    //fibonacciRecursivo2(iteracions = num)

    //println("El numero $num te ${numerosComposats(num)} caracters")

    //println(numInvers(num))
    //println(nombresCreixents(num))
    //println(reduccioNum(num))
    //println(reduccioNum2(num))
    println(nombresPrimers(num))
}

fun numerosComposats(num: Int,quant:Int=0): Int {
    return if (num/10<1) quant+1
    else numerosComposats(num/10,quant+1)
}

fun numInvers(num: Int,result: String = "") : String{
    var aux = num%10
    var enviable = result
    enviable+=aux.toString()

    return if (num<=10)  enviable
    else numInvers(num/10, enviable)
}

fun factorial(num:Int) : Long{
    println()
    return if (num==1) 1
    else num * factorial(num-1)
}

fun dobleFactorial(num:Int) : Int{
    return if (num==1) 1
    else num * num * dobleFactorial(num-1)
}

fun fibonacci(iteracions:Int):Int {
    var aux1 = 0
    var aux2 = 1
    for (i in 1..iteracions){
        val temp = aux1 + aux2
        println("$aux1 + $aux2 = $temp")
        aux1=aux2
        aux2=temp

    }
    return aux2
}

fun fibonacciRecursivo (num1:Int=0,num2:Int=1,iteracions:Int):String{
    var aux1=num1
    var aux2=num2
    var temporal = 0
    var auxIteracions = iteracions

    temporal = aux1+aux2

    println("$aux1 + $aux2 = $temporal")

    aux1 = aux2

    aux2 = temporal

    auxIteracions--
    return if(auxIteracions==0) ""
    else fibonacciRecursivo(aux1,aux2,auxIteracions)
}

fun fibonacciRecursivo2 (num1:Int=1,num2:Int=1,iteracions:Int){
    println("$num1 + $num2 = ${num1+num2}")
    if(iteracions==0) print("")
    else fibonacciRecursivo2(num2,num2+num1,iteracions-1)
}

fun nombresCreixents(num:Int):Boolean{
    val aux = num%10
    val aux2 = (num/10)%10

    if (aux<aux2){
        return false
    }else if(aux>aux2){
        val flag:Boolean = nombresCreixents(num/10)
        if (!flag) return false
        else return true
    }
    return true
}

fun reduccioNum(num:Int):Int{
    var suma = 0
    var aux = num.toString()
    for (i in 0..aux.length-1){
        suma += parseInt(aux[i].toString())
    }
    if (suma.toString().length>1) suma = reduccioNum(suma)

    return suma
}

fun reduccioNum2(num:Int):Int{
    var suma = 0
    var aux = num

    do{
        suma+=(aux%10)
        aux/=10
    }while(aux/10!=0)

    suma+=aux
    if (suma/10!=0) suma = reduccioNum(suma)

    return suma
}

fun nombresPrimers(num:Int):Boolean{

    var aux = num

    fun suma(num:Int):Int{
        var suma = 0
        var aux = num

        do{
            suma+=(aux%10)
            aux/=10
        }while(aux/10!=0)

        suma+=aux

        return suma
    }

    fun comprovarPrimers(num:Int):Boolean{
        var flag:Boolean
        var aux = num
        if (aux%2!=0&&aux%3!=0&&aux%5!=0&&aux%7!=0&&aux%11!=0){
            return true
        }
        return false
    }

    var suma:Int

    if (aux/10!=0){
        aux = suma(aux)
    }
    var bool = comprovarPrimers(aux)
    if (bool){
        nombresPrimers(aux)
    }
    return false

}







