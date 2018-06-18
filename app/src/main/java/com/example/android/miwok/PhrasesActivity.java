/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener completionListener = new OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

  private AudioManager audioManager;

  private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new OnAudioFocusChangeListener() {
    @Override
    public void onAudioFocusChange(int i) {
      if(i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || i == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
        mediaPlayer.pause();
        mediaPlayer.seekTo(0);
      }else if(i == AudioManager.AUDIOFOCUS_GAIN){
        mediaPlayer.start();
      }else if(i == AudioManager.AUDIOFOCUS_LOSS){
        releaseMediaPlayer();
      }
    }
  };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

      audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinne oyaasene", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michekses?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "eenes'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "hee'eenem", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "eenem", R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "enni'nem", R.raw.phrase_come_here));

        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.phrases_activity_background);

        ListView listView = findViewById(R.id.lv_phrases_word_view);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

              releaseMediaPlayer();

              Word word = words.get(i);

              Log.v("PhrasesActivity", "Current word: " + word);

              int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

              if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioPosition());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
              }
            }
        });
    }


  @Override
  protected void onStart() {
    super.onStart();
    Log.v("PHRASES ACTIVITY","State Change: onStartCalled");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.v("PHRASES ACTIVITY","State Change: onStopCalled");
    releaseMediaPlayer();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.v("PHRASES ACTIVITY","State Change: onDestroyCalled");
  }


  private void releaseMediaPlayer(){

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
          audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
  }

}
