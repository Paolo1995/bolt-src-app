package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {

    /* renamed from: a  reason: collision with root package name */
    private float f4462a;

    /* renamed from: b  reason: collision with root package name */
    private float f4463b;

    /* renamed from: c  reason: collision with root package name */
    private float f4464c;

    /* renamed from: d  reason: collision with root package name */
    private float f4465d;

    /* renamed from: e  reason: collision with root package name */
    private float f4466e;

    /* renamed from: f  reason: collision with root package name */
    private float f4467f;

    /* renamed from: g  reason: collision with root package name */
    private float f4468g;

    /* renamed from: h  reason: collision with root package name */
    private float f4469h;

    /* renamed from: i  reason: collision with root package name */
    private float f4470i;

    /* renamed from: j  reason: collision with root package name */
    private int f4471j;

    /* renamed from: l  reason: collision with root package name */
    private float f4473l;

    /* renamed from: m  reason: collision with root package name */
    private float f4474m;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4472k = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f4475n = false;

    private float c(float f8) {
        this.f4475n = false;
        float f9 = this.f4465d;
        if (f8 <= f9) {
            float f10 = this.f4462a;
            return (f10 * f8) + ((((this.f4463b - f10) * f8) * f8) / (f9 * 2.0f));
        }
        int i8 = this.f4471j;
        if (i8 == 1) {
            return this.f4468g;
        }
        float f11 = f8 - f9;
        float f12 = this.f4466e;
        if (f11 < f12) {
            float f13 = this.f4468g;
            float f14 = this.f4463b;
            return f13 + (f14 * f11) + ((((this.f4464c - f14) * f11) * f11) / (f12 * 2.0f));
        } else if (i8 == 2) {
            return this.f4469h;
        } else {
            float f15 = f11 - f12;
            float f16 = this.f4467f;
            if (f15 <= f16) {
                float f17 = this.f4469h;
                float f18 = this.f4464c;
                return (f17 + (f18 * f15)) - (((f18 * f15) * f15) / (f16 * 2.0f));
            }
            this.f4475n = true;
            return this.f4470i;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float a() {
        if (this.f4472k) {
            return -d(this.f4474m);
        }
        return d(this.f4474m);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean b() {
        if (a() < 1.0E-5f && Math.abs(this.f4470i - this.f4474m) < 1.0E-5f) {
            return true;
        }
        return false;
    }

    public float d(float f8) {
        float f9 = this.f4465d;
        if (f8 <= f9) {
            float f10 = this.f4462a;
            return f10 + (((this.f4463b - f10) * f8) / f9);
        }
        int i8 = this.f4471j;
        if (i8 == 1) {
            return 0.0f;
        }
        float f11 = f8 - f9;
        float f12 = this.f4466e;
        if (f11 < f12) {
            float f13 = this.f4463b;
            return f13 + (((this.f4464c - f13) * f11) / f12);
        } else if (i8 == 2) {
            return this.f4469h;
        } else {
            float f14 = f11 - f12;
            float f15 = this.f4467f;
            if (f14 < f15) {
                float f16 = this.f4464c;
                return f16 - ((f14 * f16) / f15);
            }
            return this.f4470i;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f8) {
        float c8 = c(f8);
        this.f4474m = f8;
        if (this.f4472k) {
            return this.f4473l - c8;
        }
        return this.f4473l + c8;
    }
}
