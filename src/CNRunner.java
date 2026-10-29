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
            int y = p/width;
            int ColWeight = 0;
            ComplexNumber res = new ComplexNumber((x-R)/(R*0.75),(y-R)/(R*0.75));
            for(; ColWeight < 500; ColWeight++){
                ColWeight++;
                res=res.times(res).plus(C);
                if(res.getModulus()> 2){break;}
            }
            double hue = ColWeight/500;
            double val = 0.8;
            double sat = 0.8;
            System.out.println(ColWeight);
            //Color.getHSBColor((int)hue,(int)sat,(int)val).getRGB()
            //ColWeight == 0?Color.WHITE.getRGB():Color.BLACK.getRGB()
            pixels[p] = ColWeight == 0?Color.WHITE.getRGB():Color.BLACK.getRGB();

        }
        updatePixels();
    }
    public static void main(String[] args){PApplet.main("CNRunner");}
}
