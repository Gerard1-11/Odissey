package mx.dbas.odissey;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.Locale;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import java.util.Locale;

public class Text {

    public static void speak(String text){}
        Context context;
        TextToSpeech t1=new TextToSpeech(context.getApplicationContext(), new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            if(status != TextToSpeech.ERROR) {
                t1.setLanguage(Locale.ENGLISH);
            }
        }
    });

    public void text(String text){
        t1.speak(text,TextToSpeech.QUEUE_ADD,null);
    }

}