package com.geodoer.letsmrt.controller;

import android.content.Context;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Kent on 2015/4/18.
 */
public class mCardArrayAdapter  extends it.gmariotti.cardslib.library.internal.CardArrayAdapter {

    static class var{
    }

    Context context;

    public mCardArrayAdapter(Context context, List<Card> cards) {
        super(context, cards);
    }


}
