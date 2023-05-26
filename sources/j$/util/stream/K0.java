package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class K0 extends M0 {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f50431k = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(int i8, Spliterator spliterator, AbstractC0254w0 abstractC0254w0) {
        super(abstractC0254w0, spliterator, new C0166b(27), new C0166b(28));
        if (i8 == 1) {
            super(abstractC0254w0, spliterator, new C0166b(29), new L0(0));
        } else if (i8 != 2) {
        } else {
            super(abstractC0254w0, spliterator, new L0(1), new L0(2));
        }
    }

    public /* synthetic */ K0(Spliterator spliterator, IntFunction intFunction, AbstractC0254w0 abstractC0254w0) {
        super(abstractC0254w0, spliterator, new C0161a(2, intFunction), new L0(3));
    }
}
