package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z3 extends V2 {
    z3(AbstractC0254w0 abstractC0254w0, Spliterator spliterator, boolean z7) {
        super(abstractC0254w0, spliterator, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z3(AbstractC0254w0 abstractC0254w0, C0161a c0161a, boolean z7) {
        super(abstractC0254w0, c0161a, z7);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.f50523h != null || this.f50524i) {
            do {
            } while (tryAdvance(consumer));
            return;
        }
        consumer.getClass();
        g();
        this.f50517b.v1(this.f50519d, new y3(consumer, 1));
        this.f50524i = true;
    }

    @Override // j$.util.stream.V2
    final void h() {
        Q2 q22 = new Q2();
        this.f50523h = q22;
        this.f50520e = this.f50517b.w1(new y3(q22, 0));
        this.f50521f = new C0161a(7, this);
    }

    @Override // j$.util.stream.V2
    final V2 j(Spliterator spliterator) {
        return new z3(this.f50517b, spliterator, this.f50516a);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        consumer.getClass();
        boolean e8 = e();
        if (e8) {
            Q2 q22 = (Q2) this.f50523h;
            long j8 = this.f50522g;
            if (q22.f50568c != 0) {
                if (j8 < q22.count()) {
                    for (int i8 = 0; i8 <= q22.f50568c; i8++) {
                        long j9 = q22.f50569d[i8];
                        Object[] objArr = q22.f50468f[i8];
                        if (j8 < objArr.length + j9) {
                            obj = objArr[(int) (j8 - j9)];
                        }
                    }
                    throw new IndexOutOfBoundsException(Long.toString(j8));
                }
                throw new IndexOutOfBoundsException(Long.toString(j8));
            } else if (j8 >= q22.f50567b) {
                throw new IndexOutOfBoundsException(Long.toString(j8));
            } else {
                obj = q22.f50467e[(int) j8];
            }
            consumer.accept(obj);
        }
        return e8;
    }
}
