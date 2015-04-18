package com.geodoer.letsmrt.controller;

import android.view.View;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Kent on 2015/4/19.
 */
public class ActionOnCardLongClicked implements Card.OnLongCardClickListener{

    public ActionOnCardLongClicked() {
    }

    @Override
    public boolean onLongClick(Card card, View view) {

        Toast.makeText(view.getContext(),
                "long clicked at card id=" + card.getId(),
                Toast.LENGTH_SHORT).show();
        return false;
    }
}
