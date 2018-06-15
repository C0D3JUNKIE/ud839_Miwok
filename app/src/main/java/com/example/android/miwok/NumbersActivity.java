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

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

  private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

//        String[] numbersOneToTen = new String[] {"one","two","three","four","five","six","seven","eight","nine","ten"};
//
//        Log.v("NumbersActivity", "The English word at index 0: " + numbersOneToTen[0]);
//        Log.v("NumbersActivity", "The English word at index 1: " + numbersOneToTen[1]);
//        Log.v("NumbersActivity", "The English word at index 2: " + numbersOneToTen[2]);
//        Log.v("NumbersActivity", "The English word at index 3: " + numbersOneToTen[3]);
//        Log.v("NumbersActivity", "The English word at index 4: " + numbersOneToTen[4]);
//        Log.v("NumbersActivity", "The English word at index 5: " + numbersOneToTen[5]);
//        Log.v("NumbersActivity", "The English word at index 6: " + numbersOneToTen[6]);
//        Log.v("NumbersActivity", "The English word at index 7: " + numbersOneToTen[7]);
//        Log.v("NumbersActivity", "The English word at index 8: " + numbersOneToTen[8]);
//        Log.v("NumbersActivity", "The English word at index 9: " + numbersOneToTen[9]);
//
//        List<String> numbersArrayList = new ArrayList<String>();
//        numbersArrayList.add("one");
//        numbersArrayList.add("two");
//        numbersArrayList.add("three");
//        numbersArrayList.add("four");
//        numbersArrayList.add("five");
//        numbersArrayList.add("six");
//        numbersArrayList.add("seven");
//        numbersArrayList.add("eight");
//        numbersArrayList.add("nine");
//        numbersArrayList.add("ten");
//
//      Log.v("NumbersActivity", "The English word at index 0: " + numbersArrayList.get(0));
//      Log.v("NumbersActivity", "The English word at index 1: " + numbersArrayList.get(1));
//      Log.v("NumbersActivity", "The English word at index 2: " + numbersArrayList.get(2));
//      Log.v("NumbersActivity", "The English word at index 3: " + numbersArrayList.get(3));
//      Log.v("NumbersActivity", "The English word at index 4: " + numbersArrayList.get(4));
//      Log.v("NumbersActivity", "The English word at index 5: " + numbersArrayList.get(5));
//      Log.v("NumbersActivity", "The English word at index 6: " + numbersArrayList.get(6));
//      Log.v("NumbersActivity", "The English word at index 7: " + numbersArrayList.get(7));
//      Log.v("NumbersActivity", "The English word at index 8: " + numbersArrayList.get(8));
//      Log.v("NumbersActivity", "The English word at index 9: " + numbersArrayList.get(9));
//
//
//      LinearLayout numbersView = (LinearLayout) findViewById(R.id.ll_numbers_view);
//
//      TextView wordView = new TextView(this);
//      wordView.setText(numbersArrayList.get(0));
//      numbersView.addView(wordView);

      final ArrayList<Word> words = new ArrayList<Word>();

      words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
      words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
      words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
      words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
      words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
      words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
      words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
      words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
      words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
      words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));

      //Binding WordAdapter to list view.
      WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.numbers_activity_background);

      ListView listView = (ListView) findViewById(R.id.lv_numbers_word_view);
      listView.setAdapter(itemsAdapter);

      listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

          Word word = words.get(i);

          mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioPosition());
          mediaPlayer.start();

        }
      });



    }
}
