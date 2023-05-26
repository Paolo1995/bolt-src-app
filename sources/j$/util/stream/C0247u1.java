package j$.util.stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: j$.util.stream.u1  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0247u1 extends AbstractC0251v1 {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f50685c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f50686d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0247u1(E0 e02, Object obj) {
        this(e02, obj, 0);
        this.f50685c = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0247u1(F0 f02, Object obj, int i8) {
        super(f02);
        this.f50685c = i8;
        this.f50686d = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0247u1(F0 f02, Object[] objArr) {
        this(f02, objArr, 1);
        this.f50685c = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0247u1(C0247u1 c0247u1, E0 e02, int i8) {
        super(c0247u1, e02, i8);
        this.f50685c = 0;
        this.f50686d = c0247u1.f50686d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0247u1(C0247u1 c0247u1, F0 f02, int i8) {
        super(c0247u1, f02, i8);
        this.f50685c = 1;
        this.f50686d = (Object[]) c0247u1.f50686d;
    }

    @Override // j$.util.stream.AbstractC0251v1
    final void a() {
        switch (this.f50685c) {
            case 0:
                ((E0) this.f50693a).c(this.f50694b, this.f50686d);
                return;
            default:
                this.f50693a.i((Object[]) this.f50686d, this.f50694b);
                return;
        }
    }

    @Override // j$.util.stream.AbstractC0251v1
    final C0247u1 b(int i8, int i9) {
        switch (this.f50685c) {
            case 0:
                return new C0247u1(this, ((E0) this.f50693a).a(i8), i9);
            default:
                return new C0247u1(this, this.f50693a.a(i8), i9);
        }
    }
}
