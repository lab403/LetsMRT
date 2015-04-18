package com.geodoer.letsmrt.controller;

import android.content.Context;

import com.geodoer.letsmrt.R;
import com.geodoer.letsmrt.card.ColorCard;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Kent on 2015/4/19.
 */
public class ActionSetColorCard {

    Context context;

    public ActionSetColorCard(Context context) {
        this.context = context;
    }

    public ArrayList<Card> getCards() {
        //Init an array of Cards
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ColorCard card = new ColorCard(this.context);
            card.setTitle("A simple colored card " + i);
            card.setCount(i);
            card.setId(String.valueOf(i));
            switch (i) {
                case 0:
                    card.setBackgroundColorResourceId(R.color.demo_card_background_color5);
                    break;
                case 1:
                    card.setBackgroundColorResourceId(R.color.demo_card_background_color4);
                    break;
                case 2:
                    card.setBackgroundColorResourceId(R.color.demo_card_background_color3);
                    break;
                case 3:
                    card.setBackgroundColorResourceId(R.color.demo_card_background_color2);
                    break;
                case 4:
                    card.setBackgroundColorResourceId(R.color.demo_card_background_color1);
                    break;
            }
            card.setOnClickListener(new ActionOnCardClicked());
            cards.add(card);
        }
        return  cards;
    }
}
