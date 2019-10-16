package com.test.qa.testdata;

import com.test.qa.utils.ExcelDataConfig;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class AddTrackerData extends ExcelDataConfig {
    private static final Logger LOGGER = Logger.getLogger(AddTrackerData.class);

    public AddTrackerData() {
        super("src\\test\\resources\\ExcelSheet\\AddKPI.xlsx");
    }

    @DataProvider(name = "AddTrackerExcel")
    public Object[][] AddTrackerExcel() {

        int rows = getRowCount("Tracker");
        int col = getColumnCount("Tracker");


        LOGGER.info("row = " + rows + " columns = " + col);

        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = getData("Tracker", i, j);
            }
        }
        return data;
    }
}
