package com.geodoer.letsmrt.controller;

import android.view.View;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Kent on 2015/4/19.
 */
public class ActionOnCardClicked implements Card.OnCardClickListener{

    public ActionOnCardClicked() {
    }

    @Override
    public void onClick(Card card, View view) {
        Toast.makeText(view.getContext(),
                "card id="+card.getId(),
                Toast.LENGTH_SHORT).show();
    }
}
