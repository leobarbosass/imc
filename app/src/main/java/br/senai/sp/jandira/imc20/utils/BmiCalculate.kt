package br.senai.sp.jandira.imc20.utils

import kotlin.math.pow

//chamando/criando os métpdps da classe User
fun getBmi(weight: Double, height: Double):Double{
    return weight/height.pow(2)
}

//responsabilidade única (só faz uma coisa)
fun getStatusBmi(bmi: Double):String{

    return if(bmi<=18.5){
        "Abaixo do peso"
    }else if(bmi >18.5 && bmi<=24.9){
        "Peso ideal"
    }else if(bmi>=25 && bmi<30){
        "Levemente acima do peso"
    }else if(bmi>=30 && bmi<35){
        "Obesidade grau |"
    }else if(bmi>=35 && bmi<40){
        "Obesidade grau ||"
    }else{
        "Obesidade grau |||"
    }
}