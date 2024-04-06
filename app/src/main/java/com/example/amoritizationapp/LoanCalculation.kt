package com.example.amoritizationapp

import kotlin.math.pow

class LoanCalculation {
    var sum:Double= 0.0
    var monthlyInterest : Double = 0.0
    var span:Double = 0.0

    fun calculateMonthlyPayment():Double{
        var rate = sum * ((monthlyInterest * Math.pow(
            (1 + monthlyInterest),
            span
        )) / (Math.pow((1 + monthlyInterest), span) - 1))
        return rate
    }

    fun getTotal() = calculateMonthlyPayment() * span

    fun amortizationLoan():Double{
        var monthlyPaymentpayment :Double = 0.0
          for (n in 0..span.toInt()){

              var up = monthlyInterest*(1+monthlyInterest).pow(n.toDouble())
              var down = (1+monthlyInterest).pow(n.toDouble())-1
              monthlyPaymentpayment =sum* (up/down)
              //println("$monthlyPaymentpayment")
          }
        return monthlyPaymentpayment
    }


    fun getAmortizationDataList():List<AmortizationData>{
        val amortizationDataList = mutableListOf<AmortizationData>()
        var monthlyPayment = calculateMonthlyPayment()
        for(n in 0..span.toInt()){
            val monthlyInterestPayment = (getTotal()-calculateMonthlyPayment()*n.toDouble())*monthlyInterest
            val monthlyDeptPayment = monthlyPayment - monthlyInterestPayment
            val monthlyPayment = monthlyPayment
            val remainingDept = getTotal()-(monthlyPayment *n)
            val ad = AmortizationData(perioda = n+1,
                monthlyPayment = monthlyPayment,
                monthlyInterestPayment = monthlyInterestPayment ,
                monthlyDeptPayment = monthlyDeptPayment,
                remainingDept = remainingDept
                )
            println("print $ad")
            amortizationDataList.add(ad)
        }
        return amortizationDataList.toList()
    }

//    private fun rataMujore(): Double{
//        var up : Double = getInterest() *(1+getInterest()).pow(getKoha())
//
//        var down : Double = (1+ getInterest()).pow(getKoha())-1
//
//        var totali: Double = getShuma() * (up/down)
//        return totali
//    }
    data class AmortizationData(var perioda:Int, var monthlyPayment:Double, var monthlyInterestPayment: Double,var monthlyDeptPayment: Double ,var remainingDept: Double )


}


//fun calculateMonthlyPayment():Double{
//    var rate = sum * ((monthlyInterest * Math.pow( (1 + monthlyInterest), span )) / (Math.pow((1 + monthlyInterest), span) - 1))
//    return rate
//}
//fun getTotal() = calculateMonthlyPayment() * span
//fun amortizationLoan():Double{
//    var a :Double= 0.0
//    for (n in 1..span.toInt()){
//        var up =monthlyInterest*(1+monthlyInterest).pow(n.toDouble())
//        var down = (1+monthlyInterest).pow(n.toDouble()) - 1
//        a = getTotal() *(up/down) println("$n: $a")
//    }
//    return a
//}