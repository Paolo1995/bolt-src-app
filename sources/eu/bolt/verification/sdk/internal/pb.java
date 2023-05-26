package eu.bolt.verification.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class pb<InputDeps, OutputDeps> {

    /* renamed from: a  reason: collision with root package name */
    private OutputDeps f44527a;

    /* renamed from: b  reason: collision with root package name */
    protected InputDeps f44528b;

    protected abstract OutputDeps a();

    public final synchronized OutputDeps b() {
        OutputDeps outputdeps;
        outputdeps = this.f44527a;
        if (outputdeps == null) {
            outputdeps = a();
            this.f44527a = outputdeps;
        }
        return outputdeps;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final InputDeps c() {
        InputDeps inputdeps = this.f44528b;
        if (inputdeps != null) {
            return inputdeps;
        }
        Intrinsics.w("inputDeps");
        return (InputDeps) Unit.f50853a;
    }
}
