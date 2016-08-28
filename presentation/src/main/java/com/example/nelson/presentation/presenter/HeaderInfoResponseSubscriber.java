package com.example.nelson.presentation.presenter;

import android.util.Log;

import com.example.nelson.domain.HeaderInfo;
import com.example.nelson.domain.interactor.DefaultSubscriber;
import com.example.nelson.presentation.mapper.HeaderInfoModelDataMapper;
import com.example.nelson.presentation.model.HeaderInfoModel;

/**
 * Created by Nelson on 14/08/2016.
 */
public class HeaderInfoResponseSubscriber extends DefaultSubscriber<HeaderInfo> {

  private MainPresenter mainPresenter;
  private HeaderInfoModelDataMapper headerInfoModelDataMapper;

  public HeaderInfoResponseSubscriber(MainPresenter mainPresenter,
                                      HeaderInfoModelDataMapper headerInfoModelDataMapper) {
    this.mainPresenter = mainPresenter;
    this.headerInfoModelDataMapper = headerInfoModelDataMapper;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onCompleted() {
    Log.d("NELSON", "GameDataResponseSubscriber onCompleted");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onError(Throwable e) {
    Log.e("NELSON", e.getLocalizedMessage(), e);
    //view.showRxFailure(e);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onNext(HeaderInfo headerInfo) {
    //view.showRxResults(gameDataResponse);
    mainPresenter.updateActivityWithHeaderInfo(headerInfoModelDataMapper.transform(headerInfo));
  }
}