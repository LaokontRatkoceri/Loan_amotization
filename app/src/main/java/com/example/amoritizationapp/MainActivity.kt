package com.example.amoritizationapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var ShumaEditText: EditText
    lateinit var KohaEditText: EditText
    lateinit var InteresiEditText: EditText
    lateinit var llogaritButton: Button
    lateinit var DataLinearLayout: LinearLayout
    lateinit var RataTextView: TextView
    lateinit var TotaliTextView: TextView
    lateinit var DataPeriod: TextView
    lateinit var DataPayment: TextView
    lateinit var DataInterest: TextView
    lateinit var DataPrinciple: TextView
    lateinit var TableLayout: LinearLayout
    lateinit var calculation: LoanCalculation
    lateinit var amoritzationList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShumaEditText = findViewById(R.id.shumaEditText)
        ShumaEditText.doOnTextChanged { text, start, before, count ->
            calculation.sum = getShuma()
        }

        KohaEditText = findViewById(R.id.kohaEditText)
        KohaEditText.doOnTextChanged { text, start, before, count ->
            calculation.span = getKoha()
            publish()
        }
        InteresiEditText = findViewById(R.id.interesiEditText)
        InteresiEditText.doOnTextChanged { text, start, before, count ->
            calculation.monthlyInterest = getInterest()
        }
        llogaritButton = findViewById(R.id.logariteButton)
//       DataLinearLayout = findViewById(R.id.DataLinearLayout)
        RataTextView = findViewById(R.id.RataTextView)
        TotaliTextView = findViewById(R.id.TotaliTextView)
//        DataPeriod = findViewById(R.id.DataPeriodTextView)
//        DataPayment = findViewById(R.id.DataPaymentTextView)
//        DataInterest = findViewById(R.id.DataInterestTextView)
//        DataPrinciple = findViewById(R.id.DataPrincipleTextView)
        TableLayout = findViewById(R.id.LinearLayout)
        calculation = LoanCalculation()
        amoritzationList = findViewById(R.id.But)
        amoritzationList.layoutManager = LinearLayoutManager(this)


        llogaritButton.setOnClickListener {



            publish()
            //calculation.getAmortizationDataList()
        }
    }

    private fun getInterest(): Double = (InteresiEditText.text.toString().toDouble()/12)/100

    private fun getKoha(): Double= KohaEditText.text.toString().toDouble()

    private fun getShuma(): Double= ShumaEditText.text.toString().toDouble()

    private fun publish(){
        RataTextView.text = "Rata: ${calculation.calculateMonthlyPayment()}"
        TotaliTextView.text = "Interesi: ${calculation.getTotal()}"
        val amortizationData = calculation.getAmortizationDataList()

        amoritzationList.adapter = AmortizationListAdapter(amortizationData)


    }
}