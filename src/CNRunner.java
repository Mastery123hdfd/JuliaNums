import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class CNRunner extends PApplet {
    private ComplexNumber C = new ComplexNumber(1,0);
    private final int R = 300;
    private final int frameCount = (int)(120*PI);
    private PImage[] movie = new PImage[frameCount];
    private int t = 0;
    @Override
    public void settings(){
        size(2*R,2*R);

    }
    public void setup(){
        background(0);
        for(int i = 0; i < frameCount; i++){
            C = new ComplexNumber(0.6*Math.cos(i/60.0),0.1*Math.sin(i/60.0));
            movie[i] = new PImage(600,600);
            movie[i].loadPixels();
            for(int p = 0; p < movie[i].pixels.length; p++){
                int x = p%width;
                int y = p/width;
                int ColWeight = 0;
                ComplexNumber res = new ComplexNumber((x-R)/(R*0.75),(y-R)/(R*0.75));
                for(; ColWeight < 500; ColWeight++){
                    ColWeight++;
                    res=res.times(res).plus(C);
                    if(res.getModulus()> 2){break;}
                }
                float f = (float)Math.sqrt(ColWeight/500f);
                float hue = 0.67f-(0.17f*f);
                float val = 0.9f-(0.4f*f);
                float sat = 0.3f+(0.7f*f);
                //System.out.println(ColWeight);
                //Color.getHSBColor((int)hue,(int)sat,(int)val).getRGB()
                //ColWeight == 0?Color.WHITE.getRGB():Color.BLACK.getRGB()
                movie[i].pixels[p] = Color.getHSBColor( hue,sat,val).getRGB();

            }
            movie[i].updatePixels();
        }
        frameRate(10);
    }
    public void draw(){
        if(t<movie.length){
            background(movie[t]);
            t++;
        } else{
            t = 0;
        }

    }
    public static void main(String[] args){PApplet.main("CNRunner");}
}
