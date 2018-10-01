package com.test.botalov.resultanttestapplication.Main.View;

import com.test.botalov.resultanttestapplication.Main.Model.Entities.Data;

public interface IMainView {
    void showLoader();
    void hideLoader();
    void showError();
    void updateData(Data data);
}
