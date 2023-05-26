package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class EmojiCompat {

    /* renamed from: n  reason: collision with root package name */
    private static final Object f6422n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static final Object f6423o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static volatile EmojiCompat f6424p;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Set<InitCallback> f6426b;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final CompatInternal f6429e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final MetadataRepoLoader f6430f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f6431g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f6432h;

    /* renamed from: i  reason: collision with root package name */
    final int[] f6433i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f6434j;

    /* renamed from: k  reason: collision with root package name */
    private final int f6435k;

    /* renamed from: l  reason: collision with root package name */
    private final int f6436l;

    /* renamed from: m  reason: collision with root package name */
    private final GlyphChecker f6437m;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ReadWriteLock f6425a = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private volatile int f6427c = 3;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Handler f6428d = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        final EmojiCompat f6438a;

        CompatInternal(EmojiCompat emojiCompat) {
            this.f6438a = emojiCompat;
        }

        void a() {
            throw null;
        }

        CharSequence b(@NonNull CharSequence charSequence, int i8, int i9, int i10, boolean z7) {
            throw null;
        }

        void c(@NonNull EditorInfo editorInfo) {
            throw null;
        }
    }

    /* loaded from: classes.dex */
    private static final class CompatInternal19 extends CompatInternal {

        /* renamed from: b  reason: collision with root package name */
        private volatile EmojiProcessor f6439b;

        /* renamed from: c  reason: collision with root package name */
        private volatile MetadataRepo f6440c;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void a() {
            try {
                this.f6438a.f6430f.a(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void a(Throwable th) {
                        CompatInternal19.this.f6438a.m(th);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void b(@NonNull MetadataRepo metadataRepo) {
                        CompatInternal19.this.d(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f6438a.m(th);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence b(@NonNull CharSequence charSequence, int i8, int i9, int i10, boolean z7) {
            return this.f6439b.h(charSequence, i8, i9, i10, z7);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void c(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f6440c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f6438a.f6431g);
        }

        void d(@NonNull MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f6438a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f6440c = metadataRepo;
            MetadataRepo metadataRepo2 = this.f6440c;
            SpanFactory spanFactory = new SpanFactory();
            GlyphChecker glyphChecker = this.f6438a.f6437m;
            EmojiCompat emojiCompat = this.f6438a;
            this.f6439b = new EmojiProcessor(metadataRepo2, spanFactory, glyphChecker, emojiCompat.f6432h, emojiCompat.f6433i);
            this.f6438a.n();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Config {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final MetadataRepoLoader f6442a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6443b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6444c;

        /* renamed from: d  reason: collision with root package name */
        int[] f6445d;

        /* renamed from: e  reason: collision with root package name */
        Set<InitCallback> f6446e;

        /* renamed from: f  reason: collision with root package name */
        boolean f6447f;

        /* renamed from: g  reason: collision with root package name */
        int f6448g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        int f6449h = 0;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        GlyphChecker f6450i = new DefaultGlyphChecker();

        /* JADX INFO: Access modifiers changed from: protected */
        public Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.h(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f6442a = metadataRepoLoader;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        public final MetadataRepoLoader a() {
            return this.f6442a;
        }

        @NonNull
        public Config b(int i8) {
            this.f6449h = i8;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface GlyphChecker {
        boolean a(@NonNull CharSequence charSequence, int i8, int i9, int i10);
    }

    /* loaded from: classes.dex */
    public static abstract class InitCallback {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ListenerDispatcher implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final List<InitCallback> f6451f;

        /* renamed from: g  reason: collision with root package name */
        private final Throwable f6452g;

        /* renamed from: h  reason: collision with root package name */
        private final int f6453h;

        ListenerDispatcher(@NonNull InitCallback initCallback, int i8) {
            this(Arrays.asList((InitCallback) Preconditions.h(initCallback, "initCallback cannot be null")), i8, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f6451f.size();
            int i8 = 0;
            if (this.f6453h != 1) {
                while (i8 < size) {
                    this.f6451f.get(i8).a(this.f6452g);
                    i8++;
                }
                return;
            }
            while (i8 < size) {
                this.f6451f.get(i8).b();
                i8++;
            }
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i8) {
            this(collection, i8, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i8, Throwable th) {
            Preconditions.h(collection, "initCallbacks cannot be null");
            this.f6451f = new ArrayList(collection);
            this.f6453h = i8;
            this.f6452g = th;
        }
    }

    /* loaded from: classes.dex */
    public interface MetadataRepoLoader {
        void a(@NonNull MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* loaded from: classes.dex */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(Throwable th);

        public abstract void b(@NonNull MetadataRepo metadataRepo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SpanFactory {
        SpanFactory() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EmojiSpan a(@NonNull EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    private EmojiCompat(@NonNull Config config) {
        this.f6431g = config.f6443b;
        this.f6432h = config.f6444c;
        this.f6433i = config.f6445d;
        this.f6434j = config.f6447f;
        this.f6435k = config.f6448g;
        this.f6430f = config.f6442a;
        this.f6436l = config.f6449h;
        this.f6437m = config.f6450i;
        ArraySet arraySet = new ArraySet();
        this.f6426b = arraySet;
        Set<InitCallback> set = config.f6446e;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.f6446e);
        }
        this.f6429e = new CompatInternal19(this);
        l();
    }

    @NonNull
    public static EmojiCompat b() {
        EmojiCompat emojiCompat;
        boolean z7;
        synchronized (f6422n) {
            emojiCompat = f6424p;
            if (emojiCompat != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean e(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i8, int i9, boolean z7) {
        return EmojiProcessor.c(inputConnection, editable, i8, i9, z7);
    }

    public static boolean f(@NonNull Editable editable, int i8, @NonNull KeyEvent keyEvent) {
        return EmojiProcessor.d(editable, i8, keyEvent);
    }

    @NonNull
    public static EmojiCompat g(@NonNull Config config) {
        EmojiCompat emojiCompat = f6424p;
        if (emojiCompat == null) {
            synchronized (f6422n) {
                emojiCompat = f6424p;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    f6424p = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean h() {
        if (f6424p != null) {
            return true;
        }
        return false;
    }

    private boolean j() {
        if (d() == 1) {
            return true;
        }
        return false;
    }

    private void l() {
        this.f6425a.writeLock().lock();
        try {
            if (this.f6436l == 0) {
                this.f6427c = 0;
            }
            this.f6425a.writeLock().unlock();
            if (d() == 0) {
                this.f6429e.a();
            }
        } catch (Throwable th) {
            this.f6425a.writeLock().unlock();
            throw th;
        }
    }

    public int c() {
        return this.f6435k;
    }

    public int d() {
        this.f6425a.readLock().lock();
        try {
            return this.f6427c;
        } finally {
            this.f6425a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f6434j;
    }

    public void k() {
        boolean z7 = true;
        if (this.f6436l != 1) {
            z7 = false;
        }
        Preconditions.j(z7, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (j()) {
            return;
        }
        this.f6425a.writeLock().lock();
        try {
            if (this.f6427c == 0) {
                return;
            }
            this.f6427c = 0;
            this.f6425a.writeLock().unlock();
            this.f6429e.a();
        } finally {
            this.f6425a.writeLock().unlock();
        }
    }

    void m(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f6425a.writeLock().lock();
        try {
            this.f6427c = 2;
            arrayList.addAll(this.f6426b);
            this.f6426b.clear();
            this.f6425a.writeLock().unlock();
            this.f6428d.post(new ListenerDispatcher(arrayList, this.f6427c, th));
        } catch (Throwable th2) {
            this.f6425a.writeLock().unlock();
            throw th2;
        }
    }

    void n() {
        ArrayList arrayList = new ArrayList();
        this.f6425a.writeLock().lock();
        try {
            this.f6427c = 1;
            arrayList.addAll(this.f6426b);
            this.f6426b.clear();
            this.f6425a.writeLock().unlock();
            this.f6428d.post(new ListenerDispatcher(arrayList, this.f6427c));
        } catch (Throwable th) {
            this.f6425a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        int length;
        if (charSequence == null) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        return p(charSequence, 0, length);
    }

    public CharSequence p(CharSequence charSequence, int i8, int i9) {
        return q(charSequence, i8, i9, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public CharSequence q(CharSequence charSequence, int i8, int i9, int i10) {
        return r(charSequence, i8, i9, i10, 0);
    }

    public CharSequence r(CharSequence charSequence, int i8, int i9, int i10, int i11) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Preconditions.j(j(), "Not initialized yet");
        Preconditions.e(i8, "start cannot be negative");
        Preconditions.e(i9, "end cannot be negative");
        Preconditions.e(i10, "maxEmojiCount cannot be negative");
        if (i8 <= i9) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.b(z7, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        if (i8 <= charSequence.length()) {
            z8 = true;
        } else {
            z8 = false;
        }
        Preconditions.b(z8, "start should be < than charSequence length");
        if (i9 <= charSequence.length()) {
            z9 = true;
        } else {
            z9 = false;
        }
        Preconditions.b(z9, "end should be < than charSequence length");
        if (charSequence.length() != 0 && i8 != i9) {
            if (i11 != 1) {
                if (i11 != 2) {
                    z10 = this.f6431g;
                } else {
                    z10 = false;
                }
            } else {
                z10 = true;
            }
            return this.f6429e.b(charSequence, i8, i9, i10, z10);
        }
        return charSequence;
    }

    public void s(@NonNull InitCallback initCallback) {
        Preconditions.h(initCallback, "initCallback cannot be null");
        this.f6425a.writeLock().lock();
        try {
            if (this.f6427c != 1 && this.f6427c != 2) {
                this.f6426b.add(initCallback);
            }
            this.f6428d.post(new ListenerDispatcher(initCallback, this.f6427c));
        } finally {
            this.f6425a.writeLock().unlock();
        }
    }

    public void t(@NonNull InitCallback initCallback) {
        Preconditions.h(initCallback, "initCallback cannot be null");
        this.f6425a.writeLock().lock();
        try {
            this.f6426b.remove(initCallback);
        } finally {
            this.f6425a.writeLock().unlock();
        }
    }

    public void u(@NonNull EditorInfo editorInfo) {
        if (j() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f6429e.c(editorInfo);
        }
    }
}
