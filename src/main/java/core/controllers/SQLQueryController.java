package core.controllers;

import core.persistence.IQueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;

/**
 * Created by Marcin on 2016-03-09.
 */

@RestController
public class SQLQueryController {

    @Autowired
    IQueryExecutor queryExecutor;


    @RequestMapping(name = "/query", method = RequestMethod.POST)
    @ResponseBody
    ResultSet handleSQLQuery(@RequestBody String query) {

        return queryExecutor.executeQuery(query);

    }

}
