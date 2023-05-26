package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CTCarouselViewPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<String> f11481a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11482b;

    /* renamed from: c  reason: collision with root package name */
    private final CTInboxMessage f11483c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f11484d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout.LayoutParams f11485e;

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<CTInboxListViewFragment> f11486f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11487g;

    /* renamed from: h  reason: collision with root package name */
    private View f11488h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTCarouselViewPagerAdapter(Context context, CTInboxListViewFragment cTInboxListViewFragment, CTInboxMessage cTInboxMessage, LinearLayout.LayoutParams layoutParams, int i8) {
        this.f11482b = context;
        this.f11486f = new WeakReference<>(cTInboxListViewFragment);
        this.f11481a = cTInboxMessage.c();
        this.f11485e = layoutParams;
        this.f11483c = cTInboxMessage;
        this.f11487g = i8;
    }

    void b(ImageView imageView, View view, final int i8, ViewGroup viewGroup) {
        imageView.setVisibility(0);
        try {
            Glide.t(imageView.getContext()).s(this.f11481a.get(i8)).a(new RequestOptions().a0(Utils.s(this.f11482b, "ct_image")).j(Utils.s(this.f11482b, "ct_image"))).B0(imageView);
        } catch (NoSuchMethodError unused) {
            Logger.a("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
            Glide.t(imageView.getContext()).s(this.f11481a.get(i8)).B0(imageView);
        }
        viewGroup.addView(view, this.f11485e);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inbox.CTCarouselViewPagerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CTInboxListViewFragment c8 = CTCarouselViewPagerAdapter.this.c();
                if (c8 != null) {
                    c8.K(CTCarouselViewPagerAdapter.this.f11487g, i8);
                }
            }
        });
    }

    CTInboxListViewFragment c() {
        return this.f11486f.get();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i8, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11481a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i8) {
        LayoutInflater layoutInflater = (LayoutInflater) this.f11482b.getSystemService("layout_inflater");
        this.f11484d = layoutInflater;
        this.f11488h = layoutInflater.inflate(R$layout.inbox_carousel_image_layout, viewGroup, false);
        try {
            if (this.f11483c.h().equalsIgnoreCase("l")) {
                b((ImageView) this.f11488h.findViewById(R$id.W), this.f11488h, i8, viewGroup);
            } else if (this.f11483c.h().equalsIgnoreCase("p")) {
                b((ImageView) this.f11488h.findViewById(R$id.squareImageView), this.f11488h, i8, viewGroup);
            }
        } catch (NoClassDefFoundError unused) {
            Logger.a("CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info");
        }
        return this.f11488h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
