package asw.streamKafka;


//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    public String landing(Model model) {
        return "index";
    }



}