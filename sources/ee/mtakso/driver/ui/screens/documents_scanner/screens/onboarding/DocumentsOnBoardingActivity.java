package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingActivity;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.AssertUtils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentsOnBoardingActivity.kt */
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingActivity extends BaseDynamicTranslatedMvvmActivity<DocumentsOnBoardingViewModel> {

    /* renamed from: r  reason: collision with root package name */
    public static final Companion f28440r = new Companion(null);

    /* renamed from: o  reason: collision with root package name */
    private final Lazy f28441o;

    /* renamed from: p  reason: collision with root package name */
    private FragmentStateAdapter f28442p;

    /* renamed from: q  reason: collision with root package name */
    public Map<Integer, View> f28443q = new LinkedHashMap();

    /* compiled from: DocumentsOnBoardingActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, DocumentsOnBoardingType type) {
            Intrinsics.f(context, "context");
            Intrinsics.f(type, "type");
            Intent intent = new Intent(context, DocumentsOnBoardingActivity.class);
            intent.putExtra("args.docs_flow_type", type);
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).overridePendingTransition(R.anim.slide_in, R.anim.hold);
            } else {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public DocumentsOnBoardingActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DocumentsOnBoardingViewModel>() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DocumentsOnBoardingViewModel invoke() {
                DocumentsOnBoardingActivity documentsOnBoardingActivity = DocumentsOnBoardingActivity.this;
                return (DocumentsOnBoardingViewModel) new ViewModelProvider(documentsOnBoardingActivity, documentsOnBoardingActivity.R()).a(DocumentsOnBoardingViewModel.class);
            }
        });
        this.f28441o = b8;
    }

    private final DocumentsOnBoardingType e0() {
        Serializable serializableExtra = getIntent().getSerializableExtra("args.docs_flow_type");
        if (serializableExtra instanceof DocumentsOnBoardingType) {
            return (DocumentsOnBoardingType) serializableExtra;
        }
        return null;
    }

    private final boolean g0(int i8) {
        int i9;
        FragmentStateAdapter fragmentStateAdapter = this.f28442p;
        if (fragmentStateAdapter != null) {
            i9 = fragmentStateAdapter.r();
        } else {
            i9 = 0;
        }
        if (i8 >= i9 - 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(int i8) {
        if (!g0(i8)) {
            ((RoundButton) c0(R.id.I7)).setText(R.string.documents_flow_onboarding_close);
        } else {
            ((RoundButton) c0(R.id.I7)).setText(R.string.documents_flow_onboarding_next);
        }
    }

    static /* synthetic */ void i0(DocumentsOnBoardingActivity documentsOnBoardingActivity, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = 0;
        }
        documentsOnBoardingActivity.h0(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(DocumentsOnBoardingActivity this$0, List steps) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(steps, "steps");
        this$0.l0(steps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(DocumentsOnBoardingActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        int i8 = R.id.Mc;
        if (this$0.g0(((ViewPager2) this$0.c0(i8)).getCurrentItem())) {
            ((ViewPager2) this$0.c0(i8)).j(((ViewPager2) this$0.c0(i8)).getCurrentItem() + 1, true);
        } else {
            this$0.finish();
        }
    }

    private final void l0(List<DocumentsOnBoardingStep> list) {
        this.f28442p = new DocumentsOnBoardingFragmentsAdapter(this, N(), list);
        int i8 = R.id.Mc;
        ((ViewPager2) c0(i8)).setAdapter(this.f28442p);
        new TabLayoutMediator((TabLayout) c0(R.id.tablLayout), (ViewPager2) c0(i8), new TabLayoutMediator.TabConfigurationStrategy() { // from class: j3.c
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void a(TabLayout.Tab tab, int i9) {
                DocumentsOnBoardingActivity.m0(tab, i9);
            }
        }).a();
        ((ViewPager2) c0(i8)).g(new ViewPager2.OnPageChangeCallback() { // from class: ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding.DocumentsOnBoardingActivity$onInitSteps$2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i9) {
                DocumentsOnBoardingActivity.this.h0(i9);
            }
        });
        i0(this, 0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(TabLayout.Tab tab, int i8) {
        Intrinsics.f(tab, "tab");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().X1().h(this);
    }

    public View c0(int i8) {
        Map<Integer, View> map = this.f28443q;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: f0 */
    public DocumentsOnBoardingViewModel Q() {
        return (DocumentsOnBoardingViewModel) this.f28441o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_documents_onboarding);
        setSupportActionBar((Toolbar) c0(R.id.kc));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.w("");
        }
        Q().D().i(this, new Observer() { // from class: j3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DocumentsOnBoardingActivity.j0(DocumentsOnBoardingActivity.this, (List) obj);
            }
        });
        DocumentsOnBoardingType e02 = e0();
        if (e02 == null) {
            AssertUtils.a("Cannot be launched with unkown or empty type");
            finish();
            return;
        }
        Q().E(e02);
        ((RoundButton) c0(R.id.I7)).setOnClickListener(new View.OnClickListener() { // from class: j3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocumentsOnBoardingActivity.k0(DocumentsOnBoardingActivity.this, view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.f(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
