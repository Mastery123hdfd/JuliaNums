import processing.core.PApplet;
import java.awt.*;

public class CNRunner extends PApplet {
    private final ComplexNumber C = new ComplexNumber(-0.7269,0.1889);
    private final int R = 300;
    @Override
    public void settings(){
        size(600,600);;
    }
    public void setup(){
        loadPixels();
        for(int p = 0; p < pixels.length; p++){
            int x = p%width;
            int y = p/height;
            int ColWeight = 0;
            for(int i = 0; i < 500; i++){
                ColWeight++;
                ComplexNumber res = new ComplexNumber(x-R,y-R);
                res=res.times(res).plus(C);
                if(res.getModulus() < 1){break;}
            }
            double hue = ColWeight*360/500;
            double val = 80;
            double sat = 80;
            System.out.println(ColWeight);
            //Color.getHSBColor((int)hue,(int)sat,(int)val).getRGB()
            //ColWeight == 0?Color.WHITE.getRGB():Color.BLACK.getRGB()
            pixels[p] = Color.getHSBColor((int)hue,(int)sat,(int)val).getRGB();
            updatePixels();
        }
    }
    public static void main(String[] args){PApplet.main("CNRunner");}
}
