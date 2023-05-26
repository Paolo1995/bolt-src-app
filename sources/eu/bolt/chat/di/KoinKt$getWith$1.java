package eu.bolt.chat.di;

import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;

/* compiled from: Koin.kt */
/* loaded from: classes5.dex */
public final class KoinKt$getWith$1 extends Lambda implements Function0<ParametersHolder> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Object[] f39083f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KoinKt$getWith$1(Object[] objArr) {
        super(0);
        this.f39083f = objArr;
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: b */
    public final ParametersHolder invoke() {
        Object[] objArr = this.f39083f;
        return ParametersHolderKt.b(Arrays.copyOf(objArr, objArr.length));
    }
}
