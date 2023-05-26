package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class TransportFactoryImpl implements TransportFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Encoding> f12106a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f12107b;

    /* renamed from: c  reason: collision with root package name */
    private final TransportInternal f12108c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportFactoryImpl(Set<Encoding> set, TransportContext transportContext, TransportInternal transportInternal) {
        this.f12106a = set;
        this.f12107b = transportContext;
        this.f12108c = transportInternal;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public <T> Transport<T> a(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
        if (this.f12106a.contains(encoding)) {
            return new TransportImpl(this.f12107b, str, encoding, transformer, this.f12108c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, this.f12106a));
    }
}
