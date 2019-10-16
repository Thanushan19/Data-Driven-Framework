package com.test.qa.testdata;

import com.test.qa.utils.ExcelDataConfig;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class UserLogin extends ExcelDataConfig {
    private static final Logger LOGGER = Logger.getLogger(UserLogin.class);

    public UserLogin() {
        super("src\\test\\resources\\ExcelSheet\\Logins.xlsx");
    }

    @DataProvider(name = "OrangeHRMUserLogin")
    public Object[][] OrangeHRMUserLogin() {

        int rows = getRowCount("Sheet1");
        int col = getColumnCount("Sheet1");


        LOGGER.info("row = " + rows + " columns = " + col);

        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = getData("Sheet1", i, j);
            }
        }
        return data;
    }

}

