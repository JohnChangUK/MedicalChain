package MedicalChain.App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/history")
    public List<History> getAllHistory() {
        return historyService.getAllHistories();
    }

    @RequestMapping("/history/{id}")
    public History getHistory(@PathVariable String id) {
        return historyService.getHistory(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/history")
    public void createHistory(@RequestBody History history) {
        historyService.addHistory(history);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/history/{id}")
    public void updateHistory(@RequestBody History history, @PathVariable String id) {
        historyService.updateHistory(id, history);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/history/{id}")
    public void deleteHistory(@PathVariable String id) {
        historyService.deleteHistory(id);
    }
}
