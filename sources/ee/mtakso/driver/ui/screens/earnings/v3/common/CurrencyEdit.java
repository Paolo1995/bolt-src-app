package ee.mtakso.driver.ui.screens.earnings.v3.common;

import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyValueFormat;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import java.math.BigDecimal;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CurrencyEdit.kt */
/* loaded from: classes3.dex */
public final class CurrencyEdit {

    /* renamed from: a  reason: collision with root package name */
    private final TextInputView f29000a;

    /* renamed from: b  reason: collision with root package name */
    private final CurrencyValueFormat f29001b;

    /* renamed from: c  reason: collision with root package name */
    private CurrencyConfig f29002c;

    /* renamed from: d  reason: collision with root package name */
    private BigDecimal f29003d;

    /* renamed from: e  reason: collision with root package name */
    private Function1<? super BigDecimal, Unit> f29004e;

    /* compiled from: CurrencyEdit.kt */
    /* renamed from: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, CurrencyEdit.class, "onChanged", "onChanged(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            j(str);
            return Unit.f50853a;
        }

        public final void j(String p02) {
            Intrinsics.f(p02, "p0");
            ((CurrencyEdit) this.f50989g).g(p02);
        }
    }

    public CurrencyEdit(TextInputView inputView, CurrencyValueFormat format) {
        Intrinsics.f(inputView, "inputView");
        Intrinsics.f(format, "format");
        this.f29000a = inputView;
        this.f29001b = format;
        this.f29002c = new CurrencyConfig(null, false, 3, null);
        this.f29003d = BigDecimal.ZERO;
        this.f29004e = new Function1<BigDecimal, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$callback$1
            public final void b(BigDecimal bigDecimal) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BigDecimal bigDecimal) {
                b(bigDecimal);
                return Unit.f50853a;
            }
        };
        inputView.setOnTextChangeListener(new AnonymousClass1(this));
    }

    private final void e(Function0<Unit> function0) {
        this.f29000a.setOnTextChangeListener(new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$doSilently$1
            public final void b(String it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        });
        function0.invoke();
        this.f29000a.setOnTextChangeListener(new CurrencyEdit$doSilently$2(this));
    }

    private final void f(final String str) {
        int b02;
        final String a8 = this.f29002c.a();
        b02 = StringsKt__StringsKt.b0(str, a8, 0, false, 6, null);
        if (b02 > -1) {
            return;
        }
        e(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$insertCurrencyAndSet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final void b() {
                CurrencyConfig currencyConfig;
                TextInputView textInputView;
                TextInputView textInputView2;
                TextInputView textInputView3;
                TextInputView textInputView4;
                int b03;
                currencyConfig = CurrencyEdit.this.f29002c;
                if (currencyConfig.b()) {
                    String str2 = str + a8;
                    textInputView3 = CurrencyEdit.this.f29000a;
                    textInputView3.setText(str2);
                    textInputView4 = CurrencyEdit.this.f29000a;
                    b03 = StringsKt__StringsKt.b0(str2, a8, 0, false, 6, null);
                    textInputView4.setSelection(b03);
                    return;
                }
                String str3 = a8 + str;
                textInputView = CurrencyEdit.this.f29000a;
                textInputView.setText(str3);
                textInputView2 = CurrencyEdit.this.f29000a;
                textInputView2.setSelection(str3.length());
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str) {
        String F;
        F = StringsKt__StringsJVMKt.F(str, this.f29002c.a(), "", false, 4, null);
        CurrencyValueFormat.Result b8 = this.f29001b.b(F);
        if (b8 instanceof CurrencyValueFormat.Empty) {
            e(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$onChanged$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    TextInputView textInputView;
                    textInputView = CurrencyEdit.this.f29000a;
                    textInputView.setText("");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
            this.f29003d = null;
            this.f29004e.invoke(null);
        } else if (b8 instanceof CurrencyValueFormat.Failed) {
            h();
        } else if (b8 instanceof CurrencyValueFormat.Success) {
            CurrencyValueFormat.Success success = (CurrencyValueFormat.Success) b8;
            f(success.a());
            if (!Intrinsics.a(this.f29003d, success.b())) {
                BigDecimal b9 = success.b();
                this.f29003d = b9;
                this.f29004e.invoke(b9);
            }
        }
    }

    private final void h() {
        BigDecimal bigDecimal = this.f29003d;
        if (bigDecimal != null) {
            f(this.f29001b.a(bigDecimal));
        } else {
            e(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$restoreValue$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    TextInputView textInputView;
                    textInputView = CurrencyEdit.this.f29000a;
                    textInputView.setText("");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        }
        this.f29004e.invoke(bigDecimal);
    }

    public final void d(BigDecimal bigDecimal, CurrencyConfig currencyConfig) {
        Intrinsics.f(currencyConfig, "currencyConfig");
        if (Intrinsics.a(bigDecimal, this.f29003d) && Intrinsics.a(currencyConfig, this.f29002c)) {
            return;
        }
        this.f29002c = currencyConfig;
        this.f29003d = bigDecimal;
        if (bigDecimal != null) {
            f(this.f29001b.a(bigDecimal));
        } else {
            e(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit$bind$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final void b() {
                    TextInputView textInputView;
                    textInputView = CurrencyEdit.this.f29000a;
                    textInputView.setText("");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        }
    }

    public final void i(Function1<? super BigDecimal, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f29004e = function1;
    }
}
