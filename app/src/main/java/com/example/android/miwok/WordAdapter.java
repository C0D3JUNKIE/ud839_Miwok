package com.example.android.miwok;

import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

  private int colorResourceId;

  public WordAdapter(@NonNull Context context, ArrayList<Word> translatedWord, int colorResourceId) {
    super(context, 0, translatedWord);
    this.colorResourceId = colorResourceId;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    View listItemView = convertView;
    if(listItemView == null){
      listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    Word currentWord = getItem(position);

    TextView miwokTranslationText = listItemView.findViewById(R.id.miwok_text_view);
    miwokTranslationText.setText(currentWord.getDefaultTranslationText());

    TextView defaultTranslationText = listItemView.findViewById(R.id.english_text_view);
    defaultTranslationText.setText(currentWord.getMiwokTranslationText());

    ImageView displayImageResource = listItemView.findViewById(R.id.iv_image);
    displayImageResource.setImageResource(currentWord.getDisplayImageResourceId());
//    if(currentWord.hasIamge()){
//      displayImageResource.setImageResource(currentWord.getDisplayImageResourceId());
//      displayImageResource.setImageResource(View.VISIBLE);
//    }else{
//      displayImageResource.setVisibility(View.GONE);
//    }
    View listContainer = listItemView.findViewById(R.id.translation_text_views);
    int color = ContextCompat.getColor(getContext(), colorResourceId);
    listContainer.setBackgroundColor(color);

    return listItemView;
  }


}