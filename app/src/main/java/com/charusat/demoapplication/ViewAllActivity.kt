package com.charusat.demoapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view_all.*
import kotlinx.android.synthetic.main.custom_dialog_layout.*
import java.text.FieldPosition

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        updateRecyclerView()
    }

    public fun update(position: Int)
    {
        var db = DBHelper(this)
        var arr = db.retriveAll()
        var fruit = arr.get(position)
        var id = fruit.fr_id
        var name = fruit.fr_name
        var desc = fruit.fr_desc
        var price = fruit.fr_price
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog_layout)
        dialog.tvID.setText(id.toString())
        dialog.edtDialogName.setText(name)
        dialog.edtDialogDesc.setText(desc)
        dialog.edtDialogPrice.setText(price.toString())
        dialog.btnDialogUpdate.setOnClickListener {
            var id = dialog.tvID.text.toString().toInt()
            var name = dialog.edtDialogName.text.toString()
            var desc = dialog.edtDialogDesc.text.toString()
            var price = dialog.edtDialogPrice.text.toString().toInt()
            var fruit=Fruit(id,name,desc,price)
            var flag = db.update(fruit)
            if (flag){
                Toast.makeText(this,"Record Updated!!",Toast.LENGTH_LONG).show()
                dialog.dismiss()
                updateRecyclerView()
            }
        }
             dialog.show()
    }
    public  fun delete(position: Int)
    {
        var db=DBHelper(this)
        var arr = db.retriveAll()
        var fruit = arr.get(position)
        var fr_id = fruit.fr_id
        var flag = db.delete(fr_id)
        if(flag)

            Toast.makeText(this,"Record Deleted!!",Toast.LENGTH_LONG).show()
            updateRecyclerView()

    }
    private fun updateRecyclerView() {
        var db = DBHelper(this)
        var arr = db.retriveAll()
        var fruitadapter = FruitAdapter(this,arr)
        myrecycle.adapter = fruitadapter
    }


}