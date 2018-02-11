package com.simon.designmodel

import com.simon.designmodel.FlyWeight.ChessFactory
import com.simon.designmodel.FlyWeight.Coordinate
import com.simon.designmodel.bridge.Laptop
import com.simon.designmodel.bridge.Lenovo
import com.simon.designmodel.chain.Director
import com.simon.designmodel.chain.LeaveRequest
import com.simon.designmodel.chain.Manager
import com.simon.designmodel.command.ConcreteCommand
import com.simon.designmodel.command.Invoker
import com.simon.designmodel.command.Receiver
import com.simon.designmodel.mediator.Development
import com.simon.designmodel.mediator.Finacial
import com.simon.designmodel.prototype.Sheep
import com.simon.designmodel.proxy.staticProxy.ProxyStar
import com.simon.designmodel.proxy.staticProxy.RelStar
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
    fun prototype() {

        var sheep = Sheep("duoli", Date(20181209))
        println(sheep)

        var sheep1 = sheep.copy()
        sheep.birthday = Date(20181210)


        println(sheep1.toString())

    }

    fun deepPrototype() {
        var sheep = Sheep("duoli", Date(20181209))
    }


    @Test
    fun proxyTest() {

        var relStar = RelStar()
        var proxy = ProxyStar(relStar)

        proxy.confer()
        proxy.signContract()
        proxy.bookTicket()
        proxy.sing()
        proxy.collectMoney()
    }


    @Test
    fun bridge() {

        //联想牌的笔记本电脑
        var computer1 = Laptop(Lenovo())
        computer1.sale()
    }


    @Test
    fun flyWeightTest() {

        var chess1 = ChessFactory.getChess("black")
        var chess2 = ChessFactory.getChess("black")

        println(chess1)
        println(chess2)

        //增加外部处理
        chess1?.display(Coordinate(10, 10))
        chess2?.display(Coordinate(20, 20))


    }


    @Test
    fun chain() {
        var leaveRequest = LeaveRequest("simon", 2, "year")
        var leaveRequest1 = LeaveRequest("tom", 8, "year")

        var director = Director("a")
        var manager = Manager("b")
        director.nextLeader = (manager)

//        director.handleRequest(leaveRequest)
        director.handleRequest(leaveRequest1)
    }


    @Test
    fun mediator() {

        var manager = com.simon.designmodel.mediator.Manager()
        var development = Development(manager)
        var finacial = Finacial(manager)

        development.selfAction()
        development.outAction()

    }


    @Test
    fun command() {

        var concreteCommand = ConcreteCommand(Receiver())
        var invoker = Invoker(concreteCommand)

        invoker.call()

    }

}












