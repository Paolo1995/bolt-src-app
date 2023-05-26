package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {

        /* renamed from: a  reason: collision with root package name */
        private final Context f6456a;

        BackgroundDefaultLoader(Context context) {
            this.f6456a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void a(@NonNull final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            final ThreadPoolExecutor b8 = ConcurrencyHelpers.b("EmojiCompatInitializer");
            b8.execute(new Runnable() { // from class: androidx.emoji2.text.b
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.BackgroundDefaultLoader.this.d(metadataRepoLoaderCallback, b8);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public void d(@NonNull final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, @NonNull final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig a8 = DefaultEmojiCompatConfig.a(this.f6456a);
                if (a8 != null) {
                    a8.c(threadPoolExecutor);
                    a8.a().a(new EmojiCompat.MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1
                        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                        public void a(Throwable th) {
                            try {
                                metadataRepoLoaderCallback.a(th);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }

                        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                        public void b(@NonNull MetadataRepo metadataRepo) {
                            try {
                                metadataRepoLoaderCallback.b(metadataRepo);
                            } finally {
                                threadPoolExecutor.shutdown();
                            }
                        }
                    });
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                metadataRepoLoaderCallback.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.h()) {
                    EmojiCompat.b().k();
                }
            } finally {
                TraceCompat.b();
            }
        }
    }

    @Override // androidx.startup.Initializer
    @NonNull
    /* renamed from: b */
    public Boolean a(@NonNull Context context) {
        EmojiCompat.g(new BackgroundDefaultConfig(context));
        c(context);
        return Boolean.TRUE;
    }

    void c(@NonNull Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void a(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.a.a(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.a.b(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.a.c(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.FullLifecycleObserver
            public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.d();
                lifecycle.c(this);
            }

            @Override // androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.a.d(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                androidx.lifecycle.a.e(this, lifecycleOwner);
            }
        });
    }

    void d() {
        ConcurrencyHelpers.d().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
