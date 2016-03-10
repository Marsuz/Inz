package core.controllers;

import core.persistence.IQueryExecutor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-03-09.
 */

@RestController
public class SQLQueryController {

    @Autowired
    IQueryExecutor queryExecutor;

    final static Logger logger = LoggerFactory.getLogger(SQLQueryController.class);

    @RequestMapping(name = "/query", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<List> handleSQLQuery(@RequestBody String query) {

        List result = queryExecutor.executeQuery(query);
        return new ResponseEntity<List>(result, HttpStatus.OK);

    }

}
