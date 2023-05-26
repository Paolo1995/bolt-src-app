package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.inbox.CTInboxListViewFragment;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class CTInboxActivity extends FragmentActivity implements CTInboxListViewFragment.InboxListener {

    /* renamed from: l  reason: collision with root package name */
    public static int f11495l;

    /* renamed from: f  reason: collision with root package name */
    CTInboxTabAdapter f11496f;

    /* renamed from: g  reason: collision with root package name */
    CTInboxStyleConfig f11497g;

    /* renamed from: h  reason: collision with root package name */
    TabLayout f11498h;

    /* renamed from: i  reason: collision with root package name */
    ViewPager f11499i;

    /* renamed from: j  reason: collision with root package name */
    private CleverTapInstanceConfig f11500j;

    /* renamed from: k  reason: collision with root package name */
    private WeakReference<InboxActivityListener> f11501k;

    /* loaded from: classes.dex */
    public interface InboxActivityListener {
        void a(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle);

        void b(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap);
    }

    private String N() {
        return this.f11500j.c() + ":CT_INBOX_LIST_VIEW_FRAGMENT";
    }

    void L(Bundle bundle, CTInboxMessage cTInboxMessage, HashMap<String, String> hashMap) {
        InboxActivityListener O = O();
        if (O != null) {
            O.b(this, cTInboxMessage, bundle, hashMap);
        }
    }

    void M(Bundle bundle, CTInboxMessage cTInboxMessage) {
        InboxActivityListener O = O();
        if (O != null) {
            O.a(this, cTInboxMessage, bundle);
        }
    }

    InboxActivityListener O() {
        InboxActivityListener inboxActivityListener;
        try {
            inboxActivityListener = this.f11501k.get();
        } catch (Throwable unused) {
            inboxActivityListener = null;
        }
        if (inboxActivityListener == null) {
            this.f11500j.n().s(this.f11500j.c(), "InboxActivityListener is null for notification inbox ");
        }
        return inboxActivityListener;
    }

    void P(InboxActivityListener inboxActivityListener) {
        this.f11501k = new WeakReference<>(inboxActivityListener);
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxListViewFragment.InboxListener
    public void i(Context context, CTInboxMessage cTInboxMessage, Bundle bundle) {
        M(bundle, cTInboxMessage);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.f11497g = (CTInboxStyleConfig) extras.getParcelable("styleConfig");
                Bundle bundle2 = extras.getBundle("configBundle");
                if (bundle2 != null) {
                    this.f11500j = (CleverTapInstanceConfig) bundle2.getParcelable("config");
                }
                CleverTapAPI K = CleverTapAPI.K(getApplicationContext(), this.f11500j);
                if (K != null) {
                    P(K);
                }
                f11495l = getResources().getConfiguration().orientation;
                setContentView(R$layout.inbox_activity);
                Toolbar toolbar = (Toolbar) findViewById(R$id.J0);
                toolbar.setTitle(this.f11497g.e());
                toolbar.setTitleTextColor(Color.parseColor(this.f11497g.f()));
                toolbar.setBackgroundColor(Color.parseColor(this.f11497g.d()));
                Drawable f8 = ResourcesCompat.f(getResources(), R$drawable.ct_ic_arrow_back_white_24dp, null);
                if (f8 != null) {
                    f8.setColorFilter(Color.parseColor(this.f11497g.a()), PorterDuff.Mode.SRC_IN);
                }
                toolbar.setNavigationIcon(f8);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inbox.CTInboxActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CTInboxActivity.this.finish();
                    }
                });
                LinearLayout linearLayout = (LinearLayout) findViewById(R$id.inbox_linear_layout);
                linearLayout.setBackgroundColor(Color.parseColor(this.f11497g.c()));
                this.f11498h = (TabLayout) linearLayout.findViewById(R$id.tab_layout);
                this.f11499i = (ViewPager) linearLayout.findViewById(R$id.view_pager);
                TextView textView = (TextView) findViewById(R$id.no_message_view);
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("config", this.f11500j);
                bundle3.putParcelable("styleConfig", this.f11497g);
                int i8 = 0;
                if (!this.f11497g.p()) {
                    this.f11499i.setVisibility(8);
                    this.f11498h.setVisibility(8);
                    ((FrameLayout) findViewById(R$id.list_view_fragment)).setVisibility(0);
                    if (K != null && K.B() == 0) {
                        textView.setBackgroundColor(Color.parseColor(this.f11497g.c()));
                        textView.setVisibility(0);
                        textView.setText(this.f11497g.g());
                        textView.setTextColor(Color.parseColor(this.f11497g.h()));
                        return;
                    }
                    textView.setVisibility(8);
                    for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                        if (fragment.getTag() != null && !fragment.getTag().equalsIgnoreCase(N())) {
                            i8 = 1;
                        }
                    }
                    if (i8 == 0) {
                        Fragment cTInboxListViewFragment = new CTInboxListViewFragment();
                        cTInboxListViewFragment.setArguments(bundle3);
                        getSupportFragmentManager().beginTransaction().add(R$id.list_view_fragment, cTInboxListViewFragment, N()).commit();
                        return;
                    }
                    return;
                }
                this.f11499i.setVisibility(0);
                ArrayList<String> n8 = this.f11497g.n();
                this.f11496f = new CTInboxTabAdapter(getSupportFragmentManager(), n8.size() + 1);
                this.f11498h.setVisibility(0);
                this.f11498h.setTabGravity(0);
                this.f11498h.setTabMode(1);
                this.f11498h.setSelectedTabIndicatorColor(Color.parseColor(this.f11497g.j()));
                this.f11498h.Q(Color.parseColor(this.f11497g.o()), Color.parseColor(this.f11497g.i()));
                this.f11498h.setBackgroundColor(Color.parseColor(this.f11497g.l()));
                Bundle bundle4 = (Bundle) bundle3.clone();
                bundle4.putInt("position", 0);
                CTInboxListViewFragment cTInboxListViewFragment2 = new CTInboxListViewFragment();
                cTInboxListViewFragment2.setArguments(bundle4);
                this.f11496f.a(cTInboxListViewFragment2, this.f11497g.b(), 0);
                while (i8 < n8.size()) {
                    String str = n8.get(i8);
                    i8++;
                    Bundle bundle5 = (Bundle) bundle3.clone();
                    bundle5.putInt("position", i8);
                    bundle5.putString("filter", str);
                    CTInboxListViewFragment cTInboxListViewFragment3 = new CTInboxListViewFragment();
                    cTInboxListViewFragment3.setArguments(bundle5);
                    this.f11496f.a(cTInboxListViewFragment3, str, i8);
                    this.f11499i.setOffscreenPageLimit(i8);
                }
                this.f11499i.setAdapter(this.f11496f);
                this.f11496f.notifyDataSetChanged();
                this.f11499i.c(new TabLayout.TabLayoutOnPageChangeListener(this.f11498h));
                this.f11498h.h(new TabLayout.OnTabSelectedListener() { // from class: com.clevertap.android.sdk.inbox.CTInboxActivity.2
                    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                    public void a(TabLayout.Tab tab) {
                        CTInboxListViewFragment cTInboxListViewFragment4 = (CTInboxListViewFragment) CTInboxActivity.this.f11496f.getItem(tab.g());
                        if (cTInboxListViewFragment4.I() != null) {
                            cTInboxListViewFragment4.I().J1();
                        }
                    }

                    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                    public void b(TabLayout.Tab tab) {
                        CTInboxListViewFragment cTInboxListViewFragment4 = (CTInboxListViewFragment) CTInboxActivity.this.f11496f.getItem(tab.g());
                        if (cTInboxListViewFragment4.I() != null) {
                            cTInboxListViewFragment4.I().I1();
                        }
                    }

                    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                    public void c(TabLayout.Tab tab) {
                    }
                });
                this.f11498h.setupWithViewPager(this.f11499i);
                return;
            }
            throw new IllegalArgumentException();
        } catch (Throwable th) {
            Logger.q("Cannot find a valid notification inbox bundle to show!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f11497g.p()) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof CTInboxListViewFragment) {
                    Logger.n("Removing fragment - " + fragment.toString());
                    getSupportFragmentManager().getFragments().remove(fragment);
                }
            }
        }
        super.onDestroy();
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxListViewFragment.InboxListener
    public void w(Context context, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap) {
        L(bundle, cTInboxMessage, hashMap);
    }
}
