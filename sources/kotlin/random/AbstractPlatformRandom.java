package kotlin.random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes5.dex */
public abstract class AbstractPlatformRandom extends Random {
    @Override // kotlin.random.Random
    public int b(int i8) {
        return RandomKt.f(i().nextInt(), i8);
    }

    @Override // kotlin.random.Random
    public float c() {
        return i().nextFloat();
    }

    @Override // kotlin.random.Random
    public int d() {
        return i().nextInt();
    }

    @Override // kotlin.random.Random
    public int e(int i8) {
        return i().nextInt(i8);
    }

    @Override // kotlin.random.Random
    public long g() {
        return i().nextLong();
    }

    public abstract java.util.Random i();
}
