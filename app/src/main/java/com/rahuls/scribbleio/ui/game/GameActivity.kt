package com.rahuls.scribbleio.ui.game

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GameActivity : AppCompatActivity() {

    @set:Inject lateinit var gameAssistedFactory: GameViewModel.GameAssistedFactory

    private val viewModel by viewModels<GameViewModel>{
        GameViewModel.provideGameAssistedFactory(gameAssistedFactory,intent.getStringExtra(
            EXTRA_CHANNEL_ID)!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreen(viewModel = viewModel)
        }
    }

    companion object{
        private const val EXTRA_CHANNEL_ID = "extra_cid"
        fun start(context: Context,channelId: String){
            Intent(context,GameActivity::class.java).also {
                it.putExtra(EXTRA_CHANNEL_ID, channelId)
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(it)
            }
        }
    }
}