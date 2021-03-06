package com.yoloo.android.feature.recommenduser;

import android.content.Context;
import com.airbnb.epoxy.Typed2EpoxyController;
import com.annimon.stream.Stream;
import com.yoloo.android.data.model.AccountRealm;
import com.yoloo.android.feature.search.OnFollowClickListener;
import com.yoloo.android.feature.search.UserModel_;
import com.yoloo.android.util.glide.transfromation.CropCircleTransformation;
import java.util.ArrayList;
import java.util.List;

public class RecommendUserEpoxyController extends Typed2EpoxyController<List<AccountRealm>, Void> {

  private final CropCircleTransformation cropCircleTransformation;

  private OnFollowClickListener onFollowClickListener;

  private List<AccountRealm> models;

  public RecommendUserEpoxyController(Context context) {
    models = new ArrayList<>();
    cropCircleTransformation = new CropCircleTransformation(context);
  }

  public void setOnFollowClickListener(OnFollowClickListener onFollowClickListener) {
    this.onFollowClickListener = onFollowClickListener;
  }

  @Override
  public void setData(List<AccountRealm> models, Void data2) {
    this.models = models;
    super.setData(models, data2);
  }

  @Override
  protected void buildModels(List<AccountRealm> accounts, Void aVoid) {
    Stream
        .of(accounts)
        .forEach(account -> new UserModel_()
            .id(account.getId())
            .account(account)
            .onFollowClickListener(onFollowClickListener)
            .cropCircleTransformation(cropCircleTransformation)
            .addTo(this));
  }

  public void remove(AccountRealm account) {
    models.remove(account);
    setData(models, null);
  }
}
