package j$.util.function;

/* loaded from: classes2.dex */
public interface ToDoubleFunction<T> {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToDoubleFunction {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ java.util.function.ToDoubleFunction f50301a;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToDoubleFunction toDoubleFunction) {
            this.f50301a = toDoubleFunction;
        }

        public static /* synthetic */ ToDoubleFunction convert(java.util.function.ToDoubleFunction toDoubleFunction) {
            if (toDoubleFunction == null) {
                return null;
            }
            return toDoubleFunction instanceof H0 ? ((H0) toDoubleFunction).f50288a : new VivifiedWrapper(toDoubleFunction);
        }

        @Override // j$.util.function.ToDoubleFunction
        public final /* synthetic */ double applyAsDouble(Object obj) {
            return this.f50301a.applyAsDouble(obj);
        }
    }

    double applyAsDouble(Object obj);
}
