package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f10064a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends ResourceDecoder<DataType, ResourceType>> f10065b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<ResourceType, Transcode> f10066c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f10067d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10068e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> a(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools$Pool<List<Throwable>> pools$Pool) {
        this.f10064a = cls;
        this.f10065b = list;
        this.f10066c = resourceTranscoder;
        this.f10067d = pools$Pool;
        this.f10068e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> b(DataRewinder<DataType> dataRewinder, int i8, int i9, @NonNull Options options) throws GlideException {
        List<Throwable> list = (List) Preconditions.d(this.f10067d.b());
        try {
            return c(dataRewinder, i8, i9, options, list);
        } finally {
            this.f10067d.a(list);
        }
    }

    @NonNull
    private Resource<ResourceType> c(DataRewinder<DataType> dataRewinder, int i8, int i9, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.f10065b.size();
        Resource<ResourceType> resource = null;
        for (int i10 = 0; i10 < size; i10++) {
            ResourceDecoder<DataType, ResourceType> resourceDecoder = this.f10065b.get(i10);
            try {
                if (resourceDecoder.a(dataRewinder.a(), options)) {
                    resource = resourceDecoder.b(dataRewinder.a(), i8, i9, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e8) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder, e8);
                }
                list.add(e8);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f10068e, new ArrayList(list));
    }

    public Resource<Transcode> a(DataRewinder<DataType> dataRewinder, int i8, int i9, @NonNull Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.f10066c.a(decodeCallback.a(b(dataRewinder, i8, i9, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f10064a + ", decoders=" + this.f10065b + ", transcoder=" + this.f10066c + '}';
    }
}
