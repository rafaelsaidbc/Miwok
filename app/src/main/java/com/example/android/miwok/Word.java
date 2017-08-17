package com.example.android.miwok;

/**
 * Created by Rafael Said on 14/08/17.
 * <p>
 * representa um vocabulário de palavras que o usuário quer aprender.
 * Contém a palavra do idioma padrão (nativo), neste caso o inglês, e a palavra traduzida para o idioma
 * que se quer aprender, neste caso o Miwok
 */


public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    //Default (inglês) translation
    private String mDefaultTranslation;
    //Miwok (idioma a ser aprendido) translation
    private String mMiwokTranslation;
    //adiciona imagem à lista
    private int mImageResouceId = NO_IMAGE_PROVIDED;
    //audio resource id for the word
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /*
    *Cria um novo Word object
    *@param defaultTranslation palavra em inglês
     * *@param miwokTranslation palavra em Miwok
      * @param imageResourId imagem que faz referência à palavra
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResouceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }


    //get the default translation word.
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //get the Miwok translation word.
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResouceId;
    }

    //retorna true se tiver imagem (colors, family and numbers) e false de não tiver imagem (phrase)
    public boolean hasImage() {
        //se a variável for não igual (!=) a -1 haverá imagem a ser obtida, método retorna true
        return mImageResouceId != NO_IMAGE_PROVIDED;
    }

    //retorna o audio resource Id of this class
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
