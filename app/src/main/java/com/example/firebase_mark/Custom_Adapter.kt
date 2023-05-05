package com.example.firebase_mark

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CustomAdapter(var context: Context, var data:ArrayList<Car>):BaseAdapter() {
    private class ViewHolder(row:View?){


        //step 1 declare your textviews
        var textcarmake:TextView
        var textcarmodel:TextView
        var textcarprice:TextView
        var buttonupdate:Button
        var buttondelete:Button

        init {

            //step 2 find views by ID
            this.textcarmake = row?.findViewById(R.id.txtcarmake) as TextView
            this.textcarmodel = row?.findViewById(R.id.txtcarmodel) as TextView
            this.textcarprice = row?.findViewById(R.id.txtcarprice) as TextView
            this.buttonupdate = row?.findViewById(R.id.btnupdate) as Button
            this.buttondelete = row?.findViewById(R.id.btndelete) as Button

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.cars_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Car = getItem(position) as Car
        viewHolder.textcarmake.text = item.carmake  //coming from your model
        viewHolder.textcarmodel.text = item.carmodel
        viewHolder.textcarprice.text = item.carprice

        viewHolder.buttonupdate.setOnClickListener {

            //grab data and pass as PutEXTRA
            // var intent = Intent(context, UpdateCar_Record::class.java)

            //intent.putExtra("car_make", item.car_make)
            // intent.putExtra("car_model", item.car_model)
            // intent.putExtra("car_price", item.car_price)
            //intent.putExtra("car_id", item.car_id)

            //context.startActivity(intent)


            // var ref = FirebaseDatabase.getInstance().getReference().child("cars/"+item.car_id)

        }

        viewHolder.buttondelete.setOnClickListener {

            // var ref = FirebaseDatabase.getInstance().getReference().child("cars/"+item.car_id)

            //toast a message to delete item
            // ref.removeValue().addOnCompleteListener {
            //if (it.isSuccessful) {

            //  Toast.makeText(context, "Item has been Deleted", Toast.LENGTH_SHORT).show()
            //  } else {
            //  Toast.makeText(context, "Failed to delete item", Toast.LENGTH_SHORT).show()
            //  }

            //}

        }


        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}