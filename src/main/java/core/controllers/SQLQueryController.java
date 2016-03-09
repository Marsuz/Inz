package core.controllers;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Marcin on 2016-03-09.
 */

@RestController
public class SQLQueryController {

    @RequestMapping(name = "/query", method = RequestMethod.POST)
    @ResponseBody
    String handleSQLQuery(@RequestBody String query) {

        return "Query " + query + " processed";

    }

}
