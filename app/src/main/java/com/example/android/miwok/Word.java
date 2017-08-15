package com.example.android.miwok;

/**
 * Created by Rafael Said on 14/08/17.
 * <p>
 * representa um vocabulário de palavras que o usuário quer aprender.
 * Contém a palavra do idioma padrão (nativo), neste caso o inglês, e a palavra traduzida para o idioma
 * que se quer aprender, neste caso o Miwok
 */


public class Word {

    //Default (inglês) translation
    private String mDefaultTranslation;

    //Miwok (idioma a ser aprendido) translation
    private String mMiwokTranslation;

    //adiciona imagem à lista
    private int mImageResouceId;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /*
    *Cria um novo Word object
    *@param defaultTranslation palavra em inglês
     * *@param miwokTranslation palavra em Miwok
      * @param imageResourId imagem que faz referência à palavra
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResouceId = imageResourceId;
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
}
