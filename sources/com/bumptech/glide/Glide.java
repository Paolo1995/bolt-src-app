package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {

    /* renamed from: q  reason: collision with root package name */
    private static volatile Glide f9726q;

    /* renamed from: r  reason: collision with root package name */
    private static volatile boolean f9727r;

    /* renamed from: f  reason: collision with root package name */
    private final Engine f9728f;

    /* renamed from: g  reason: collision with root package name */
    private final BitmapPool f9729g;

    /* renamed from: h  reason: collision with root package name */
    private final MemoryCache f9730h;

    /* renamed from: i  reason: collision with root package name */
    private final GlideContext f9731i;

    /* renamed from: j  reason: collision with root package name */
    private final Registry f9732j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayPool f9733k;

    /* renamed from: l  reason: collision with root package name */
    private final RequestManagerRetriever f9734l;

    /* renamed from: m  reason: collision with root package name */
    private final ConnectivityMonitorFactory f9735m;

    /* renamed from: o  reason: collision with root package name */
    private final RequestOptionsFactory f9737o;

    /* renamed from: n  reason: collision with root package name */
    private final List<RequestManager> f9736n = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private MemoryCategory f9738p = MemoryCategory.NORMAL;

    /* loaded from: classes.dex */
    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1, types: [com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder] */
    public Glide(@NonNull Context context, @NonNull Engine engine, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i8, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, GlideExperiments glideExperiments) {
        ResourceDecoder streamBitmapDecoder;
        ByteBufferBitmapDecoder byteBufferBitmapDecoder;
        this.f9728f = engine;
        this.f9729g = bitmapPool;
        this.f9733k = arrayPool;
        this.f9730h = memoryCache;
        this.f9734l = requestManagerRetriever;
        this.f9735m = connectivityMonitorFactory;
        this.f9737o = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f9732j = registry;
        registry.o(new DefaultImageHeaderParser());
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 27) {
            registry.o(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> g8 = registry.g();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, g8, bitmapPool, arrayPool);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> h8 = VideoDecoder.h(bitmapPool);
        Downsampler downsampler = new Downsampler(registry.g(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (glideExperiments.a(GlideBuilder.EnableImageDecoderForBitmaps.class) && i9 >= 28) {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            ByteBufferBitmapDecoder byteBufferBitmapDecoder2 = new ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
            byteBufferBitmapDecoder = byteBufferBitmapDecoder2;
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new ByteBufferEncoder()).a(InputStream.class, new StreamEncoder(arrayPool)).e("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).e("Bitmap", InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h8).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(bitmapPool)).d(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.a()).e("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).b(Bitmap.class, bitmapEncoder).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, h8)).b(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).e("Gif", InputStream.class, GifDrawable.class, new StreamGifDecoder(g8, byteBufferGifDecoder, arrayPool)).e("Gif", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).b(GifDrawable.class, new GifDrawableEncoder()).d(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.a()).e("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).c(Uri.class, Drawable.class, resourceDrawableDecoder).c(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).p(new ByteBufferRewinder.Factory()).d(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).d(File.class, InputStream.class, new FileLoader.StreamFactory()).c(File.class, File.class, new FileDecoder()).d(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).d(File.class, File.class, UnitModelLoader.Factory.a()).p(new InputStreamRewinder.Factory(arrayPool));
        if (ParcelFileDescriptorRewinder.c()) {
            registry.p(new ParcelFileDescriptorRewinder.Factory());
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, streamFactory).d(cls, ParcelFileDescriptor.class, fileDescriptorFactory).d(Integer.class, InputStream.class, streamFactory).d(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory).d(Integer.class, Uri.class, uriFactory).d(cls, AssetFileDescriptor.class, assetFileDescriptorFactory).d(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).d(cls, Uri.class, uriFactory).d(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).d(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).d(String.class, InputStream.class, new StringLoader.StreamFactory()).d(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).d(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).d(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).d(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).d(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i9 >= 29) {
            registry.d(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        registry.d(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).d(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).d(URL.class, InputStream.class, new UrlLoader.StreamFactory()).d(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).d(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).d(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).d(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).d(Uri.class, Uri.class, UnitModelLoader.Factory.a()).d(Drawable.class, Drawable.class, UnitModelLoader.Factory.a()).c(Drawable.class, Drawable.class, new UnitDrawableDecoder()).q(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).q(Bitmap.class, byte[].class, bitmapBytesTranscoder).q(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).q(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        if (i9 >= 23) {
            ResourceDecoder<ByteBuffer, Bitmap> d8 = VideoDecoder.d(bitmapPool);
            registry.c(ByteBuffer.class, Bitmap.class, d8);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, d8));
        }
        this.f9731i = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, glideExperiments, i8);
    }

    private static void a(@NonNull Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f9727r) {
            f9727r = true;
            m(context, generatedAppGlideModule);
            f9727r = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static Glide c(@NonNull Context context) {
        if (f9726q == null) {
            GeneratedAppGlideModule d8 = d(context.getApplicationContext());
            synchronized (Glide.class) {
                if (f9726q == null) {
                    a(context, d8);
                }
            }
        }
        return f9726q;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e8) {
            q(e8);
            return null;
        } catch (InstantiationException e9) {
            q(e9);
            return null;
        } catch (NoSuchMethodException e10) {
            q(e10);
            return null;
        } catch (InvocationTargetException e11) {
            q(e11);
            return null;
        }
    }

    @NonNull
    private static RequestManagerRetriever l(Context context) {
        Preconditions.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(@NonNull Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new GlideBuilder(), generatedAppGlideModule);
    }

    private static void n(@NonNull Context context, @NonNull GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new ManifestParser(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d8 = generatedAppGlideModule.d();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (d8.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<GlideModule> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            requestManagerFactory = generatedAppGlideModule.e();
        } else {
            requestManagerFactory = null;
        }
        glideBuilder.b(requestManagerFactory);
        for (GlideModule glideModule : emptyList) {
            glideModule.a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, glideBuilder);
        }
        Glide a8 = glideBuilder.a(applicationContext);
        for (GlideModule glideModule2 : emptyList) {
            try {
                glideModule2.b(applicationContext, a8, a8.f9732j);
            } catch (AbstractMethodError e8) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule2.getClass().getName(), e8);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a8, a8.f9732j);
        }
        applicationContext.registerComponentCallbacks(a8);
        f9726q = a8;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static RequestManager t(@NonNull Context context) {
        return l(context).l(context);
    }

    @NonNull
    public static RequestManager u(@NonNull View view) {
        return l(view.getContext()).m(view);
    }

    public void b() {
        Util.b();
        this.f9730h.b();
        this.f9729g.b();
        this.f9733k.b();
    }

    @NonNull
    public ArrayPool e() {
        return this.f9733k;
    }

    @NonNull
    public BitmapPool f() {
        return this.f9729g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityMonitorFactory g() {
        return this.f9735m;
    }

    @NonNull
    public Context h() {
        return this.f9731i.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public GlideContext i() {
        return this.f9731i;
    }

    @NonNull
    public Registry j() {
        return this.f9732j;
    }

    @NonNull
    public RequestManagerRetriever k() {
        return this.f9734l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(RequestManager requestManager) {
        synchronized (this.f9736n) {
            if (!this.f9736n.contains(requestManager)) {
                this.f9736n.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i8) {
        r(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(@NonNull Target<?> target) {
        synchronized (this.f9736n) {
            for (RequestManager requestManager : this.f9736n) {
                if (requestManager.z(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i8) {
        Util.b();
        synchronized (this.f9736n) {
            for (RequestManager requestManager : this.f9736n) {
                requestManager.onTrimMemory(i8);
            }
        }
        this.f9730h.a(i8);
        this.f9729g.a(i8);
        this.f9733k.a(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(RequestManager requestManager) {
        synchronized (this.f9736n) {
            if (this.f9736n.contains(requestManager)) {
                this.f9736n.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
