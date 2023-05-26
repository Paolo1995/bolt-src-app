package androidx.emoji.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiCompat;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* renamed from: i  reason: collision with root package name */
    private static final FontProviderHelper f6359i = new FontProviderHelper();

    /* loaded from: classes.dex */
    public static class FontProviderHelper {
        public Typeface a(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.a(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult b(@NonNull Context context, @NonNull FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.b(context, null, fontRequest);
        }

        public void c(@NonNull Context context, @NonNull Uri uri, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* loaded from: classes.dex */
    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6360a;

        /* renamed from: b  reason: collision with root package name */
        private final FontRequest f6361b;

        /* renamed from: c  reason: collision with root package name */
        private final FontProviderHelper f6362c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f6363d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Handler f6364e;

        /* renamed from: f  reason: collision with root package name */
        private HandlerThread f6365f;

        /* renamed from: g  reason: collision with root package name */
        private RetryPolicy f6366g;

        /* renamed from: h  reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f6367h;

        /* renamed from: i  reason: collision with root package name */
        private ContentObserver f6368i;

        /* renamed from: j  reason: collision with root package name */
        private Runnable f6369j;

        FontRequestMetadataLoader(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
            Preconditions.h(context, "Context cannot be null");
            Preconditions.h(fontRequest, "FontRequest cannot be null");
            this.f6360a = context.getApplicationContext();
            this.f6361b = fontRequest;
            this.f6362c = fontProviderHelper;
        }

        private void b() {
            this.f6367h = null;
            ContentObserver contentObserver = this.f6368i;
            if (contentObserver != null) {
                this.f6362c.d(this.f6360a, contentObserver);
                this.f6368i = null;
            }
            synchronized (this.f6363d) {
                this.f6364e.removeCallbacks(this.f6369j);
                HandlerThread handlerThread = this.f6365f;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.f6364e = null;
                this.f6365f = null;
            }
        }

        private FontsContractCompat.FontInfo d() {
            try {
                FontsContractCompat.FontFamilyResult b8 = this.f6362c.b(this.f6360a, this.f6361b);
                if (b8.c() == 0) {
                    FontsContractCompat.FontInfo[] b9 = b8.b();
                    if (b9 != null && b9.length != 0) {
                        return b9[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b8.c() + ")");
            } catch (PackageManager.NameNotFoundException e8) {
                throw new RuntimeException("provider not found", e8);
            }
        }

        private void e(Uri uri, long j8) {
            synchronized (this.f6363d) {
                if (this.f6368i == null) {
                    ContentObserver contentObserver = new ContentObserver(this.f6364e) { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.2
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z7, Uri uri2) {
                            FontRequestMetadataLoader.this.c();
                        }
                    };
                    this.f6368i = contentObserver;
                    this.f6362c.c(this.f6360a, uri, contentObserver);
                }
                if (this.f6369j == null) {
                    this.f6369j = new Runnable() { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FontRequestMetadataLoader.this.c();
                        }
                    };
                }
                this.f6364e.postDelayed(this.f6369j, j8);
            }
        }

        @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoader
        public void a(@NonNull final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.h(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f6363d) {
                if (this.f6364e == null) {
                    HandlerThread handlerThread = new HandlerThread("emojiCompat", 10);
                    this.f6365f = handlerThread;
                    handlerThread.start();
                    this.f6364e = new Handler(this.f6365f.getLooper());
                }
                this.f6364e.post(new Runnable() { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FontRequestMetadataLoader fontRequestMetadataLoader = FontRequestMetadataLoader.this;
                        fontRequestMetadataLoader.f6367h = metadataRepoLoaderCallback;
                        fontRequestMetadataLoader.c();
                    }
                });
            }
        }

        void c() {
            if (this.f6367h == null) {
                return;
            }
            try {
                FontsContractCompat.FontInfo d8 = d();
                int b8 = d8.b();
                if (b8 == 2) {
                    synchronized (this.f6363d) {
                        RetryPolicy retryPolicy = this.f6366g;
                        if (retryPolicy != null) {
                            long a8 = retryPolicy.a();
                            if (a8 >= 0) {
                                e(d8.d(), a8);
                                return;
                            }
                        }
                    }
                }
                if (b8 == 0) {
                    Typeface a9 = this.f6362c.a(this.f6360a, d8);
                    ByteBuffer f8 = TypefaceCompatUtil.f(this.f6360a, null, d8.d());
                    if (f8 != null) {
                        this.f6367h.b(MetadataRepo.c(a9, f8));
                        b();
                        return;
                    }
                    throw new RuntimeException("Unable to open file.");
                }
                throw new RuntimeException("fetchFonts result is not OK. (" + b8 + ")");
            } catch (Throwable th) {
                this.f6367h.a(th);
                b();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, f6359i));
    }
}
