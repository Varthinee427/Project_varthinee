package com.example.test

class Pig (var name : String, var price: Float) {

    companion object {

        val arrayname = arrayOf("หมูสามชั้น", "หมูสามชั้นนอก", "หมูสามชั้นคอ", "หมูสามสันนอก","หมูสามชั้น", "หมูสามชั้นนอก", "หมูสามชั้นคอ", "หมูสามสันนอก","หมูสามชั้น", "หมูสามชั้นนอก", "หมูสามชั้นคอ", "หมูสามสันนอก","หมูสามชั้น", "หมูสามชั้นนอก", "หมูสามชั้นคอ", "หมูสามสันนอก")

        fun getData(size: Int): ArrayList<Pig> {
            val student: ArrayList<Pig> = ArrayList()
            for (i in 0 until size) {
                student.add(Pig(arrayname[i], Math.random().toFloat() * 100))
            }
            return student
        }
    }

}