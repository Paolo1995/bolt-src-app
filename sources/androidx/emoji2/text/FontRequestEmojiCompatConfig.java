package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* renamed from: j  reason: collision with root package name */
    private static final FontProviderHelper f6482j = new FontProviderHelper();

    /* loaded from: classes.dex */
    public static class FontProviderHelper {
        public Typeface a(@NonNull Context context, @NonNull FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.a(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        @NonNull
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Context f6483a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final FontRequest f6484b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final FontProviderHelper f6485c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final Object f6486d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Handler f6487e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f6488f;

        /* renamed from: g  reason: collision with root package name */
        private ThreadPoolExecutor f6489g;

        /* renamed from: h  reason: collision with root package name */
        private RetryPolicy f6490h;

        /* renamed from: i  reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f6491i;

        /* renamed from: j  reason: collision with root package name */
        private ContentObserver f6492j;

        /* renamed from: k  reason: collision with root package name */
        private Runnable f6493k;

        FontRequestMetadataLoader(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull FontProviderHelper fontProviderHelper) {
            Preconditions.h(context, "Context cannot be null");
            Preconditions.h(fontRequest, "FontRequest cannot be null");
            this.f6483a = context.getApplicationContext();
            this.f6484b = fontRequest;
            this.f6485c = fontProviderHelper;
        }

        private void b() {
            synchronized (this.f6486d) {
                this.f6491i = null;
                ContentObserver contentObserver = this.f6492j;
                if (contentObserver != null) {
                    this.f6485c.d(this.f6483a, contentObserver);
                    this.f6492j = null;
                }
                Handler handler = this.f6487e;
                if (handler != null) {
                    handler.removeCallbacks(this.f6493k);
                }
                this.f6487e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f6489g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f6488f = null;
                this.f6489g = null;
            }
        }

        private FontsContractCompat.FontInfo e() {
            try {
                FontsContractCompat.FontFamilyResult b8 = this.f6485c.b(this.f6483a, this.f6484b);
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

        private void f(Uri uri, long j8) {
            synchronized (this.f6486d) {
                Handler handler = this.f6487e;
                if (handler == null) {
                    handler = ConcurrencyHelpers.d();
                    this.f6487e = handler;
                }
                if (this.f6492j == null) {
                    ContentObserver contentObserver = new ContentObserver(handler) { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z7, Uri uri2) {
                            FontRequestMetadataLoader.this.d();
                        }
                    };
                    this.f6492j = contentObserver;
                    this.f6485c.c(this.f6483a, uri, contentObserver);
                }
                if (this.f6493k == null) {
                    this.f6493k = new Runnable() { // from class: androidx.emoji2.text.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.d();
                        }
                    };
                }
                handler.postDelayed(this.f6493k, j8);
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void a(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.h(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f6486d) {
                this.f6491i = metadataRepoLoaderCallback;
            }
            d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f6486d) {
                if (this.f6491i == null) {
                    return;
                }
                try {
                    FontsContractCompat.FontInfo e8 = e();
                    int b8 = e8.b();
                    if (b8 == 2) {
                        synchronized (this.f6486d) {
                            RetryPolicy retryPolicy = this.f6490h;
                            if (retryPolicy != null) {
                                long a8 = retryPolicy.a();
                                if (a8 >= 0) {
                                    f(e8.d(), a8);
                                    return;
                                }
                            }
                        }
                    }
                    if (b8 == 0) {
                        TraceCompat.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        Typeface a9 = this.f6485c.a(this.f6483a, e8);
                        ByteBuffer f8 = TypefaceCompatUtil.f(this.f6483a, null, e8.d());
                        if (f8 != null && a9 != null) {
                            MetadataRepo b9 = MetadataRepo.b(a9, f8);
                            TraceCompat.b();
                            synchronized (this.f6486d) {
                                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = this.f6491i;
                                if (metadataRepoLoaderCallback != null) {
                                    metadataRepoLoaderCallback.b(b9);
                                }
                            }
                            b();
                            return;
                        }
                        throw new RuntimeException("Unable to open file.");
                    }
                    throw new RuntimeException("fetchFonts result is not OK. (" + b8 + ")");
                } catch (Throwable th) {
                    synchronized (this.f6486d) {
                        EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = this.f6491i;
                        if (metadataRepoLoaderCallback2 != null) {
                            metadataRepoLoaderCallback2.a(th);
                        }
                        b();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            synchronized (this.f6486d) {
                if (this.f6491i == null) {
                    return;
                }
                if (this.f6488f == null) {
                    ThreadPoolExecutor b8 = ConcurrencyHelpers.b("emojiCompat");
                    this.f6489g = b8;
                    this.f6488f = b8;
                }
                this.f6488f.execute(new Runnable() { // from class: androidx.emoji2.text.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.c();
                    }
                });
            }
        }

        public void g(@NonNull Executor executor) {
            synchronized (this.f6486d) {
                this.f6488f = executor;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context context, @NonNull FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, f6482j));
    }

    @NonNull
    public FontRequestEmojiCompatConfig c(@NonNull Executor executor) {
        ((FontRequestMetadataLoader) a()).g(executor);
        return this;
    }
}
