package androidx.emoji.text;

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

    /* renamed from: m  reason: collision with root package name */
    private static final Object f6306m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static volatile EmojiCompat f6307n;

    /* renamed from: b  reason: collision with root package name */
    private final Set<InitCallback> f6309b;

    /* renamed from: e  reason: collision with root package name */
    private final CompatInternal f6312e;

    /* renamed from: f  reason: collision with root package name */
    final MetadataRepoLoader f6313f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f6314g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f6315h;

    /* renamed from: i  reason: collision with root package name */
    final int[] f6316i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f6317j;

    /* renamed from: k  reason: collision with root package name */
    private final int f6318k;

    /* renamed from: l  reason: collision with root package name */
    private final int f6319l;

    /* renamed from: a  reason: collision with root package name */
    private final ReadWriteLock f6308a = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private int f6310c = 3;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f6311d = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CompatInternal {

        /* renamed from: a  reason: collision with root package name */
        final EmojiCompat f6320a;

        CompatInternal(EmojiCompat emojiCompat) {
            this.f6320a = emojiCompat;
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
        private volatile EmojiProcessor f6321b;

        /* renamed from: c  reason: collision with root package name */
        private volatile MetadataRepo f6322c;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji.text.EmojiCompat.CompatInternal
        void a() {
            try {
                this.f6320a.f6313f.a(new MetadataRepoLoaderCallback() { // from class: androidx.emoji.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void a(Throwable th) {
                        CompatInternal19.this.f6320a.j(th);
                    }

                    @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void b(@NonNull MetadataRepo metadataRepo) {
                        CompatInternal19.this.d(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.f6320a.j(th);
            }
        }

        @Override // androidx.emoji.text.EmojiCompat.CompatInternal
        CharSequence b(@NonNull CharSequence charSequence, int i8, int i9, int i10, boolean z7) {
            return this.f6321b.h(charSequence, i8, i9, i10, z7);
        }

        @Override // androidx.emoji.text.EmojiCompat.CompatInternal
        void c(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f6322c.f());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f6320a.f6314g);
        }

        void d(@NonNull MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.f6320a.j(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f6322c = metadataRepo;
            MetadataRepo metadataRepo2 = this.f6322c;
            SpanFactory spanFactory = new SpanFactory();
            EmojiCompat emojiCompat = this.f6320a;
            this.f6321b = new EmojiProcessor(metadataRepo2, spanFactory, emojiCompat.f6315h, emojiCompat.f6316i);
            this.f6320a.k();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Config {

        /* renamed from: a  reason: collision with root package name */
        final MetadataRepoLoader f6324a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6325b;

        /* renamed from: c  reason: collision with root package name */
        boolean f6326c;

        /* renamed from: d  reason: collision with root package name */
        int[] f6327d;

        /* renamed from: e  reason: collision with root package name */
        Set<InitCallback> f6328e;

        /* renamed from: f  reason: collision with root package name */
        boolean f6329f;

        /* renamed from: g  reason: collision with root package name */
        int f6330g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        int f6331h = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.h(metadataRepoLoader, "metadataLoader cannot be null.");
            this.f6324a = metadataRepoLoader;
        }
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
        private final List<InitCallback> f6332f;

        /* renamed from: g  reason: collision with root package name */
        private final Throwable f6333g;

        /* renamed from: h  reason: collision with root package name */
        private final int f6334h;

        ListenerDispatcher(@NonNull InitCallback initCallback, int i8) {
            this(Arrays.asList((InitCallback) Preconditions.h(initCallback, "initCallback cannot be null")), i8, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f6332f.size();
            int i8 = 0;
            if (this.f6334h != 1) {
                while (i8 < size) {
                    this.f6332f.get(i8).a(this.f6333g);
                    i8++;
                }
                return;
            }
            while (i8 < size) {
                this.f6332f.get(i8).b();
                i8++;
            }
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i8) {
            this(collection, i8, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i8, Throwable th) {
            Preconditions.h(collection, "initCallbacks cannot be null");
            this.f6332f = new ArrayList(collection);
            this.f6334h = i8;
            this.f6333g = th;
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
        this.f6314g = config.f6325b;
        this.f6315h = config.f6326c;
        this.f6316i = config.f6327d;
        this.f6317j = config.f6329f;
        this.f6318k = config.f6330g;
        this.f6313f = config.f6324a;
        this.f6319l = config.f6331h;
        ArraySet arraySet = new ArraySet();
        this.f6309b = arraySet;
        Set<InitCallback> set = config.f6328e;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.f6328e);
        }
        this.f6312e = new CompatInternal19(this);
        i();
    }

    public static EmojiCompat a() {
        boolean z7;
        EmojiCompat emojiCompat;
        synchronized (f6306m) {
            if (f6307n != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.j(z7, "EmojiCompat is not initialized. Please call EmojiCompat.init() first");
            emojiCompat = f6307n;
        }
        return emojiCompat;
    }

    public static boolean d(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i8, int i9, boolean z7) {
        return EmojiProcessor.c(inputConnection, editable, i8, i9, z7);
    }

    public static boolean e(@NonNull Editable editable, int i8, KeyEvent keyEvent) {
        return EmojiProcessor.d(editable, i8, keyEvent);
    }

    public static EmojiCompat f(@NonNull Config config) {
        if (f6307n == null) {
            synchronized (f6306m) {
                if (f6307n == null) {
                    f6307n = new EmojiCompat(config);
                }
            }
        }
        return f6307n;
    }

    private boolean h() {
        if (c() == 1) {
            return true;
        }
        return false;
    }

    private void i() {
        this.f6308a.writeLock().lock();
        try {
            if (this.f6319l == 0) {
                this.f6310c = 0;
            }
            this.f6308a.writeLock().unlock();
            if (c() == 0) {
                this.f6312e.a();
            }
        } catch (Throwable th) {
            this.f6308a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f6318k;
    }

    public int c() {
        this.f6308a.readLock().lock();
        try {
            return this.f6310c;
        } finally {
            this.f6308a.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f6317j;
    }

    void j(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f6308a.writeLock().lock();
        try {
            this.f6310c = 2;
            arrayList.addAll(this.f6309b);
            this.f6309b.clear();
            this.f6308a.writeLock().unlock();
            this.f6311d.post(new ListenerDispatcher(arrayList, this.f6310c, th));
        } catch (Throwable th2) {
            this.f6308a.writeLock().unlock();
            throw th2;
        }
    }

    void k() {
        ArrayList arrayList = new ArrayList();
        this.f6308a.writeLock().lock();
        try {
            this.f6310c = 1;
            arrayList.addAll(this.f6309b);
            this.f6309b.clear();
            this.f6308a.writeLock().unlock();
            this.f6311d.post(new ListenerDispatcher(arrayList, this.f6310c));
        } catch (Throwable th) {
            this.f6308a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence l(@NonNull CharSequence charSequence) {
        int length;
        if (charSequence == null) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        return m(charSequence, 0, length);
    }

    public CharSequence m(@NonNull CharSequence charSequence, int i8, int i9) {
        return n(charSequence, i8, i9, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public CharSequence n(@NonNull CharSequence charSequence, int i8, int i9, int i10) {
        return o(charSequence, i8, i9, i10, 0);
    }

    public CharSequence o(@NonNull CharSequence charSequence, int i8, int i9, int i10, int i11) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Preconditions.j(h(), "Not initialized yet");
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
            return charSequence;
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
                    z10 = this.f6314g;
                } else {
                    z10 = false;
                }
            } else {
                z10 = true;
            }
            return this.f6312e.b(charSequence, i8, i9, i10, z10);
        }
        return charSequence;
    }

    public void p(@NonNull InitCallback initCallback) {
        Preconditions.h(initCallback, "initCallback cannot be null");
        this.f6308a.writeLock().lock();
        try {
            int i8 = this.f6310c;
            if (i8 != 1 && i8 != 2) {
                this.f6309b.add(initCallback);
            }
            this.f6311d.post(new ListenerDispatcher(initCallback, i8));
        } finally {
            this.f6308a.writeLock().unlock();
        }
    }

    public void q(@NonNull EditorInfo editorInfo) {
        if (h() && editorInfo != null && editorInfo.extras != null) {
            this.f6312e.c(editorInfo);
        }
    }
}
