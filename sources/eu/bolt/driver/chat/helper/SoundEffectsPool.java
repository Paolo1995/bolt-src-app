package eu.bolt.driver.chat.helper;

import android.content.Context;
import android.media.SoundPool;
import eu.bolt.kalev.Kalev;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoundEffectsPool.kt */
@Singleton
/* loaded from: classes5.dex */
public final class SoundEffectsPool {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f40414d = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f40415a;

    /* renamed from: b  reason: collision with root package name */
    private final SoundPool f40416b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<Integer, Sound> f40417c;

    /* compiled from: SoundEffectsPool.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SoundEffectsPool.kt */
    /* loaded from: classes5.dex */
    public static final class Sound {

        /* renamed from: a  reason: collision with root package name */
        private final int f40418a;

        /* renamed from: b  reason: collision with root package name */
        private final int f40419b;

        public Sound(int i8, int i9) {
            this.f40418a = i8;
            this.f40419b = i9;
        }

        public static /* synthetic */ Sound b(Sound sound, int i8, int i9, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i8 = sound.f40418a;
            }
            if ((i10 & 2) != 0) {
                i9 = sound.f40419b;
            }
            return sound.a(i8, i9);
        }

        public final Sound a(int i8, int i9) {
            return new Sound(i8, i9);
        }

        public final int c() {
            return this.f40418a;
        }

        public final int d() {
            return this.f40419b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sound) {
                Sound sound = (Sound) obj;
                return this.f40418a == sound.f40418a && this.f40419b == sound.f40419b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f40418a * 31) + this.f40419b;
        }

        public String toString() {
            int i8 = this.f40418a;
            int i9 = this.f40419b;
            return "Sound(soundId=" + i8 + ", usages=" + i9 + ")";
        }
    }

    @Inject
    public SoundEffectsPool(Context context) {
        Intrinsics.f(context, "context");
        this.f40415a = context;
        this.f40416b = new SoundPool(1, 3, 0);
        this.f40417c = new HashMap<>();
    }

    private final Sound c(Sound sound) {
        return Sound.b(sound, 0, sound.d() + 1, 1, null);
    }

    public final void a(int i8) {
        Sound sound = this.f40417c.get(Integer.valueOf(i8));
        if (sound != null) {
            Kalev.h("Sound id for " + i8 + " -> " + sound);
            this.f40416b.play(sound.c(), 1.0f, 1.0f, 0, 0, 1.0f);
            return;
        }
        Kalev.d("Sound for " + i8 + " is not loaded");
    }

    public final synchronized int b(int i8) {
        int i9;
        try {
            Sound sound = this.f40417c.get(Integer.valueOf(i8));
            if (sound == null) {
                sound = new Sound(this.f40416b.load(this.f40415a, i8, 0), 0);
            }
            this.f40417c.put(Integer.valueOf(i8), c(sound));
            int c8 = sound.c();
            int d8 = sound.d();
            Kalev.h("Preloaded sound " + i8 + " -> " + c8 + " [" + d8 + " usages]");
            i9 = sound.c();
        } catch (Exception e8) {
            Kalev.e(e8, "Error preparig sound " + i8);
            i9 = -1;
        }
        return i9;
    }
}
