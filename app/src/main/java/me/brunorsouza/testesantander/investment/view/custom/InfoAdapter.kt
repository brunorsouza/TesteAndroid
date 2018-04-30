package me.brunorsouza.testesantander.investment.view.custom

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.investment.model.Info

class InfoAdapter(val infoList: MutableList<Info>):
        RecyclerView.Adapter<InfoAdapter.SimpleInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.info_item, parent, false)

        return SimpleInfoViewHolder(view)
    }

    override fun getItemCount() = infoList.size

    override fun onBindViewHolder(holder: SimpleInfoViewHolder, position: Int) {
        holder.setInfos(infoList[position])
    }

    inner class SimpleInfoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val message1 = view.findViewById(R.id.txtMsg) as TextView
        val message2 = view.findViewById(R.id.txtMsg2) as TextView

        fun setInfos(info: Info){
            message1.text = info.message1
            message2.text = info.message2
        }

    }

}