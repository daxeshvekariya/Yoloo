package com.yoloo.android.feature.photo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.yoloo.android.R;
import com.yoloo.android.feature.base.BaseController;
import com.yoloo.android.feature.ui.widget.xuanimageview.XuanImageView;
import com.yoloo.android.util.BundleBuilder;

public class PhotoController extends BaseController {

  private static final String KEY_PHOTO_URL = "PHOTO_URL";

  @BindView(R.id.iv_photo)
  XuanImageView ivPhoto;

  public PhotoController(Bundle args) {
    super(args);
  }

  public static PhotoController create(String photoUrl) {
    final Bundle bundle = new BundleBuilder()
        .putString(KEY_PHOTO_URL, photoUrl)
        .build();

    return new PhotoController(bundle);
  }

  @Override
  protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
    return inflater.inflate(R.layout.controller_photo, container, false);
  }

  @Override
  protected void onViewCreated(@NonNull View view) {
    super.onViewCreated(view);

    Glide.with(getActivity())
        .load(getArgs().getString(KEY_PHOTO_URL))
        .into(ivPhoto);
  }
}