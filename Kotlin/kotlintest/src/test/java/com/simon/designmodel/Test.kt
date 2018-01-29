package com.simon.designmodel

import com.simon.designmodel.prototype.Sheep
import org.junit.Test
import java.util.*

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/1/25 10:50
 */
class Test {



    @Test
    fun prototype(){

        var sheep = Sheep("duoli", Date(20181209))
        println(sheep)

        var sheep1 = sheep.copy()
        sheep.birthday = Date(20181210)


        println(sheep1.toString())

    }

    fun deepPrototype(){
        var sheep = Sheep("duoli", Date(20181209))
    }


}












