package com.example.amoritizationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AmortizationListAdapter(var list: List<LoanCalculation.AmortizationData>):RecyclerView.Adapter<AmortizationListAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        var DataPeriodView = view.findViewById<TextView>(R.id.DataPeriodView)
        var DataPaymentView = view.findViewById<TextView>(R.id.DataPaymentView)
        var DataInterestView = view.findViewById<TextView>(R.id.DataInterestView)
        var DataPrincipleView = view.findViewById<TextView>(R.id.DataPrincipleView)
        var RemainingPaymentView = view.findViewById<TextView>(R.id.RemainingPaymentView)
        //..

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.amortization_list_item,parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.DataPeriodView.text = item.perioda.toString()
        holder.DataPaymentView.text = item.monthlyPayment.toString()
        holder.DataInterestView.text = item.monthlyInterestPayment.toString()
        holder.DataPrincipleView.text = item.monthlyDeptPayment.toString()
        holder.RemainingPaymentView.text = item.remainingDept.toString()
    }

}