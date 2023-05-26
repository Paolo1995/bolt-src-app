package com.sinch.android.rtc.internal.client;

import android.media.ToneGenerator;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class DtmfPlayer {
    private static final int TONE_DURATION_MS = 200;
    private static final int VOLUME_PERCENT = 100;
    private boolean mPlaying = false;
    private ArrayList<Character> mTonesToPlay = new ArrayList<>();
    private ToneGenerator mToneGenerator = new ToneGenerator(0, 100);
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void playNextTone() {
        if (this.mTonesToPlay.size() > 0) {
            this.mTonesToPlay.remove(0);
            this.mToneGenerator.startTone(toDtmfToneType(this.mTonesToPlay.get(0)), TONE_DURATION_MS);
        }
        if (this.mTonesToPlay.size() > 0) {
            scheduleNextTone();
        } else {
            this.mPlaying = false;
        }
    }

    private void scheduleNextTone() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.sinch.android.rtc.internal.client.DtmfPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                DtmfPlayer.this.playNextTone();
            }
        }, 400L);
    }

    private static int toDtmfToneType(Character ch) {
        char charValue = ch.charValue();
        if (charValue != '#') {
            if (charValue != '*') {
                switch (charValue) {
                    case '0':
                        return 0;
                    case '1':
                        return 1;
                    case '2':
                        return 2;
                    case '3':
                        return 3;
                    case '4':
                        return 4;
                    case '5':
                        return 5;
                    case '6':
                        return 6;
                    case '7':
                        return 7;
                    case '8':
                        return 8;
                    case '9':
                        return 9;
                    default:
                        switch (charValue) {
                            case 'A':
                                return 12;
                            case 'B':
                                return 13;
                            case 'C':
                                return 14;
                            case 'D':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Dtmf tone key not supported: " + ch);
                        }
                }
            }
            return 10;
        }
        return 11;
    }

    public synchronized void play(String str) {
        for (char c8 : str.toCharArray()) {
            this.mTonesToPlay.add(Character.valueOf(c8));
        }
        if (!this.mPlaying) {
            this.mPlaying = true;
            playNextTone();
        }
    }
}
