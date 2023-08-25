package com.example.musictestagain.utilities


import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.musictestagain.R
import com.example.musictestagain.data.model.Music
import com.example.musictestagain.ui.home.MusicAdapter

@BindingAdapter("app:setItemList")
fun <T> setItemList(view: RecyclerView,  list :List<Music>?) {
    if (list !=null ) {
        (view.adapter as MusicAdapter).setData(list)
    }else{
        (view.adapter as MusicAdapter).setData( emptyList())
    }
}

@BindingAdapter("app:showVisibleWhenError")
fun <T> showVisibleWhenError(view: View, state : UiState<T>?) {
    view.isVisible = state is UiState.Error
}

@BindingAdapter("app:showVisibleWhenLoading")
fun <T> showVisibleWhenLoading(view: View, state: UiState<T>?) {
    view.isVisible = state is UiState.Loading
}

@BindingAdapter("app:makeTextScrollable")
fun makeTextScrollable(textView: TextView ,scrollable : Boolean) {
    if (scrollable){
        textView.isSelected = true
        textView.setSingleLine()
        textView.ellipsize= TextUtils.TruncateAt.MARQUEE
    }
}
@BindingAdapter("app:setImageIsLoading")
fun setImageIsLoading(imageView: ImageView , isByffering :Boolean) {
    if (isByffering){
        imageView.setImageResource(R.drawable.loading)
    }
}
@BindingAdapter("app:setImagePlayOrStop")
fun setImagePlayOrStop(imageView: ImageView , isPlay : Boolean ) {

        if (isPlay){
            imageView.setImageResource(R.drawable.pause)
        }else{
            imageView.setImageResource(R.drawable.play)
        }
}

@BindingAdapter("app:loadImageResource")
fun loadImage(imageView: ImageView ,source :String?) {
     imageView.load(source)
}


@BindingAdapter("app:isRepeatClickBackground")
fun isRepeatClickBackground(imageView: ImageView , isRepeat :Boolean) {

    if (isRepeat) imageView.setBackgroundResource(R.drawable.corner_image)
    else   imageView.background = null

}


@BindingAdapter("app:isShuffleClickedBackground")
fun isShuffleClickedBackground(imageView: ImageView , isShuffled :Boolean) {
    if (isShuffled) imageView.setBackgroundResource(R.drawable.corner_image)
    else   imageView.background = null
}

@BindingAdapter("app:setMaxProgressForSeekBar")
fun setMaxProgressForSeekBar(seekBar: SeekBar, maxProgress : Long) {
   seekBar.max = maxProgress.toInt()
}

@BindingAdapter("app:setCurrentProgressForSeekBar")
fun setCurrentProgressForSeekBar(seekBar: SeekBar , progress : Long) {
    seekBar.progress = progress.toInt()
}
@BindingAdapter("app:setTimeMinutes")
fun setTimeMinutes(textView: TextView , progress : Long) {
    textView.text = convertLongDurationToTime(progress)
}








