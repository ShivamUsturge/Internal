package com.charusat.demoapplication

data class Fruit(var fr_name: String, var fr_desc:String, var fr_price:Int) {
    var fr_id:Int = 0
    constructor(fr_id:Int,fr_name:String,fr_desc:String,fr_price:Int):this(fr_name,fr_desc,fr_price){

        this.fr_id = fr_id
    }

}