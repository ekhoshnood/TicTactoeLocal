package com.example.a259.tictactoelocal

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

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
        Toast.makeText(this, "You have selected button $buId", Toast.LENGTH_SHORT).show()
        PlayGame(buId, buSelectedId)
    }

    var Player1 = arrayListOf<Int>()
    var Player2 = arrayListOf (1, 2, 3, 4, 5, 6, 7, 8, 9)
    var activePlayer = 1
    fun PlayGame(buId:Int, buSelectedId:Button){
        if (activePlayer==1){
            buSelectedId.text = "X"
            buSelectedId.setBackgroundColor(Color.GREEN)
            buSelectedId.isEnabled = false
            Player1.add(buId)
            Player2.remove(buId)
            activePlayer = 2
            toast("Player1 is $Player1 \n Player2 is now $Player2")
        }else{
            toast("player2 is now selected")
            autoPlay()


        }
    }

    fun autoPlay():Int {
        var rand = Random()
        var buAutoSelection = rand.nextInt(Player2.size)
        val buId = Player2[buAutoSelection]
        toast("cellid = $buId")
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
        }
        return buId
    }
}
