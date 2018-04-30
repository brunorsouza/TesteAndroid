package me.brunorsouza.testesantander.investment.view.custom

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import me.brunorsouza.testesantander.R
import me.brunorsouza.testesantander.contact.INVALID_STRING
import me.brunorsouza.testesantander.investment.model.Info

class InfoDownAdapter(val infoList: MutableList<Info>):
        RecyclerView.Adapter<InfoDownAdapter.InfoDownHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoDownHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.info_down_item, parent, false)

        return InfoDownHolder(view)
    }

    override fun getItemCount() = infoList.size

    override fun onBindViewHolder(holder: InfoDownHolder, position: Int) {
        holder.setInfos(infoList[position])
    }

    inner class InfoDownHolder(view: View): RecyclerView.ViewHolder(view) {

        val message1 = view.findViewById(R.id.txtMsg) as TextView
        val message2 = view.findViewById(R.id.txtMsg2) as TextView

        fun setInfos(info: Info){
            message1.text = info.message1

            message2.setOnClickListener {
                if(info.message2 == INVALID_STRING){
                    Toast.makeText(itemView.context, "Indisponivel", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(itemView.context, "Downloading...", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}