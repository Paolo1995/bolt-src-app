package androidx.emoji.bundled;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.MetadataRepo;

/* loaded from: classes.dex */
public class BundledEmojiCompatConfig extends EmojiCompat.Config {

    /* loaded from: classes.dex */
    private static class BundledMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6303a;

        BundledMetadataLoader(@NonNull Context context) {
            this.f6303a = context.getApplicationContext();
        }

        @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoader
        public void a(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.h(metadataRepoLoaderCallback, "loaderCallback cannot be null");
            Thread thread = new Thread(new InitRunnable(this.f6303a, metadataRepoLoaderCallback));
            thread.setDaemon(false);
            thread.start();
        }
    }

    /* loaded from: classes.dex */
    private static class InitRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final EmojiCompat.MetadataRepoLoaderCallback f6304f;

        /* renamed from: g  reason: collision with root package name */
        private final Context f6305g;

        InitRunnable(Context context, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            this.f6305g = context;
            this.f6304f = metadataRepoLoaderCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6304f.b(MetadataRepo.b(this.f6305g.getAssets(), "NotoColorEmojiCompat.ttf"));
            } catch (Throwable th) {
                this.f6304f.a(th);
            }
        }
    }

    public BundledEmojiCompatConfig(@NonNull Context context) {
        super(new BundledMetadataLoader(context));
    }
}
