package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ViewGroup.kt */
/* loaded from: classes.dex */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private int f5982f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ ViewGroup f5983g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f5983g = viewGroup;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    /* renamed from: b */
    public View next() {
        ViewGroup viewGroup = this.f5983g;
        int i8 = this.f5982f;
        this.f5982f = i8 + 1;
        View childAt = viewGroup.getChildAt(i8);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super View> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        if (this.f5982f < this.f5983g.getChildCount()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        ViewGroup viewGroup = this.f5983g;
        int i8 = this.f5982f - 1;
        this.f5982f = i8;
        viewGroup.removeViewAt(i8);
    }
}
