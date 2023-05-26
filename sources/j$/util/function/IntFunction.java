package j$.util.function;

/* loaded from: classes2.dex */
public interface IntFunction<R> {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntFunction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ java.util.function.IntFunction f50291a;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntFunction intFunction) {
            this.f50291a = intFunction;
        }

        public static /* synthetic */ IntFunction convert(java.util.function.IntFunction intFunction) {
            if (intFunction == null) {
                return null;
            }
            return intFunction instanceof K ? ((K) intFunction).f50293a : new VivifiedWrapper(intFunction);
        }

        @Override // j$.util.function.IntFunction
        public final /* synthetic */ Object apply(int i8) {
            return this.f50291a.apply(i8);
        }
    }

    Object apply(int i8);
}
