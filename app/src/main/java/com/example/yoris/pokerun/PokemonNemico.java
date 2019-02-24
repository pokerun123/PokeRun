package com.example.yoris.pokerun;


import android.widget.ImageView;

public class PokemonNemico extends PokeRun implements Runnable {

    private ImageView immagine;
    private int spawnX=0,spawnY=0;

    public PokemonNemico() {

        /*if(Math.random()==0) {
            spawnX = new Random().nextInt(0) + getWidth();
        }else{
            spawnY = new Random().nextInt(0) + getHeight();
        }*/
        immagine = new ImageView(this);
        immagine.setImageResource(R.drawable.squirtle);
        immagine.getLayoutParams().height = 100;
        immagine.getLayoutParams().width = 100;
        immagine.setX(spawnX);
        immagine.setY(spawnY);
    }

    @Override
    public void run() {
        /*for(int i=0;i<getHeight();i+=10){
            immagine.setY(i);
        }*/
    }
}
