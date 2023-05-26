package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f10155a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools$Pool<List<Throwable>> f10156b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> f10157c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10158d;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools$Pool<List<Throwable>> pools$Pool) {
        this.f10155a = cls;
        this.f10156b = pools$Pool;
        this.f10157c = (List) Preconditions.c(list);
        this.f10158d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<Transcode> b(DataRewinder<Data> dataRewinder, @NonNull Options options, int i8, int i9, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        int size = this.f10157c.size();
        Resource<Transcode> resource = null;
        for (int i10 = 0; i10 < size; i10++) {
            try {
                resource = this.f10157c.get(i10).a(dataRewinder, i8, i9, options, decodeCallback);
            } catch (GlideException e8) {
                list.add(e8);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.f10158d, new ArrayList(list));
    }

    public Resource<Transcode> a(DataRewinder<Data> dataRewinder, @NonNull Options options, int i8, int i9, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List<Throwable> list = (List) Preconditions.d(this.f10156b.b());
        try {
            return b(dataRewinder, options, i8, i9, decodeCallback, list);
        } finally {
            this.f10156b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f10157c.toArray()) + '}';
    }
}
