package kotlinx.serialization.descriptors;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SerialDescriptor.kt */
/* loaded from: classes5.dex */
public final class SerialDescriptorKt$elementDescriptors$1$1 implements Iterator<SerialDescriptor>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private int f52117f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ SerialDescriptor f52118g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SerialDescriptorKt$elementDescriptors$1$1(SerialDescriptor serialDescriptor) {
        this.f52118g = serialDescriptor;
        this.f52117f = serialDescriptor.e();
    }

    @Override // java.util.Iterator, j$.util.Iterator
    /* renamed from: b */
    public SerialDescriptor next() {
        SerialDescriptor serialDescriptor = this.f52118g;
        int e8 = serialDescriptor.e();
        int i8 = this.f52117f;
        this.f52117f = i8 - 1;
        return serialDescriptor.h(e8 - i8);
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super SerialDescriptor> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        if (this.f52117f > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
