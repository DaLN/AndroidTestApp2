package com.example.nelson.presentation.model;

import com.example.nelson.presentation.view.model.EmptyViewModel;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.List;

/**
 * Created by Nelson on 13/08/2016.
 */
@Parcel(Parcel.Serialization.BEAN)
public class GameDataModel extends EmptyViewModel {

  List<ScoreModel> scoreList;

  String response;

  String currency;

  @ParcelConstructor
  public GameDataModel(List<ScoreModel> scoreList, String response, String currency) {
    this.scoreList = scoreList;
    this.response = response;
    this.currency = currency;
  }

  public List<ScoreModel> getScoreList() {
    return scoreList;
  }

  public String getResponse() {
    return response;
  }

  public String getCurrency() {
    return currency;
  }

  @Override
  public String toString() {
    return "GameDataModel{" +
        "scoreList=" + scoreList.toString() +
        ", response='" + response + '\'' +
        ", currency='" + currency + '\'' +
        '}';
  }

}
