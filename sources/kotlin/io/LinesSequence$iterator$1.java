package kotlin.io;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ReadWrite.kt */
/* loaded from: classes5.dex */
public final class LinesSequence$iterator$1 implements Iterator<String>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private String f50972f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f50973g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ LinesSequence f50974h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinesSequence$iterator$1(LinesSequence linesSequence) {
        this.f50974h = linesSequence;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    /* renamed from: b */
    public String next() {
        if (hasNext()) {
            String str = this.f50972f;
            this.f50972f = null;
            Intrinsics.c(str);
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super String> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        BufferedReader bufferedReader;
        if (this.f50972f == null && !this.f50973g) {
            bufferedReader = this.f50974h.f50971a;
            String readLine = bufferedReader.readLine();
            this.f50972f = readLine;
            if (readLine == null) {
                this.f50973g = true;
            }
        }
        if (this.f50972f != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
