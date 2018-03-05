package MedicalChain.App.Controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HistoryService {

    List<History> histories = new ArrayList<>(Arrays.asList(
            new History("Spring", "Spring Boot", "Spring based annotations"),
            new History("Haskell", "Haskell", "Haskell and Go"),
            new History("Kotlin", "Kotlin", "Kotlin Lang")
    ));

    public List<History> getAllHistories() {
        return histories;
    }

    public History getHistory(String id) {
        return histories.stream().filter(x -> x.getId().equals(id)).findFirst().get();
    }

    public void addHistory(History history) {
        histories.add(history);
    }

    public void updateHistory(String id, History history) {
        for (int i = 0; i < histories.size(); i++) {
            History hist = histories.get(i);
            if(hist.getId().equals(id)) {
                histories.set(i, history);
                return;
            }
        }
    }

    public void deleteHistory(String id) {
        histories.removeIf(x -> x.getId().equals(id));
    }
}
