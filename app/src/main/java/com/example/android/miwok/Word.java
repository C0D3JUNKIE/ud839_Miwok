package com.example.android.miwok;

public class Word {

  private static final int NO_IMAGE_PROVIDED = -1;

  private String miwokTranslationText;
  private String defaultTranslationText;
  private int displayImageResourceId;
  private int audioPosition;


  public Word() {
  }

  public Word(String miwokTranslationText, String defaultTranslationText, int audioPosition) {
    this.miwokTranslationText = miwokTranslationText;
    this.defaultTranslationText = defaultTranslationText;
    this.audioPosition = audioPosition;
  }

  public Word(String miwokTranslationText, String defaultTranslationText,
      int displayImageResourceId, int audioPosition) {
    this.miwokTranslationText = miwokTranslationText;
    this.defaultTranslationText = defaultTranslationText;
    this.displayImageResourceId = displayImageResourceId;
    this.audioPosition = audioPosition;
  }

  @Override
  public String toString() {
    return "Word{" +
        "defaultTranslationText = " + defaultTranslationText + '\'' +
        ", miwokTranslationText = " + miwokTranslationText + '\'' +
        ", audioPosition = " + audioPosition +
        ", displayImageResourceId = " + displayImageResourceId + '}';
  }

  public String getDefaultTranslationText() {
    return defaultTranslationText;
  }

  public String getMiwokTranslationText() {
    return miwokTranslationText;
  }

  public int getDisplayImageResourceId() {
    return displayImageResourceId;
  }

  public boolean hasIamge() {
    return displayImageResourceId != NO_IMAGE_PROVIDED;
  }

  public int getAudioPosition() {
    return audioPosition;
  }

  //  public void setDefaultTranslationText(String defaultTranslationText) {
//    this.defaultTranslationText = defaultTranslationText;
//  }
//
//  public void setMiwokTranslationText(String miwokTranslationText) {
//    this.miwokTranslationText = miwokTranslationText;
//  }

}
