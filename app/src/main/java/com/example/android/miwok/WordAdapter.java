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
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    //Resource ID para mudar o fundo da lista de palavras
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words   is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResouceId) {
        super(context, 0, words);
        mColorResourceId = colorResouceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Procura o TextView no arquivo list_item.xml layout com a identificaçã
        // ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Pega a Miwok translation do currentWord object e coloca o texto no Miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Procura o TextView no arquivo list_item.xml layout com a identificação
        // ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Pega a Tradução em Inglês (default translation) do currentWord object e coloca no local
        // da tradução em inglês (default translation).
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Procura a ImageView no arquivo list_item.xml layout com a identificação
        // ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // Pega a imagem (image resource ID) do arquivo currentWord object coloca no local definido
            //para imagem
            imageView.setImageResource(currentWord.getImageResourceId());

            //faz a imagem ficar visível
            imageView.setVisibility(View.VISIBLE);
        } else {
            //GONE esconde completamente o local onde deveria ter imagem
            imageView.setVisibility(View.GONE);
        }

        //define o tema de cor para a list_item
        View textContainer = listItemView.findViewById(R.id.text_container);

        //procura a cor que o resource ID mapeia
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //retorna toda a item_list (2 TextViews) então mostra a cor de fundo da ListView
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and one ImageView)
        // so that it can be shown in the ListView.
        return listItemView;
    }
}
