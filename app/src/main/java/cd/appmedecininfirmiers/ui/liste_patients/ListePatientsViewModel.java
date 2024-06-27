package cd.appmedecininfirmiers.ui.liste_patients;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListePatientsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ListePatientsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}