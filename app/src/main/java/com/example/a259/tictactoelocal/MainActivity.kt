package com.example.a259.tictactoelocal

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val firstRow = arrayListOf(1, 2, 3)
    val secondRow = arrayListOf(4, 5, 6)
    val thirdRow = arrayListOf(7, 8, 9)
    val firstCol = arrayListOf(1, 4, 7)
    val secondCol = arrayListOf(2, 5, 8)
    val thirdCol = arrayListOf(3, 6, 9)
    val xRL = arrayListOf(1, 5, 9)
    val xLR = arrayListOf(3, 5, 7)
    var endGame = false
    var winner = ""
    var Player1 = arrayListOf<Int>()
    var remaining = arrayListOf (1, 2, 3, 4, 5, 6, 7, 8, 9)
    var Player2 = arrayListOf<Int>()
    var activePlayer = 1

    protected fun buCLick (view: View){
        var buId = 0
        val buSelectedId = view as Button
        when(buSelectedId.id){
            R.id.but1 -> buId=1
            R.id.but2 -> buId=2
            R.id.but3 -> buId=3
            R.id.but4 -> buId=4
            R.id.but5 -> buId=5
            R.id.but6 -> buId=6
            R.id.but7 -> buId=7
            R.id.but8 -> buId=8
            R.id.but9 -> buId=9
        }
        PlayGame(buId, buSelectedId)
    }

    fun PlayGame(buId:Int, buSelectedId:Button){
        winner()
        if (endGame){
            toast("This game has ended!! \nWinner is $winner")
            newGame.visibility = View.VISIBLE
        }else{
            if (activePlayer == 1) {
                buSelectedId.text = "X"
                buSelectedId.setBackgroundColor(Color.GREEN)
                buSelectedId.isEnabled = false
                Player1.add(buId)
                remaining.remove(buId)
                activePlayer = 2
                autoPlay()
            } else {
                toast("player2 is now selected")
                buSelectedId.text = "O"
                buSelectedId.setBackgroundColor(Color.CYAN)
                buSelectedId.isEnabled = false
                remaining.remove(buId)
                Player2.add(buId)
                activePlayer = 1

            }
        }
    }

    fun autoPlay() {
        val rand = Random()
        val buAutoSelection = rand.nextInt(remaining.size)
        val buId = remaining[buAutoSelection]
        val buSelectedId: Button?
        when (buId) {
            1 -> buSelectedId = but1
            2 -> buSelectedId = but2
            3 -> buSelectedId = but3
            4 -> buSelectedId = but4
            5 -> buSelectedId = but5
            6 -> buSelectedId = but6
            7 -> buSelectedId = but7
            8 -> buSelectedId = but8
            9 -> buSelectedId = but9
            else -> buSelectedId = but1
        }
        PlayGame(buId, buSelectedId)
    }

    fun winner(){
        if ( Player1.containsAll(firstRow) || Player1.containsAll(secondRow) || Player1.containsAll(thirdRow) ||
                Player1.containsAll(firstCol) || Player1.containsAll(secondCol) || Player1.containsAll(thirdCol) ||
                Player1.containsAll(xLR) || Player1.containsAll(xRL) ){
            winner = "Player1"
            endGame = true
        }else if ( Player2.containsAll(firstRow) || Player2.containsAll(secondRow) || Player2.containsAll(thirdRow) ||
                Player2.containsAll(firstCol) || Player2.containsAll(secondCol) || Player2.containsAll(thirdCol) ||
                Player2.containsAll(xLR) || Player2.containsAll(xRL) ){
            winner = "Computer"
            endGame = true
        }
    }
}