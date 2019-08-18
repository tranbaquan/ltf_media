package edu.hcmuaf.tranbaquan.media.ltf;

import com.tranbaquan.voice.command.sphinx4.Recognizer;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            Recognizer recognizer = new Recognizer();
            LiveSpeechRecognizer liveSpeechRecognizer = recognizer.getRecognizer();
            liveSpeechRecognizer.startRecognition(true);
            while (true) {
                String utterance = liveSpeechRecognizer.getResult().getHypothesis();

                if (utterance.equals("CLOSE")) {
                    break;
                }

                System.out.println(utterance);
                liveSpeechRecognizer.stopRecognition();
                liveSpeechRecognizer.startRecognition(true);
            }

            liveSpeechRecognizer.stopRecognition();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
