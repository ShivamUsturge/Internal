package com.charusat.demoapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.cahrusat.sqlitedemodiv1.MainActivity
//import com.cahrusat.sqlitedemodiv1.R
import kotlinx.android.synthetic.main.card_item.view.*



class FruitAdapter(val context:Context, var arr:ArrayList<Fruit>)
    :RecyclerView.Adapter<FruitAdapter.PersonViewHolde>()

{

    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Fruit)
        {

            view.tvFrName.setText(p.fr_name)
            view.tvFrDesc.setText(p.fr_desc)
            view.tvFrPrice.setText(p.fr_price.toString())

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
       var inflater=LayoutInflater.from(parent.context)
       var view= inflater.inflate(R.layout.card_item,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])
        holder.view.btnUpdate.setOnClickListener {
            if(context is ViewAllActivity)
            {
                context.update(position)
            }
        }
        holder.view.btnDelete.setOnClickListener {
            if(context is ViewAllActivity)
            {
                context.delete(position)
            }
        }

        }

    override fun getItemCount(): Int {
        return  arr.size
    }
}




